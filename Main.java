// ╔══════════════════════════════════════════════════════════════╗
// ║           COMBATE RPG - JUEGO COMPLETO EN JAVA               ║
// ║           Curso: Introducción a Java y POO                   ║
// ║           Edad: 12-17 años | Duración: 1 hora                ║
// ╚══════════════════════════════════════════════════════════════╝
//
//  POO aplicada al 100%:
//  ✔ Encapsulamiento  — atributos private + getters/setters
//  ✔ Abstracción      — clase abstracta Personaje
//  ✔ Herencia         — Guerrero, Mago y DragonOscuro extienden Personaje
//  ✔ Polimorfismo     — cada clase implementa su propio atacar()
//  ✔ Interfaces       — Habilidad define el contrato de habilidades especiales
//
//  LECCIÓN 1 → Presentación del proyecto
//  LECCIÓN 2 → Variables: nombre, vida, ataque, pociones
//  LECCIÓN 3 → Estructuras de control: while, if/else, Random
//  LECCIÓN 4 → Métodos: atacar(), usarPocion(), mostrarEstado()
//  LECCIÓN 5 → POO: interfaz, clase abstracta, herencia, polimorfismo
//  LECCIÓN 6 → Cierre y retos para seguir
//
// ══════════════════════════════════════════════════════════════

import java.util.Scanner;
import java.util.Random;

// -------------------------------------------------------
// [LECCIÓN 5] INTERFAZ: Habilidad
// Obliga a cada personaje jugable a definir su habilidad especial
// -------------------------------------------------------
interface Habilidad {
    void usarHabilidad(Personaje enemigo);      // qué hace la habilidad
    String getNombreHabilidad();                // cómo se llama
}

// -------------------------------------------------------
// [LECCIÓN 5] CLASE ABSTRACTA: Personaje
// Nadie puede instanciar Personaje directamente —
// solo sus subclases: Guerrero, Mago, DragonOscuro
// -------------------------------------------------------
abstract class Personaje {

    // [LECCIÓN 2] Atributos PRIVADOS — encapsulamiento
    private String nombre;
    private int vida;
    private int vidaMaxima;
    private int ataque;
    private int pociones;
    protected Random rand = new Random();

    // [LECCIÓN 5] Constructor
    public Personaje(String nombre, int vida, int ataque, int pociones) {
        this.nombre     = nombre;
        this.vida       = vida;
        this.vidaMaxima = vida;
        this.ataque     = ataque;
        this.pociones   = pociones;
    }

    // GETTERS — única forma de leer los atributos desde afuera
    public String getNombre()  { return nombre; }
    public int getVida()       { return vida; }
    public int getVidaMaxima() { return vidaMaxima; }
    public int getAtaque()     { return ataque; }
    public int getPociones()   { return pociones; }

    // SETTER — con validación: la vida nunca baja de 0
    public void setVida(int vida) {
        this.vida = Math.max(0, vida);
    }

    // [LECCIÓN 5] MÉTODO ABSTRACTO — cada subclase define su propio ataque
    public abstract void atacar(Personaje enemigo);

    // [LECCIÓN 4] MÉTODOS CONCRETOS — iguales para todos los personajes
    public void usarPocion() {
        if (pociones > 0) {
            int curacion = 30;
            setVida(Math.min(getVida() + curacion, vidaMaxima));
            pociones--;
            System.out.println(getNombre() + " usa una poción y recupera " + curacion + " de vida!");
            System.out.println("Vida actual: " + getVida() + "/" + getVidaMaxima() +
                               " | Pociones restantes: " + pociones);
        } else {
            System.out.println("¡No te quedan pociones!");
        }
    }

    public void mostrarEstado() {
        System.out.println(getNombre() + " | Vida: " + getVida() + "/" + getVidaMaxima() +
                           " | Ataque: " + getAtaque() + " | Pociones: " + getPociones());
    }

    public boolean estaVivo() {
        return getVida() > 0;
    }
}

// -------------------------------------------------------
// [LECCIÓN 5] SUBCLASE: Guerrero
// Herencia + Polimorfismo + Interfaz Habilidad
// -------------------------------------------------------
class Guerrero extends Personaje implements Habilidad {

