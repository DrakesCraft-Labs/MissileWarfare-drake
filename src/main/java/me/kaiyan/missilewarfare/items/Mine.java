package me.kaiyan.missilewarfare.items;

import com.github.drakescraft_labs.slimefun4.api.items.ItemGroup;
import com.github.drakescraft_labs.slimefun4.api.items.SlimefunItem;
import com.github.drakescraft_labs.slimefun4.api.items.SlimefunItemStack;
import com.github.drakescraft_labs.slimefun4.api.recipes.RecipeType;
import com.github.drakescraft_labs.slimefun4.core.handlers.BlockPlaceHandler;
import me.kaiyan.missilewarfare.MissileWarfare;
import me.kaiyan.missilewarfare.integrations.WorldGuardLoader;
import com.github.drakescraft_labs.slimefun4.legacy.api.BlockStorage;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Mine extends SlimefunItem implements Listener {

    // Evita multi-explosión: bloquea la misma ubicación hasta que el bloque desaparezca
    private static final Set<Location> detonating = Collections.synchronizedSet(new HashSet<>());

    public Mine(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);


        BlockPlaceHandler placeHandler = new BlockPlaceHandler(false) {
            @Override
            public void onPlayerPlace(BlockPlaceEvent blockPlaceEvent) {
                Material type = blockPlaceEvent.getBlockAgainst().getType();
                if (type == Material.BEDROCK || type == Material.ICE){
                    return;
                }
                blockPlaceEvent.getBlockPlaced().setType(type);
            }
        };
        addItemHandler(placeHandler);

        MissileWarfare.getInstance().getServer().getPluginManager().registerEvents(this, MissileWarfare.getInstance());
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event){
        // Ignorar movimientos que no cambian de bloque (reduce llamadas ~10x)
        if (!event.hasChangedBlock()) return;

        var mineBlock = event.getFrom().getBlock().getRelative(BlockFace.DOWN);
        if (!BlockStorage.check(mineBlock, getId())) return;

        Location mineLoc = mineBlock.getLocation();
        // Cooldown: si ya está detonando este bloque, no explotar de nuevo
        if (!detonating.add(mineLoc)) return;

        float power = MissileWarfare.getInstance().getConfig().getInt("mine.explosivepower");
        double damage = Math.random() * MissileWarfare.getInstance().getConfig().getLong("mine.maxranddamage");

        if (MissileWarfare.worldGuardEnabled) {
            Vector posVec = new Vector(mineLoc.getX(), mineLoc.getY(), mineLoc.getZ());
            WorldGuardLoader.explode(event.getPlayer().getWorld(), posVec, power, null, event.getPlayer());
        } else {
            event.getPlayer().getWorld().createExplosion(mineLoc.toVector().toLocation(event.getPlayer().getWorld()), power);
        }
        event.getPlayer().damage(damage);

        // Liberar el cooldown tras 10 ticks (el bloque ya habrá desaparecido por la explosión)
        org.bukkit.Bukkit.getScheduler().runTaskLater(MissileWarfare.getInstance(), () -> detonating.remove(mineLoc), 10L);
    }
}
