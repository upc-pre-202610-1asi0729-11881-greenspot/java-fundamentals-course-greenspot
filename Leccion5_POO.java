// ╔══════════════════════════════════════════════════════════════╗
// ║  LECCIÓN 5: Fundamentos de POO y juego completo (15 min)    ║
// ╚══════════════════════════════════════════════════════════════╝
//
//  POO al 100%:
//  ✔ Encapsulamiento  — atributos private + getters/setters
//  ✔ Abstracción      — clase abstracta Personaje
//  ✔ Herencia         — Guerrero, Mago y DragonOscuro extienden Personaje
//  ✔ Polimorfismo     — cada clase tiene su propio atacar()
//  ✔ Interfaces       — Habilidad obliga a definir una habilidad especial
//
//  🎮 JUEGO COMPLETO:
//  El jugador elige su clase, usa habilidades especiales,
//  pociones y se enfrenta al Dragón Oscuro.
//
// ══════════════════════════════════════════════════════════════

import java.util.Scanner;
import java.util.Random;

// -------------------------------------------------------
// INTERFAZ: Habilidad
// -------------------------------------------------------
interface Habilidad {
    void usarHabilidad(Personaje enemigo);
    String getNombreHabilidad();
}

// -------------------------------------------------------
// CLASE ABSTRACTA: Personaje
// -------------------------------------------------------
abstract class Personaje {

    private String nombre;
    private int vida;
    private int vidaMaxima;
    private int ataque;
    private int pociones;
    protected Random rand = new Random();

    public Personaje(String nombre, int vida, int ataque, int pociones) {
        this.nombre     = nombre;
        this.vida       = vida;
        this.vidaMaxima = vida;
        this.ataque     = ataque;
        this.pociones   = pociones;
    }

    // GETTERS
    public String getNombre()  { return nombre; }
    public int getVida()       { return vida; }
    public int getVidaMaxima() { return vidaMaxima; }
    public int getAtaque()     { return ataque; }
    public int getPociones()   { return pociones; }

    // SETTER con validación
    public void setVida(int vida) {
        this.vida = Math.max(0, vida);
    }

    // MÉTODO ABSTRACTO: cada subclase define su ataque
    public abstract void atacar(Personaje enemigo);

    // MÉTODOS CONCRETOS
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
// SUBCLASE: Guerrero
// -------------------------------------------------------
class Guerrero extends Personaje implements Habilidad {

    public Guerrero(String nombre) {
        super(nombre, 120, 18, 3);
    }

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
// SUBCLASE: Mago
// -------------------------------------------------------
class Mago extends Personaje implements Habilidad {

    public Mago(String nombre) {
        super(nombre, 80, 22, 2);
    }

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
// SUBCLASE: DragonOscuro (el enemigo)
// -------------------------------------------------------
class DragonOscuro extends Personaje {

    public DragonOscuro() {
        super("Dragón Oscuro", 150, 14, 0);
    }

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
// CLASE PRINCIPAL
// -------------------------------------------------------
public class Leccion5_POO {
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

        Personaje enemigo      = new DragonOscuro();
        boolean habilidadUsada = false;
        int turno              = 1;

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
                System.out.println("  3. Habilidad especial: " + habilidad.getNombreHabilidad());
            }
            System.out.println("  4. Retirarse");
            System.out.print("Elige: ");
            String opcion = scanner.nextLine();
            System.out.println();

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

            if (enemigo.estaVivo()) {
                System.out.println();
                enemigo.atacar(heroe);
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
            System.out.println("Vida restante: " + heroe.getVida() + " | Turnos: " + (turno - 1));
        } else {
            System.out.println("DERROTA. El " + enemigo.getNombre() +
                               " fue demasiado poderoso. ¡Inténtalo de nuevo!");
        }

        scanner.close();
    }
}