    public Guerrero(String nombre) {
        super(nombre, 120, 18, 3); // más vida, buen ataque, 3 pociones
    }

    // [LECCIÓN 5] Polimorfismo: ataque físico con varianza pequeña
    @Override
    public void atacar(Personaje enemigo) {
        int dano = getAtaque() + rand.nextInt(6);
        enemigo.setVida(enemigo.getVida() - dano);
        System.out.println(getNombre() + " golpea a " + enemigo.getNombre() + " por " + dano + " puntos!");
        if (enemigo.estaVivo()) {
            System.out.println(enemigo.getNombre() + " le queda " + enemigo.getVida() + " de vida.");
        } else {
            System.out.println(enemigo.getNombre() + " ha caído ante tu fuerza!");
        }
    }

    // Habilidad especial: daño doble
    @Override
    public void usarHabilidad(Personaje enemigo) {
        int dano = getAtaque() * 2;
        enemigo.setVida(enemigo.getVida() - dano);
        System.out.println("⚔️  ¡GOLPE BRUTAL! " + getNombre() + " aplasta a " +
                           enemigo.getNombre() + " por " + dano + " puntos!");
        if (enemigo.estaVivo()) {
            System.out.println(enemigo.getNombre() + " le queda " + enemigo.getVida() + " de vida.");
        } else {
            System.out.println(enemigo.getNombre() + " ha sido aplastado!");
        }
    }

    @Override
    public String getNombreHabilidad() { return "Golpe Brutal (daño doble)"; }
}

// -------------------------------------------------------
// [LECCIÓN 5] SUBCLASE: Mago
// Herencia + Polimorfismo + Interfaz Habilidad
// -------------------------------------------------------
class Mago extends Personaje implements Habilidad {

    public Mago(String nombre) {
        super(nombre, 80, 22, 2); // menos vida, más ataque, 2 pociones
    }

    // [LECCIÓN 5] Polimorfismo: ataque mágico con varianza alta
    @Override
    public void atacar(Personaje enemigo) {
        int dano = getAtaque() + rand.nextInt(10);
        enemigo.setVida(enemigo.getVida() - dano);
        System.out.println(getNombre() + " lanza un rayo a " + enemigo.getNombre() +
                           " por " + dano + " puntos de daño mágico!");
        if (enemigo.estaVivo()) {
            System.out.println(enemigo.getNombre() + " le queda " + enemigo.getVida() + " de vida.");
        } else {
            System.out.println(enemigo.getNombre() + " ha sido fulminado!");
        }
    }

    // Habilidad especial: daño masivo fijo
    @Override
    public void usarHabilidad(Personaje enemigo) {
        int dano = 50;
        enemigo.setVida(enemigo.getVida() - dano);
        System.out.println("🔥 ¡BOLA DE FUEGO! " + getNombre() + " destruye a " +
                           enemigo.getNombre() + " con " + dano + " puntos de daño!");
        if (enemigo.estaVivo()) {
            System.out.println(enemigo.getNombre() + " le queda " + enemigo.getVida() + " de vida.");
        } else {
            System.out.println(enemigo.getNombre() + " ha sido incinerado!");
        }
    }

    @Override
    public String getNombreHabilidad() { return "Bola de Fuego (50 daño fijo)"; }
}

// -------------------------------------------------------
// [LECCIÓN 5] SUBCLASE: DragonOscuro
// El enemigo — hereda de Personaje con su propio ataque
// -------------------------------------------------------
class DragonOscuro extends Personaje {

    public DragonOscuro() {
        super("Dragón Oscuro", 150, 14, 0);
    }

    // [LECCIÓN 5] Polimorfismo: ataque agresivo con varianza alta
    @Override
    public void atacar(Personaje enemigo) {
        int dano = getAtaque() + rand.nextInt(10);
        enemigo.setVida(enemigo.getVida() - dano);
        System.out.println("🐉 El " + getNombre() + " escupe fuego sobre " +
                           enemigo.getNombre() + " por " + dano + " puntos!");
        if (enemigo.estaVivo()) {
            System.out.println(enemigo.getNombre() + " le queda " + enemigo.getVida() + " de vida.");
        } else {
            System.out.println(enemigo.getNombre() + " ha caído ante el dragón!");
        }
    }
}

