// ╔══════════════════════════════════════════════════════════════╗
// ║  LECCIÓN 2: Variables y tipos de datos (8 minutos)          ║
// ╚══════════════════════════════════════════════════════════════╝
//
//  ¿Qué es una variable?
//  → Una caja con nombre donde guardamos información.
//
//  Tipos de datos que usamos hoy:
//  → String  : texto            Ejemplo: "Guerrero"
//  → int     : números enteros  Ejemplo: 100
//  → double  : números decimal  Ejemplo: 1.5
//  → boolean : verdadero/falso  Ejemplo: true
//
//  🎮 AVANCE DEL JUEGO:
//  Definimos las primeras variables del héroe y del enemigo.
//  Estos son los datos que más adelante vivirán dentro de clases.
//
// ══════════════════════════════════════════════════════════════

public class Leccion2_Variables {
    public static void main(String[] args) {

        // --- Variables del héroe ---
        String nombreHeroe  = "Kael";       // nombre del jugador
        int vidaHeroe       = 120;          // puntos de vida
        int ataqueHeroe     = 18;           // puntos de ataque
        int pociones        = 3;            // pociones disponibles
        boolean estaVivo    = true;         // ¿está vivo?

        // --- Variables del enemigo ---
        String nombreEnemigo = "Dragón Oscuro";
        int vidaEnemigo      = 150;
        int ataqueEnemigo    = 14;

        // --- Mostramos los datos en pantalla ---
        System.out.println("=== HÉROE ===");
        System.out.println("Nombre  : " + nombreHeroe);
        System.out.println("Vida    : " + vidaHeroe);
        System.out.println("Ataque  : " + ataqueHeroe);
        System.out.println("Pociones: " + pociones);
        System.out.println("¿Vivo?  : " + estaVivo);

        System.out.println("\n=== ENEMIGO ===");
        System.out.println("Nombre : " + nombreEnemigo);
        System.out.println("Vida   : " + vidaEnemigo);
        System.out.println("Ataque : " + ataqueEnemigo);
    }
}
