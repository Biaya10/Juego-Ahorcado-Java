package proyectofinal.vista;

import proyectofinal.Ahorcado;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Panel que muestra el estado de la palabra mediante cajas individuales por letra.
 * Las letras adivinadas aparecen en verde; las no descubiertas muestran una linea.
 * Tambien muestra las letras incorrectas en rojo y el mensaje de pista en amarillo.
 *
 * @author Amanda Carolina Chindoy Muchavisoy
 */
public class PanelPalabra extends PanelBase {

    private String textoOculto    = "";
    private List<Character> erroneas = new ArrayList<>();
    private String mensajePista   = "";
    private boolean terminado     = false;
    private boolean victoria      = false;
    private String palabraFinal   = "";

    public PanelPalabra() {
        setPreferredSize(new Dimension(540, 185));
    }

    @Override
    public void actualizar(Ahorcado juego) {
        this.textoOculto = juego.getTextoOculto();
        this.erroneas    = new ArrayList<>(juego.getLetrasErroneas());
        this.terminado   = juego.isJuegoTerminado();
        this.victoria    = juego.isVictoria();
        this.palabraFinal = juego.getPalabraActual().getTexto();
        repaint();
    }

    /**
     * Muestra un mensaje de pista en la parte inferior del panel.
     *
     * @param msg texto de la pista a mostrar
     */
    public void mostrarMensajePista(String msg) {
        this.mensajePista = msg;
        repaint();
    }

    /**
     * Borra el mensaje de pista activo, usado al iniciar una nueva partida.
     */
    public void limpiarMensajePista() {
        this.mensajePista = "";
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,      RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        dibujarCajasLetras(g2);
        dibujarLetrasErroneas(g2);
        dibujarMensajePista(g2);
    }

    private void dibujarCajasLetras(Graphics2D g2) {
        if (textoOculto.isEmpty()) return;

        int celdas = 0;
        for (char c : textoOculto.toCharArray()) if (c != ' ') celdas++;

        int boxW = Math.min(44, Math.max(24, (getWidth() - 30) / Math.max(celdas, 1)));
        int boxH = 46;
        int gap  = 5;

        int totalAncho = 0;
        for (char c : textoOculto.toCharArray()) {
            totalAncho += (c == ' ') ? (boxW / 2 + gap) : (boxW + gap);
        }

        int x = (getWidth() - totalAncho) / 2;
        int y = 18;

        for (char c : textoOculto.toCharArray()) {
            if (c == ' ') { x += boxW / 2 + gap; continue; }
            dibujarCaja(g2, c, x, y, boxW, boxH);
            x += boxW + gap;
        }
    }

    private void dibujarCaja(Graphics2D g2, char c, int x, int y, int boxW, int boxH) {
        boolean revelada = (c != '_');

        g2.setColor(revelada ? new Color(55, 68, 100) : new Color(48, 50, 72));
        g2.fillRoundRect(x, y, boxW, boxH, 10, 10);

        g2.setStroke(new BasicStroke(1.8f));
        g2.setColor(revelada ? C_AZUL : C_BORDE);
        g2.drawRoundRect(x, y, boxW, boxH, 10, 10);

        if (revelada) {
            g2.setFont(F_LETRA);
            g2.setColor(C_VERDE);
            FontMetrics fm = g2.getFontMetrics();
            g2.drawString(String.valueOf(c),
                    x + (boxW - fm.charWidth(c)) / 2,
                    y + (boxH + fm.getAscent()) / 2 - 3);
        } else {
            g2.setColor(C_TEXTO_DIM);
            g2.setStroke(new BasicStroke(2.5f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
            g2.drawLine(x + 6, y + boxH - 6, x + boxW - 6, y + boxH - 6);
        }
    }

    private void dibujarLetrasErroneas(Graphics2D g2) {
        if (erroneas.isEmpty()) return;

        g2.setFont(F_NEGRITA);
        g2.setColor(C_TEXTO_DIM);
        g2.drawString("Incorrectas: ", 15, 140);

        int px = 15 + g2.getFontMetrics().stringWidth("Incorrectas: ");
        g2.setFont(new Font("Segoe UI", Font.BOLD, 15));

        for (char c : erroneas) {
            g2.setColor(C_ROJO);
            g2.drawString(String.valueOf(c) + " ", px, 140);
            px += g2.getFontMetrics().charWidth(c) + 8;
        }
    }

    private void dibujarMensajePista(Graphics2D g2) {
        if (terminado) {
            String msg = victoria
                    ? "¡GANASTE! La palabra era: " + palabraFinal
                    : "PERDISTE. La palabra era: " + palabraFinal;
            g2.setFont(F_NEGRITA);
            g2.setColor(victoria ? C_VERDE : C_ROJO);
            g2.drawString(msg, 15, 162);
        } else if (!mensajePista.isEmpty()) {
            g2.setFont(F_PEQUENA);
            g2.setColor(C_AMARILLO);
            g2.drawString(mensajePista, 15, 162);
        }
    }
}
