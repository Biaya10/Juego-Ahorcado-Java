package proyectofinal.pistas;

import proyectofinal.Palabra;
import java.util.Set;

/**
 * Implementacion de Pista que revela una letra no adivinada de la palabra.
 * Tras invocarla, Ahorcado agrega automaticamente la letra al conjunto
 * de letrasAdivinadas, mostrándola en el tablero sin costar una vida.
 *
 * @author Amanda Carolina Chindoy Muchavisoy
 */
public class PistaLetra extends Pista {

    public PistaLetra() {
        super("Revelar letra");
    }

    @Override
    public String darPista(Palabra palabra, Set<Character> letrasAdivinadas) {
        char c = getLetra(palabra, letrasAdivinadas);
        if (c == 0) return "No quedan letras por revelar.";
        return "Letra revelada: " + c;
    }

    /**
     * Retorna la letra que sera revelada sin modificar el estado.
     * VentanaJuego la agrega a letrasAdivinadas via Ahorcado.
     */
    public char getLetra(Palabra palabra, Set<Character> letrasAdivinadas) {
        return palabra.getLetraAleatoria(letrasAdivinadas);
    }
}
