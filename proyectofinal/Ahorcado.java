package proyectofinal;

import proyectofinal.pistas.Pista;
import proyectofinal.pistas.PistaCategoria;
import proyectofinal.pistas.PistaLetra;
import proyectofinal.pistas.PistaTexto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Motor central del juego del ahorcado.
 * Administra el estado completo de la partida: palabra actual, letras adivinadas,
 * errores cometidos y el sistema de pistas (polimorfismo mediante Pista[]).
 * Coordina las capas de modelo y vista sin contener logica de interfaz grafica.
 *
 * @author Amanda Carolina Chindoy Muchavisoy
 */
public class Ahorcado {

    private Jugador jugador;
    private Palabra palabraActual;
    private ArrayList<Palabra> listaPalabras;
    private Set<Character> letrasAdivinadas;
    private Set<Character> letrasErroneas;
    private Pista[] pistas;
    private boolean[] pistasUsadas;
    private boolean juegoTerminado;
    private boolean victoria;
    private final Random random = new Random();

    public Ahorcado(String nombreJugador) {
        this.jugador = new Jugador(nombreJugador);
        this.listaPalabras = new BancoPalabras().getPalabras();
        // Polimorfismo: el arreglo de tipo abstracto Pista referencia subclases concretas
        this.pistas = new Pista[]{
            new PistaCategoria(),
            new PistaLetra(),
            new PistaTexto()
        };
        iniciarNuevaPartida();
    }

    /** Reinicia la partida manteniendo el contador de victorias del jugador. */
    public void iniciarNuevaPartida() {
        jugador.reiniciar();
        letrasAdivinadas = new HashSet<>();
        letrasErroneas   = new HashSet<>();
        pistasUsadas     = new boolean[pistas.length];
        juegoTerminado   = false;
        victoria         = false;
        seleccionarPalabraAleatoria();
    }

    private void seleccionarPalabraAleatoria() {
        palabraActual = listaPalabras.get(random.nextInt(listaPalabras.size()));
    }

    /**
     * Procesa una letra ingresada por el jugador.
     *
     * @param letra la letra a evaluar
     * @return false si el juego termino o la letra ya fue usada, true en otro caso
     */
    public boolean procesarLetra(char letra) {
        if (juegoTerminado) return false;
        char letraUpper = Character.toUpperCase(letra);
        if (letrasAdivinadas.contains(letraUpper) || letrasErroneas.contains(letraUpper)) return false;

        if (palabraActual.contieneLetra(letraUpper)) {
            letrasAdivinadas.add(letraUpper);
            if (palabraActual.estaCompleta(letrasAdivinadas)) {
                victoria       = true;
                juegoTerminado = true;
                jugador.ganarPartida();
            }
        } else {
            letrasErroneas.add(letraUpper);
            jugador.perderVida();
            if (jugador.getVidas() == 0) {
                juegoTerminado = true;
            }
        }
        return true;
    }

    /**
     * Usa una pista por su indice (0=Categoria, 1=Letra, 2=Descripcion).
     *
     * @param indice indice de la pista en el arreglo
     * @return texto de la pista o mensaje de error
     */
    public String usarPista(int indice) {
        if (juegoTerminado)          return "El juego ha terminado.";
        if (indice < 0 || indice >= pistas.length) return "Pista invalida.";
        if (pistasUsadas[indice])    return "Esta pista ya fue utilizada.";
        if (!jugador.usarPista())    return "No te quedan pistas disponibles.";

        pistasUsadas[indice] = true;
        Pista p = pistas[indice];
        String resultado = p.darPista(palabraActual, letrasAdivinadas);

        // La PistaLetra revela automaticamente la letra en el tablero
        if (p instanceof PistaLetra) {
            char c = ((PistaLetra) p).getLetra(palabraActual, letrasAdivinadas);
            if (c != 0) {
                letrasAdivinadas.add(c);
                if (palabraActual.estaCompleta(letrasAdivinadas)) {
                    victoria       = true;
                    juegoTerminado = true;
                    jugador.ganarPartida();
                }
            }
        }
        return resultado;
    }

    // --- Getters del estado del juego ---

    /** @return el objeto Jugador activo con sus datos y estado */
    public Jugador getJugador()                    { return jugador; }

    /** @return la palabra secreta seleccionada para la partida actual */
    public Palabra getPalabraActual()              { return palabraActual; }

    /** @return conjunto de letras correctamente adivinadas hasta el momento */
    public Set<Character> getLetrasAdivinadas()    { return letrasAdivinadas; }

    /** @return conjunto de letras incorrectas intentadas por el jugador */
    public Set<Character> getLetrasErroneas()      { return letrasErroneas; }

    /** @return arreglo polimorfico con los tres tipos de pista disponibles */
    public Pista[] getPistas()                     { return pistas; }

    /**
     * Indica si una pista ya fue utilizada en la partida actual.
     *
     * @param indice indice de la pista (0=Categoria, 1=Letra, 2=Descripcion)
     * @return true si la pista ya fue usada
     */
    public boolean isPistaUsada(int indice)        { return pistasUsadas[indice]; }

    /** @return true si la partida ha terminado (por victoria o derrota) */
    public boolean isJuegoTerminado()              { return juegoTerminado; }

    /** @return true si el jugador gano la partida */
    public boolean isVictoria()                    { return victoria; }

    /** @return numero de errores cometidos en la partida actual */
    public int getErrores()                        { return letrasErroneas.size(); }

    /** @return vidas restantes del jugador (0 a 7) */
    public int getVidasRestantes()                 { return jugador.getVidas(); }

    public String getTextoOculto() {
        return palabraActual.getTextoOculto(letrasAdivinadas);
    }

    @Override
    public String toString() {
        return "Ahorcado{jugador=" + jugador
                + ", palabra=" + palabraActual
                + ", errores=" + getErrores() + "}";
    }
}
