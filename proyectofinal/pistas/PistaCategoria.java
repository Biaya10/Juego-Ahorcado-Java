package proyectofinal.pistas;

import proyectofinal.Palabra;
import java.util.Set;

/**
 * Implementacion de Pista que revela la categoria de la palabra secreta.
 * Ejemplo de respuesta: "La palabra pertenece a la categoria: Animales".
 *
 * @author Amanda Carolina Chindoy Muchavisoy
 */
public class PistaCategoria extends Pista {

    public PistaCategoria() {
        super("Categoria");
    }

    @Override
    public String darPista(Palabra palabra, Set<Character> letrasAdivinadas) {
        return "La palabra pertenece a la categoria: " + palabra.pistaCategoria();
    }
}
