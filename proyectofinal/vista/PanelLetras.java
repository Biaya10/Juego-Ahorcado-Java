package proyectofinal.vista;

import proyectofinal.Ahorcado;
import javax.swing.*;
import java.awt.*;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Panel con los 26 botones del alfabeto organizados en una cuadricula 3x9.
 * Los botones cambian de color segun el resultado de cada intento:
 * azul oscuro = disponible, verde = correcta, rojo = incorrecta.
 * Al hacer clic delega la accion en VentanaJuego mediante el patron de callback.
 *
 * @author Amanda Carolina Chindoy Muchavisoy
 */
public class PanelLetras extends PanelBase {

    private static final Color COLOR_BOTON     = new Color(58, 63, 105);
    private static final Color COLOR_CORRECTO  = new Color(35,  90,  65);
    private static final Color COLOR_INCORRECTO = new Color(95, 35,  50);

    private final Map<Character, JButton> botones = new LinkedHashMap<>();
    private final VentanaJuego ventana;

    public PanelLetras(VentanaJuego ventana) {
        this.ventana = ventana;
        setLayout(new GridLayout(3, 9, 5, 5));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        setPreferredSize(new Dimension(540, 185));
        inicializarBotones();
    }

    private void inicializarBotones() {
        String letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for (char c : letras.toCharArray()) {
            JButton btn = crearBoton(c);
            botones.put(c, btn);
            add(btn);
        }
        // Celda de relleno para completar la cuadricula 3x9 (27 celdas)
        JLabel relleno = new JLabel();
        relleno.setOpaque(false);
        add(relleno);
    }

    private JButton crearBoton(char letra) {
        JButton btn = new JButton(String.valueOf(letra));
        btn.setFont(new Font("Segoe UI", Font.BOLD, 15));
        btn.setForeground(C_TEXTO);
        btn.setBackground(COLOR_BOTON);
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);
        btn.setOpaque(true);
        btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btn.addActionListener(e -> ventana.procesarLetraDesdeUI(letra));
        return btn;
    }

    @Override
    public void actualizar(Ahorcado juego) {
        boolean bloqueado = juego.isJuegoTerminado();
        for (Map.Entry<Character, JButton> entry : botones.entrySet()) {
            char c   = entry.getKey();
            JButton btn = entry.getValue();

            if (juego.getLetrasAdivinadas().contains(c)) {
                btn.setBackground(COLOR_CORRECTO);
                btn.setForeground(C_VERDE);
                btn.setEnabled(false);
            } else if (juego.getLetrasErroneas().contains(c)) {
                btn.setBackground(COLOR_INCORRECTO);
                btn.setForeground(C_ROJO);
                btn.setEnabled(false);
            } else {
                btn.setBackground(COLOR_BOTON);
                btn.setForeground(C_TEXTO);
                btn.setEnabled(!bloqueado);
            }
        }
    }

    /** Restablece todos los botones a su estado inicial para una nueva partida. */
    public void resetearBotones() {
        for (JButton btn : botones.values()) {
            btn.setBackground(COLOR_BOTON);
            btn.setForeground(C_TEXTO);
            btn.setEnabled(true);
        }
    }
}
