package starter;


// ╔══════════════════════════════════════════════════════════════╗
// ║  LECCIÓN 5: POO — ARCHIVO INICIAL (STARTER)                 ║
// ╚══════════════════════════════════════════════════════════════╝
//
//  INSTRUCCIONES:
//  Completa los bloques marcados con TODO.
//  Cuando termines, haz clic en ▶ Run junto a main() para probar.
//
//  Si algo no compila: compara con leccion5/Leccion5_POO.java
//
// ══════════════════════════════════════════════════════════════

import java.util.Scanner;
import java.util.Random;

// -------------------------------------------------------
// TODO 1: Define la interfaz Habilidad con dos métodos:
//   void usarHabilidad(PersonajeS enemigo)
//   String getNombreHabilidad()
// -------------------------------------------------------
// interface Habilidad { ... }


// -------------------------------------------------------
// La clase abstracta ya está escrita — léela con atención
// -------------------------------------------------------
abstract class PersonajeS {

    private String nombre;
    private int vida;
    private int vidaMaxima;
    private int ataque;
    private int pociones;
    protected Random rand = new Random();

    public PersonajeS(String nombre, int vida, int ataque, int pociones) {
        this.nombre     = nombre;
        this.vida       = vida;
        this.vidaMaxima = vida;
        this.ataque     = ataque;
        this.pociones   = pociones;
    }

    public String getNombre()  { return nombre; }
    public int getVida()       { return vida; }
    public int getVidaMaxima() { return vidaMaxima; }
    public int getAtaque()     { return ataque; }
    public int getPociones()   { return pociones; }

    // TODO 2: implementa setVida — la vida nunca puede bajar de 0
    public void setVida(int vida) {
        // Escribe aquí...
    }

    // TODO 3: declara el método abstracto atacar()
    // public abstract void atacar(PersonajeS enemigo);

    // TODO 4: implementa usarPocion()
    // Cura 30 de vida (sin superar vidaMaxima), descuenta 1 poción.
    // Si pociones == 0, imprime "¡No te quedan pociones!"
    public void usarPocion() {
        // Escribe aquí...
    }

    // TODO 5: implementa mostrarEstado()
    // Formato: "Nombre | Vida: X/Y | Ataque: Z | Pociones: W"
    public void mostrarEstado() {
        // Escribe aquí...
    }

    public boolean estaVivo() {
        return getVida() > 0;
    }
}

// -------------------------------------------------------
// TODO 6: crea la clase GuerreroS que extienda PersonajeS
//         e implemente Habilidad
//   Stats: super(nombre, 120, 18, 3)
//   atacar()        → daño = ataque + rand.nextInt(6)
//   usarHabilidad() → daño = ataque * 2  (nombre: "Golpe Brutal")
// -------------------------------------------------------
// class GuerreroS extends PersonajeS implements Habilidad { ... }


// -------------------------------------------------------
// TODO 7: crea la clase MagoS que extienda PersonajeS
//         e implemente Habilidad
//   Stats: super(nombre, 80, 22, 2)
//   atacar()        → daño = ataque + rand.nextInt(10)
//   usarHabilidad() → daño fijo = 50  (nombre: "Bola de Fuego")
// -------------------------------------------------------
// class MagoS extends PersonajeS implements Habilidad { ... }


// -------------------------------------------------------
// TODO 8: crea la clase DragonOscuroS que extienda PersonajeS
//   Stats: super("Dragón Oscuro", 150, 14, 0)
//   atacar() → daño = ataque + rand.nextInt(10)
// -------------------------------------------------------
// class DragonOscuroS extends PersonajeS { ... }


// -------------------------------------------------------
// CLASE PRINCIPAL — no la modifiques, solo completa los TODO de arriba
// -------------------------------------------------------
public class Leccion5_POO_STARTER {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("╔══════════════════════════════╗");
        System.out.println("║       COMBATE RPG - JAVA      ║");
        System.out.println("╚══════════════════════════════╝\n");

        System.out.print("¿Cómo se llama tu personaje? ");
        String nombre = scanner.nextLine();

        System.out.println("\nElige tu clase:");
        System.out.println("  1. Guerrero — 120 vida | 18 ataque | 3 pociones | Habilidad: Golpe Brutal");
        System.out.println("  2. Mago     —  80 vida | 22 ataque | 2 pociones | Habilidad: Bola de Fuego");
        System.out.print("Elige (1/2): ");
        String claseElegida = scanner.nextLine();

        // TODO 9: instancia heroe y habilidad según la clase elegida
        // (descomenta y completa cuando hayas definido GuerreroS y MagoS)
        PersonajeS heroe   = null;
        //Habilidad  habilidad = null;
        /*
        if (claseElegida.equals("2")) {
            MagoS mago = new MagoS(nombre);
            heroe      = mago;
            habilidad  = mago;
        } else {
            GuerreroS guerrero = new GuerreroS(nombre);
            heroe              = guerrero;
            habilidad          = guerrero;
        }
        */

        // TODO 10: instancia el enemigo
        // PersonajeS enemigo = new DragonOscuroS();
        PersonajeS enemigo = null;

        if (heroe == null || enemigo == null) {
            System.out.println("⚠ Completa los TODO antes de ejecutar el combate.");
            scanner.close();
            return;
        }

        boolean habilidadUsada = false;
        int turno = 1;

        System.out.println("\n=== COMBATIENTES ===");
        heroe.mostrarEstado();
        enemigo.mostrarEstado();
        System.out.println("\n¡Que comience el combate!\n");

        while (heroe.estaVivo() && enemigo.estaVivo()) {

            System.out.println("════════════════════════════");
            System.out.println("  Turno " + turno);
            System.out.println("  Tu vida: " + heroe.getVida() + "/" + heroe.getVidaMaxima() +
                    " | Pociones: " + heroe.getPociones());
            System.out.println("  Vida enemigo: " + enemigo.getVida());
            System.out.println("════════════════════════════");
            System.out.println("¿Qué haces?");
            System.out.println("  1. Atacar");
            System.out.println("  2. Usar poción");
            if (!habilidadUsada) {
                //System.out.println("  3. Habilidad especial: " + habilidad.getNombreHabilidad());
            }
            System.out.println("  4. Retirarse");
            System.out.print("Elige: ");
            String opcion = scanner.nextLine();
            System.out.println();

            if (opcion.equals("1")) {
                //heroe.atacar(enemigo);
            } else if (opcion.equals("2")) {
                heroe.usarPocion();
            } else if (opcion.equals("3") && !habilidadUsada) {
                //habilidad.usarHabilidad(enemigo);
                habilidadUsada = true;
                System.out.println("(Habilidad especial usada — solo disponible una vez)");
            } else if (opcion.equals("4")) {
                System.out.println(heroe.getNombre() + " se retira. ¡Hasta la próxima!");
                scanner.close();
                return;
            } else {
                System.out.println("Opción no válida. ¡Pierdes el turno!");
            }

            if (enemigo.estaVivo()) {
                System.out.println();
                //enemigo.atacar(heroe);
            }

            System.out.println();
            turno++;
        }

        System.out.println("╔══════════════════════════════╗");
        System.out.println("║       FIN DEL COMBATE         ║");
        System.out.println("╚══════════════════════════════╝\n");

        if (heroe.estaVivo()) {
            System.out.println("¡VICTORIA! " + heroe.getNombre() +
                    " ha derrotado al " + enemigo.getNombre() + "!");
        } else {
            System.out.println("DERROTA. ¡Inténtalo de nuevo!");
        }

        scanner.close();
    }
}

