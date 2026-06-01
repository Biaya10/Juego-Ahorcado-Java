package proyectofinal;

import proyectofinal.vista.VentanaJuego;
import javax.swing.*;

/**
 * Punto de entrada de la aplicacion.
 * Solicita el nombre del jugador y lanza la ventana principal del juego.
 *
 * @author Amanda Carolina Chindoy Muchavisoy
 */
public class Principal {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            String nombre = JOptionPane.showInputDialog(
                    null,
                    "Bienvenido al Ahorcado\n¿Cual es tu nombre?",
                    "El Ahorcado",
                    JOptionPane.QUESTION_MESSAGE);

            if (nombre == null || nombre.trim().isEmpty()) {
                nombre = "Jugador";
            }

            new VentanaJuego(nombre.trim());
        });
    }
}
