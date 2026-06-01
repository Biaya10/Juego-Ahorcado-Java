package proyectofinal;

import java.util.Set;

/**
 * Representa una palabra a adivinar, con su categoria y pista descriptiva.
 * El texto se normaliza automaticamente a mayusculas al construirse,
 * garantizando consistencia en todas las comparaciones.
 *
 * @author Amanda Carolina Chindoy Muchavisoy
 */
public class Palabra {

    private String texto;
    private Categorias categoria;
    private String pista;

    public Palabra(String texto, Categorias categoria, String pista) {
        this.texto = texto.toUpperCase();
        this.categoria = categoria;
        this.pista = pista;
    }

    /**
     * Comprueba si la letra (ignorando mayusculas/minusculas) aparece en el texto.
     */
    public boolean contieneLetra(char letra) {
        char letraUpper = Character.toUpperCase(letra);
        for (char c : texto.toCharArray()) {
            if (Character.toUpperCase(c) == letraUpper) return true;
        }
        return false;
    }

    /**
     * Devuelve el texto con guiones bajos para letras no adivinadas.
     * Los espacios se muestran tal cual.
     */
    public String getTextoOculto(Set<Character> letrasAdivinadas) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < texto.length(); i++) {
            char c = texto.charAt(i);
            if (c == ' ') {
                sb.append("  ");
            } else if (letrasAdivinadas.contains(c)) {
                sb.append(c);
            } else {
                sb.append('_');
            }
        }
        return sb.toString();
    }

    /**
     * Retorna true cuando todas las letras (no espacios) han sido adivinadas.
     */
    public boolean estaCompleta(Set<Character> letrasAdivinadas) {
        for (char c : texto.toCharArray()) {
            if (c != ' ' && !letrasAdivinadas.contains(c)) return false;
        }
        return true;
    }

    /**
     * Devuelve la primera letra no adivinada del texto, para la pista de letra.
     * Retorna 0 si no quedan letras sin adivinar.
     */
    public char getLetraAleatoria(Set<Character> letrasAdivinadas) {
        for (char c : texto.toCharArray()) {
            if (c != ' ' && !letrasAdivinadas.contains(c)) return c;
        }
        return 0;
    }

    // --- Getters ---

    /** @return texto de la palabra en mayusculas (ej. "SALMON") */
    public String getTexto() {
        return texto;
    }

    /** @return categoria a la que pertenece la palabra */
    public Categorias getCategoria() {
        return categoria;
    }

    /** @return texto descriptivo de la pista asociada a la palabra */
    public String getPista() {
        return pista;
    }

    /**
     * Retorna el nombre de la categoria para usar como pista.
     *
     * @return nombre legible de la categoria (ej. "Animales")
     */
    public String pistaCategoria() {
        return categoria.getNombre();
    }

    /**
     * Retorna la descripcion textual de la palabra para usar como pista.
     *
     * @return pista descriptiva de la palabra
     */
    public String pistaEscrita() {
        return pista;
    }

    @Override
    public String toString() {
        return "Palabra{texto=" + texto + ", categoria=" + categoria + "}";
    }
}
