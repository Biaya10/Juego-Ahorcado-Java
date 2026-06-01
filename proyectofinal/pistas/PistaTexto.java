package proyectofinal.pistas;

import proyectofinal.Palabra;
import java.util.Set;

/**
 * Implementacion de Pista que muestra la descripcion textual de la palabra.
 * Ejemplo de respuesta: "Pista: Pescado rosado rico en omega-3".
 *
 * @author Amanda Carolina Chindoy Muchavisoy
 */
public class PistaTexto extends Pista {

    public PistaTexto() {
        super("Descripcion");
    }

    @Override
    public String darPista(Palabra palabra, Set<Character> letrasAdivinadas) {
        return "Pista: " + palabra.pistaEscrita();
    }
}
