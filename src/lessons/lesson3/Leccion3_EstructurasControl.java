package lessons.lesson3;


// ╔══════════════════════════════════════════════════════════════╗
// ║  LECCIÓN 3: Estructuras de control (10 minutos)             ║
// ╚══════════════════════════════════════════════════════════════╝
//
//  ¿Qué es un if/else?
//  → Una decisión: SI pasa algo, haz esto. SI NO, haz esto otro.
//
//  ¿Qué es un while?
//  → Un bucle: MIENTRAS algo sea verdad, repite esto.
//
//  ¿Qué es turno++?
//  → Es igual a escribir: turno = turno + 1
//
//  AVANCE DEL JUEGO:
//  Agregamos la lógica de turnos y decidimos quién gana.
//  El daño ya es aleatorio usando Random.
//
// ══════════════════════════════════════════════════════════════

import java.util.Random;

public class Leccion3_EstructurasControl {
    public static void main(String[] args) {

        Random rand = new Random();

        String nombreHeroe = "Kael";
        int vidaHeroe      = 120;
        int ataqueHeroe    = 18;

        String nombreEnemigo = "Dragón Oscuro";
        int vidaEnemigo      = 150;
        int ataqueEnemigo    = 14;

        int turno = 1;

        System.out.println("=== ¡QUE COMIENCE EL COMBATE! ===\n");

        while (vidaHeroe > 0 && vidaEnemigo > 0) {

            System.out.println("--- Turno " + turno + " ---");

            int danoHeroe = ataqueHeroe + rand.nextInt(6);
            vidaEnemigo   = vidaEnemigo - danoHeroe;
            System.out.println(nombreHeroe + " ataca por " + danoHeroe + " puntos!");
            System.out.println(nombreEnemigo + " le queda " + Math.max(0, vidaEnemigo) + " de vida.");

            if (vidaEnemigo > 0) {
                int danoEnemigo = ataqueEnemigo + rand.nextInt(8);
                vidaHeroe       = vidaHeroe - danoEnemigo;
                System.out.println(nombreEnemigo + " contraataca por " + danoEnemigo + " puntos!");
                System.out.println(nombreHeroe + " le queda " + Math.max(0, vidaHeroe) + " de vida.");
            }

            System.out.println();
            turno++;
        }

        System.out.println("=== FIN DEL COMBATE ===");
        if (vidaHeroe > 0) {
            System.out.println("¡VICTORIA! " + nombreHeroe + " ha ganado!");
        } else {
            System.out.println("DERROTA. El " + nombreEnemigo + " fue demasiado poderoso.");
        }
    }
}
