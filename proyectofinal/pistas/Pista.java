package proyectofinal.pistas;

import proyectofinal.Palabra;
import java.util.Set;

/**
 * Clase abstracta base para todos los tipos de pista del juego.
 * Define el contrato mediante el metodo abstracto darPista(), aplicando
 * herencia y polimorfismo: cada subclase implementa su propia logica
 * de revelacion sin modificar el codigo que las invoca.
 *
 * @author Amanda Carolina Chindoy Muchavisoy
 */
public abstract class Pista {

    protected String descripcion;

    protected Pista(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Genera y retorna el texto de la pista para la palabra dada.
     *
     * @param palabra          la palabra actual del juego
     * @param letrasAdivinadas letras ya descubiertas por el jugador
     * @return texto descriptivo de la pista
     */
    public abstract String darPista(Palabra palabra, Set<Character> letrasAdivinadas);

    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public String toString() {
        return "Pista[" + descripcion + "]";
    }
}
