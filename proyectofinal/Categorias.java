package proyectofinal;

/**
 * Enumeracion de las cinco categorias disponibles para las palabras del juego.
 * Garantiza seguridad de tipos: no se puede asignar una categoria invalida.
 *
 * @author Amanda Carolina Chindoy Muchavisoy
 */
public enum Categorias {
    ANIMALES("Animales"),
    PAISES("Paises"),
    DEPORTES("Deportes"),
    OBJETOS("Objetos"),
    COMIDAS("Comidas");

    private final String nombre;

    Categorias(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Retorna el nombre legible de la categoria para mostrar en pantalla.
     * @return nombre de la categoria (ej. "Animales")
     */
    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
