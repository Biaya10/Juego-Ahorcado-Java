package proyectofinal;

/**
 * Representa al jugador del ahorcado.
 * Encapsula nombre, vidas, victorias y pistas disponibles.
 * Todos los atributos son privados; el acceso es controlado por metodos publicos.
 *
 * @author Amanda Carolina Chindoy Muchavisoy
 */
public class Jugador {

    private String nombre;
    private int vidas;
    private int victorias;
    private int pistasDisponibles;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.vidas = 7;
        this.victorias = 0;
        this.pistasDisponibles = 3;
    }

    /**
     * Descuenta una vida al jugador.
     * @return true si aun tenia vidas disponibles; false si ya estaba en cero
     */
    public boolean perderVida() {
        if (vidas <= 0) return false;
        vidas--;
        return true;
    }

    /**
     * Descuenta una pista disponible.
     * @return true si habia pistas disponibles; false si ya no quedaban
     */
    public boolean usarPista() {
        if (pistasDisponibles <= 0) return false;
        pistasDisponibles--;
        return true;
    }

    /**
     * Incrementa el contador de victorias al ganar una partida.
     */
    public void ganarPartida() {
        victorias++;
    }

    /**
     * Reinicia vidas y pistas para una nueva partida.
     * El contador de victorias se conserva entre partidas.
     */
    public void reiniciar() {
        vidas = 7;
        pistasDisponibles = 3;
    }

    // --- Getters ---

    /** @return nombre del jugador ingresado al inicio */
    public String getNombre() {
        return nombre;
    }

    /** @return cantidad de vidas restantes (0 a 7) */
    public int getVidas() {
        return vidas;
    }

    /** @return total de partidas ganadas en la sesion */
    public int getVictorias() {
        return victorias;
    }

    /** @return pistas que aun puede usar el jugador en la partida actual */
    public int getPistasDisponibles() {
        return pistasDisponibles;
    }

    @Override
    public String toString() {
        return "Jugador{nombre=" + nombre
                + ", vidas=" + vidas
                + ", victorias=" + victorias
                + ", pistas=" + pistasDisponibles + "}";
    }
}
