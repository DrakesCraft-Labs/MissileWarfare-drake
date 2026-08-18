<p align="center">
  <img src="https://raw.githubusercontent.com/DrakesCraft-Labs/MissileWarfare-drake/main/banner.svg" width="100%" alt="MISSILE WARFARE animated banner" />
</p>

# MissileWarfare-drake

> ### 🏰 ¡Únete a la Comunidad Oficial de DrakesCraft!
> 
> * 🎮 **IP del Servidor**: `play.drakescraft.net` *(Java 1.21.11 & Bedrock)*
> * 💬 **Discord Oficial**: [discord.gg/drakescraft](https://discord.gg/rR7FbfCt9Y)
> * 🌐 **Web & Guía**: [drakescraft.net](https://drakescraft.net) — 🛒 **Tienda**: [tienda.drakescraft.net](https://tienda.drakescraft.net)
> 
> *¡Juega con este addon y más de 80 expansiones optimizadas en vivo en nuestra network de supervivencia técnica!*

---

[![Rama](https://img.shields.io/badge/branch-1.21--latin-2ea44f)](https://github.com/DrakesCraft-Labs/MissileWarfare-drake/tree/1.21-latin)
[![License](https://img.shields.io/github/license/DrakesCraft-Labs/MissileWarfare-drake)](https://github.com/DrakesCraft-Labs/MissileWarfare-drake/blob/1.21-latin/LICENSE)
[![Ultimo commit](https://img.shields.io/github/last-commit/DrakesCraft-Labs/MissileWarfare-drake/1.21-latin)](https://github.com/DrakesCraft-Labs/MissileWarfare-drake/commits/1.21-latin)

## Descripción técnica
Addon de combate con misiles/armamento integrado al ecosistema Slimefun.

## Qué añade a Slimefun
- Contenido PvP/PvE avanzado para servidores con enfoque combate.
- Nuevas opciones tácticas y de defensa.
- Amplía la rama de armamento tecnológico en Slimefun.

## Características principales
- Misiles y utilidades bélicas con configuración de variantes.
- Integraciones condicionales con plugins de protección.
- Ajustes de partículas/compat API para 1.21.

## Matriz de compatibilidad
| Componente | Estado |
|---|---|
| Minecraft | 1.21.x |
| Paper/Purpur | 1.21.x |
| Slimefun Core Drake | 11.x (línea `1.21-latin`) |
| Java | 21 |

## Instalación
1. Descarga el `.jar` de Releases del repositorio.
2. Copia el archivo en la carpeta `plugins/` del servidor.
3. Asegura dependencias (`Slimefun`, `ProtocolLib` u otras según addon).
4. Reinicia el servidor y revisa `logs/latest.log` para validar carga.

## Build local
```bash
mvn -DskipTests clean package
```

Artefacto esperado:
- `target/MissileWarfare-*.jar`

## Flujo de release
1. Crear branch de cambios (`feature/*` o `fix/*`).
2. Abrir PR hacia `1.21-latin` con plan de pruebas.
3. Al mergear, crear tag/release y publicar jar compilado.

Validar seguridad de daño/zonas protegidas antes de release público.

## Relación con el monorepo
Este repositorio se mantiene en paralelo con `drakes-slimefun-labs` para desarrollo aislado por addon y despliegues independientes.

## Qué añade al juego

A addon for slimefun that aims to incorporate missiles into the game, slowing down combat
Registra alrededor de **53 objetos** en la guía de Slimefun.

Todo se fabrica y se investiga desde la guía normal (`/sf guide`), como cualquier otro contenido
de Slimefun: no hace falta ningún comando especial para empezar.

## Compatibilidad

| | |
|---|---|
| Servidor | Paper / Purpur **1.21.11** |
| Java | **21** |
| Requiere | [Slimefun4-Drake](https://github.com/DrakesCraft-Labs/Slimefun4-Drake) |
| Lado | Solo servidor — quien juega no instala nada |
| Versión | ${project.version} |

## Instalación

1. Descarga el `.jar` de la última versión.
2. Déjalo en la carpeta `plugins/` del servidor, junto a Slimefun.
3. Reinicia el servidor. Los objetos aparecen solos en la guía.

> Este addon está portado al fork de Slimefun de DrakesCraft. Con el Slimefun original puede no
> cargar, porque cambia el espacio de nombres de las clases.

## Créditos
- kaiyan2006

Port y mantenimiento por **DrakesCraft Labs**. La autoría original es de quien figura arriba; el detalle está en [docs/UPSTREAM_ATTRIBUTION.md](https://raw.githubusercontent.com/DrakesCraft-Labs/MissileWarfare-drake/main/docs/UPSTREAM_ATTRIBUTION.md).

Licencia **GPL-3.0-only**.
