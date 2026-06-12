package lessons.lesson4;


// ╔══════════════════════════════════════════════════════════════╗
// ║  LECCIÓN 4: Métodos, Entrada/Salida e Intro a POO (12 min)  ║
// ╚══════════════════════════════════════════════════════════════╝
//
//  ¿Qué es un método?
//  → Un bloque de código con nombre que hace una tarea específica.
//  → Lo escribes una vez y lo llamas cuando lo necesitas.
//
//  ¿Qué es Scanner?
//  → Una herramienta que lee lo que escribe el usuario.
//
//  AVANCE DEL JUEGO:
//  Organizamos el ataque en métodos y el jugador elige su clase.
//
// ══════════════════════════════════════════════════════════════

import java.util.Scanner;
import java.util.Random;

public class Leccion4_Metodos {

    static Random rand = new Random();

    static void atacar(String atacante, String defensor, int ataque, int[] vidaDefensor) {
        int dano = ataque + rand.nextInt(6);
        vidaDefensor[0] = Math.max(0, vidaDefensor[0] - dano);
        System.out.println(atacante + " ataca a " + defensor + " por " + dano + " puntos!");
        System.out.println(defensor + " le queda " + vidaDefensor[0] + " de vida.");
    }

    static void mostrarEstado(String nombre, int vida, int vidaMax, int pociones) {
        System.out.println(nombre + " | Vida: " + vida + "/" + vidaMax +
                " | Pociones: " + pociones);
    }

    static int usarPocion(String nombre, int vida, int vidaMax, int[] pociones) {
        if (pociones[0] > 0) {
            int curacion = 30;
            vida = Math.min(vida + curacion, vidaMax);
            pociones[0]--;
            System.out.println(nombre + " usa una poción y recupera " + curacion + " de vida!");
            System.out.println("Vida actual: " + vida + " | Pociones restantes: " + pociones[0]);
        } else {
            System.out.println("¡No te quedan pociones!");
        }
        return vida;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("╔══════════════════════════════╗");
        System.out.println("║       COMBATE RPG - JAVA      ║");
        System.out.println("╚══════════════════════════════╝\n");

        System.out.print("¿Cómo se llama tu personaje? ");
        String nombre = scanner.nextLine();

        System.out.println("\nElige tu clase:");
        System.out.println("  1. Guerrero — 120 vida | 18 ataque | 3 pociones");
        System.out.println("  2. Mago     —  80 vida | 22 ataque | 2 pociones");
        System.out.print("Elige (1/2): ");
        String clase = scanner.nextLine();

        int vidaHeroe, ataqueHeroe;
        int[] pociones;

        if (clase.equals("2")) {
            vidaHeroe   = 80;
            ataqueHeroe = 22;
            pociones    = new int[]{2};
        } else {
            vidaHeroe   = 120;
            ataqueHeroe = 18;
            pociones    = new int[]{3};
        }

        int vidaMaxHeroe  = vidaHeroe;
        int vidaEnemigo   = 150;
        int ataqueEnemigo = 14;
        int[] pocionesRef = pociones;
        int[] vidaEnemRef = {vidaEnemigo};
        int[] vidaHerRef  = {vidaHeroe};
        int turno         = 1;

        System.out.println("\n=== COMBATIENTES ===");
        mostrarEstado(nombre, vidaHeroe, vidaMaxHeroe, pocionesRef[0]);
        System.out.println("Dragón Oscuro | Vida: " + vidaEnemigo);
        System.out.println("\n¡Que comience el combate!\n");

        while (vidaHerRef[0] > 0 && vidaEnemRef[0] > 0) {

            System.out.println("════════════════════════════");
            System.out.println("  Turno " + turno);
            mostrarEstado(nombre, vidaHerRef[0], vidaMaxHeroe, pocionesRef[0]);
            System.out.println("  Vida enemigo: " + vidaEnemRef[0]);
            System.out.println("════════════════════════════");
            System.out.println("¿Qué haces?");
            System.out.println("  1. Atacar");
            System.out.println("  2. Usar poción");
            System.out.println("  3. Retirarse");
            System.out.print("Elige: ");
            String opcion = scanner.nextLine();
            System.out.println();

            if (opcion.equals("1")) {
                atacar(nombre, "Dragón Oscuro", ataqueHeroe, vidaEnemRef);
            } else if (opcion.equals("2")) {
                vidaHerRef[0] = usarPocion(nombre, vidaHerRef[0], vidaMaxHeroe, pocionesRef);
            } else if (opcion.equals("3")) {
                System.out.println(nombre + " se retira. ¡Hasta la próxima!");
                scanner.close();
                return;
            } else {
                System.out.println("Opción no válida. ¡Pierdes el turno!");
            }

            if (vidaEnemRef[0] > 0) {
                System.out.println();
                atacar("Dragón Oscuro", nombre, ataqueEnemigo, vidaHerRef);
            }

            System.out.println();
            turno++;
        }

        System.out.println("=== FIN DEL COMBATE ===");
        if (vidaHerRef[0] > 0) {
            System.out.println("¡VICTORIA! " + nombre + " ha derrotado al Dragón Oscuro!");
        } else {
            System.out.println("DERROTA. ¡Inténtalo de nuevo!");
        }

        scanner.close();
    }
}
