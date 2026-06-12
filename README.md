# Combate RPG — Curso de Introducción a Java y POO

**Edad:** 12–17 años · **Duración:** ~1 hora · **Nivel:** Principiante absoluto

---

## Requisitos

- Contar con un navegador web.
- Utilizar herramientas de codigo abierto en linea.

(https://www.onlinegdb.com/online_java_compiler)

---

## Estructura del proyecto

```
java-rpg-course/
│
├── README.md
└── src/
    ├── leccion1/
    │   └── Leccion1_Introduccion.java       ← Presentación (sin código)
    ├── leccion2/
    │   └── Leccion2_Variables.java          ← Variables y tipos de datos
    ├── leccion3/
    │   └── Leccion3_EstructurasControl.java ← if/else y while
    ├── leccion4/
    │   └── Leccion4_Metodos.java            ← Métodos y Scanner
    ├── leccion5/
    │   └── Leccion5_POO.java                ← POO completa juego final
    ├── leccion5starter/
    │   └── Leccion5_POO_STARTER.java        ← archivo para completar
    ├── leccion6/
    │   └── Leccion6_ProximosPasos.java      ← Cierre y retos
    └── main/
        └── Main.java                        ← Juego unificado (versión limpia)
```

> **¿Por qué carpetas separadas?**
> Cada lección define sus propias clases (Personaje, Guerrero, etc.).
> Si estuvieran en la misma carpeta, Java se quejaría de "duplicate class".
> Al usar paquetes separados, cada lección vive en su propio espacio y no interfiere con las demás.

---

## Temario

| Lección | Archivo | Tema |
|---------|---------|------|
| 1 | `leccion1/Leccion1_Introduccion.java` | ¿Qué es Java? Presentación del proyecto |
| 2 | `leccion2/Leccion2_Variables.java` | Variables: `String`, `int`, `boolean` |
| 3 | `leccion3/Leccion3_EstructurasControl.java` | `if/else`, `while`, daño aleatorio |
| 4 | `leccion4/Leccion4_Metodos.java` | Métodos, `Scanner`, menú interactivo |
| 5 | `leccion5/Leccion5_POO.java` | POO completa — juego jugable |
| 6 | `leccion6/Leccion6_ProximosPasos.java` | Recursos y retos para seguir |
| — | `main/Main.java` | Juego final unificado y comentado |

---

## Archivo STARTER (para practicar)

El archivo `leccion5starter/Leccion5_POO_STARTER.java` tiene el esqueleto de la lección 5 con marcadores `TODO 1` al `TODO 10`.

**Cómo usarlo:**
1. Abre `leccion5starter/Leccion5_POO_STARTER.java`
2. Lee cada `TODO` y escribe el código correspondiente
3. Haz clic en ▶ junto a `main()` para probar
4. Si hay errores, compara con `leccion5/Leccion5_POO.java`

---

## El juego

Al terminar el curso habrás construido un combate RPG con:
- **Guerrero** (120 vida, 18 ataque, 3 pociones) → habilidad: Golpe Brutal
- **Mago** (80 vida, 22 ataque, 2 pociones) → habilidad: Bola de Fuego
- **Dragón Oscuro** como enemigo (150 vida)
- Daño aleatorio, pociones y habilidades especiales

---

## Retos para seguir

| Nivel | Reto |
|-------|------|
| Fácil | Agrega un **Arquero** como tercera clase jugable |
| Fácil | Cambia los valores de vida y ataque de cada clase |
| Medio | Haz que la habilidad se recargue cada 3 turnos |
| Medio | Agrega un segundo enemigo más fuerte tras el dragón |
| Difícil | Sistema de niveles: al ganar, el héroe sube de nivel |
| Difícil | Inventario con distintos tipos de pociones |

---

## Recursos para continuar

- **Oracle Java Tutorials** → [docs.oracle.com/javase/tutorial](https://docs.oracle.com/javase/tutorial)
- **Codecademy Java** → [codecademy.com/learn/learn-java](https://www.codecademy.com/learn/learn-java)

---

> *La programación no es para genios. Es para personas curiosas que no se rinden.*