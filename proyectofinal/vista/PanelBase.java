package proyectofinal.vista;

import proyectofinal.Ahorcado;
import javax.swing.*;
import java.awt.*;

/**
 * Panel base abstracto del que heredan todos los paneles de la interfaz grafica.
 * Centraliza la paleta de colores y las fuentes compartidas, garantizando
 * consistencia visual en toda la aplicacion (principio de encapsulacion de estilos).
 * Obliga a cada subclase a implementar el metodo actualizar() mediante abstraccion.
 *
 * @author Amanda Carolina Chindoy Muchavisoy
 */
public abstract class PanelBase extends JPanel {

    // --- Paleta de colores (tema oscuro) ---
    public static final Color C_FONDO_APP   = new Color(28,  28,  40);
    public static final Color C_FONDO_PANEL = new Color(42,  44,  62);
    public static final Color C_BORDE       = new Color(69,  71, 100);
    public static final Color C_TEXTO       = new Color(205, 214, 244);
    public static final Color C_TEXTO_DIM   = new Color(147, 153, 178);
    public static final Color C_VERDE       = new Color(166, 227, 161);
    public static final Color C_ROJO        = new Color(243, 139, 168);
    public static final Color C_AZUL        = new Color(137, 180, 250);
    public static final Color C_AMARILLO    = new Color(249, 226, 175);
    public static final Color C_ACENTO      = new Color(203, 166, 247);

    // --- Fuentes compartidas ---
    private static final String FUENTE = "Segoe UI";
    protected static final Font F_TITULO   = new Font(FUENTE, Font.BOLD,  24);
    protected static final Font F_NORMAL   = new Font(FUENTE, Font.PLAIN, 14);
    protected static final Font F_LETRA    = new Font(FUENTE, Font.BOLD,  20);
    protected static final Font F_PEQUENA  = new Font(FUENTE, Font.PLAIN, 12);
    protected static final Font F_NEGRITA  = new Font(FUENTE, Font.BOLD,  14);

    protected PanelBase() {
        setBackground(C_FONDO_PANEL);
        setBorder(BorderFactory.createLineBorder(C_BORDE, 1, true));
    }

    /**
     * Actualiza el contenido del panel con el estado actual del juego.
     * Cada subclase implementa su propia logica de refresco.
     *
     * @param juego instancia activa del juego
     */
    public abstract void actualizar(Ahorcado juego);
}