// -------------------------------------------------------
// CLASE PRINCIPAL: Main
// -------------------------------------------------------
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("╔══════════════════════════════╗");
        System.out.println("║       COMBATE RPG - JAVA      ║");
        System.out.println("╚══════════════════════════════╝\n");

        // [LECCIÓN 4] Scanner — el jugador escribe su nombre
        System.out.print("¿Cómo se llama tu personaje? ");
        String nombre = scanner.nextLine();

        // [LECCIÓN 3] if/else — elegir clase
        System.out.println("\nElige tu clase:");
        System.out.println("  1. Guerrero — 120 vida | 18 ataque | 3 pociones | Habilidad: Golpe Brutal");
        System.out.println("  2. Mago     —  80 vida | 22 ataque | 2 pociones | Habilidad: Bola de Fuego");
        System.out.print("Elige (1/2): ");
        String claseElegida = scanner.nextLine();

        // [LECCIÓN 5] Polimorfismo — heroe es de tipo Personaje
        // pero se comporta como Guerrero o Mago según la elección
        Personaje heroe;
        Habilidad habilidad;

        if (claseElegida.equals("2")) {
            Mago mago = new Mago(nombre);
            heroe     = mago;
            habilidad = mago;
        } else {
            Guerrero guerrero = new Guerrero(nombre);
            heroe             = guerrero;
            habilidad         = guerrero;
        }

        // [LECCIÓN 5] Instanciar el enemigo
        Personaje enemigo      = new DragonOscuro();
        boolean habilidadUsada = false;
        int turno              = 1;

        System.out.println("\n=== COMBATIENTES ===");
        heroe.mostrarEstado();
        enemigo.mostrarEstado();
        System.out.println("\n¡Que comience el combate!\n");

        // [LECCIÓN 3] Bucle while — combate hasta que alguien caiga
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
                System.out.println("  3. Habilidad especial: " + habilidad.getNombreHabilidad());
            }
            System.out.println("  4. Retirarse");
            System.out.print("Elige: ");
            String opcion = scanner.nextLine();
            System.out.println();

            // [LECCIÓN 3] if/else — ejecutar la acción elegida
            if (opcion.equals("1")) {
                heroe.atacar(enemigo);
            } else if (opcion.equals("2")) {
                heroe.usarPocion();
            } else if (opcion.equals("3") && !habilidadUsada) {
                habilidad.usarHabilidad(enemigo);
                habilidadUsada = true;
                System.out.println("(Habilidad especial usada — solo disponible una vez)");
            } else if (opcion.equals("4")) {
                System.out.println(heroe.getNombre() + " se retira. ¡Hasta la próxima!");
                scanner.close();
                return;
            } else {
                System.out.println("Opción no válida. ¡Pierdes el turno!");
            }

            // El dragón contraataca si sigue vivo
            if (enemigo.estaVivo()) {
                System.out.println();
                enemigo.atacar(heroe);
            }

            System.out.println();
            turno++;
        }

        // Resultado final
        System.out.println("╔══════════════════════════════╗");
        System.out.println("║       FIN DEL COMBATE         ║");
        System.out.println("╚══════════════════════════════╝\n");

        if (heroe.estaVivo()) {
            System.out.println("¡VICTORIA! " + heroe.getNombre() +
                               " ha derrotado al " + enemigo.getNombre() + "!");
            System.out.println("Vida restante: " + heroe.getVida() + " | Turnos: " + (turno - 1));
        } else {
            System.out.println("DERROTA. El " + enemigo.getNombre() +
                               " fue demasiado poderoso. ¡Inténtalo de nuevo!");
        }

        // [LECCIÓN 6] Retos para seguir:
        // 🟢 FÁCIL   : Agrega un Arquero como tercera clase jugable
        // 🟡 MEDIO   : Recarga la habilidad especial cada 3 turnos
        // 🔴 DIFÍCIL : Crea un sistema de niveles al ganar combates

        scanner.close();
    }
}
