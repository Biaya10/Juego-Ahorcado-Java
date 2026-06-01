package proyectofinal.vista;

import proyectofinal.Ahorcado;
import javax.swing.*;
import java.awt.*;

/**
 * Panel que dibuja progresivamente la figura del ahorcado usando Graphics2D.
 * Sobreescribe paintComponent con anti-aliasing para lineas suavizadas.
 * Cada error agrega una parte del cuerpo: 1=cabeza, 2=cuerpo, 3=brazo izquierdo,
 * 4=brazo derecho, 5=pierna izquierda, 6=pierna derecha, 7=cara de derrota.
 *
 * @author Amanda Carolina Chindoy Muchavisoy
 */
public class PanelAhorcado extends PanelBase {

    private int errores = 0;
    private boolean juegoTerminado = false;
    private boolean victoria = false;

    public PanelAhorcado() {
        setBackground(new Color(245, 245, 252));
        setPreferredSize(new Dimension(340, 480));
        setBorder(BorderFactory.createLineBorder(C_BORDE, 2, true));
    }

    @Override
    public void actualizar(Ahorcado juego) {
        this.errores        = juego.getErrores();
        this.juegoTerminado = juego.isJuegoTerminado();
        this.victoria       = juego.isVictoria();
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,      RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL,    RenderingHints.VALUE_STROKE_PURE);
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        dibujarPatibulo(g2);
        dibujarFigura(g2);
        dibujarEstado(g2);
    }

    private void dibujarPatibulo(Graphics2D g2) {
        g2.setColor(new Color(65, 65, 88));
        g2.setStroke(new BasicStroke(5f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));

        int baseY  = getHeight() - 55;
        int topY   = 55;
        int poleX  = 80;
        int beamX  = 210;

        g2.drawLine(30,    baseY, 175,  baseY); // base
        g2.drawLine(poleX, baseY, poleX, topY); // poste vertical
        g2.drawLine(poleX, topY,  beamX, topY); // viga horizontal
        g2.drawLine(beamX, topY,  beamX, 92);   // cuerda

        // Diagonal de refuerzo
        g2.setStroke(new BasicStroke(3.5f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        g2.drawLine(poleX, topY + 45, poleX + 45, topY);
    }

    private void dibujarFigura(Graphics2D g2) {
        if (errores == 0) return;

        final int cx      = 210;
        final int headTop = 92;
        final int headR   = 26;
        final int bodyTop = headTop + headR * 2 + 2;
        final int bodyBot = bodyTop + 78;
        final int armsY   = bodyTop + 22;

        Color colorFigura = (errores >= 7) ? new Color(210, 50, 55) : new Color(55, 55, 185);
        g2.setColor(colorFigura);
        g2.setStroke(new BasicStroke(5f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));

        // Cabeza (error 1)
        if (errores >= 1) {
            g2.drawOval(cx - headR, headTop, headR * 2, headR * 2);

            // Cara segun estado
            if (errores >= 7) {
                // Cara de muerto: ojos en X
                g2.setStroke(new BasicStroke(2.8f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
                dibujarOjoX(g2, cx - 10, headTop + 9);
                dibujarOjoX(g2, cx + 10, headTop + 9);
                // Boca triste
                g2.drawArc(cx - 9, headTop + headR + 1, 18, 10, 0, -180);
                g2.setStroke(new BasicStroke(5f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
            } else if (errores <= 3) {
                // Cara neutral
                g2.setStroke(new BasicStroke(2.5f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
                g2.fillOval(cx - 10, headTop + 10, 5, 5);
                g2.fillOval(cx + 5,  headTop + 10, 5, 5);
                g2.drawArc(cx - 7, headTop + headR + 2, 14, 8, 0, 180);
                g2.setStroke(new BasicStroke(5f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
            } else {
                // Cara preocupada
                g2.setStroke(new BasicStroke(2.5f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
                g2.fillOval(cx - 10, headTop + 10, 5, 5);
                g2.fillOval(cx + 5,  headTop + 10, 5, 5);
                g2.drawArc(cx - 7, headTop + headR + 4, 14, 8, 0, -180);
                g2.setStroke(new BasicStroke(5f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
            }
        }

        // Cuerpo (error 2)
        if (errores >= 2) g2.drawLine(cx, bodyTop, cx, bodyBot);

        // Brazo izquierdo (error 3)
        if (errores >= 3) g2.drawLine(cx, armsY, cx - 42, armsY + 42);

        // Brazo derecho (error 4)
        if (errores >= 4) g2.drawLine(cx, armsY, cx + 42, armsY + 42);

        // Pierna izquierda (error 5)
        if (errores >= 5) g2.drawLine(cx, bodyBot, cx - 38, bodyBot + 55);

        // Pierna derecha (error 6)
        if (errores >= 6) g2.drawLine(cx, bodyBot, cx + 38, bodyBot + 55);
    }

    private void dibujarOjoX(Graphics2D g2, int cx, int cy) {
        int r = 5;
        g2.drawLine(cx - r, cy - r, cx + r, cy + r);
        g2.drawLine(cx + r, cy - r, cx - r, cy + r);
    }

    private void dibujarEstado(Graphics2D g2) {
        if (!juegoTerminado) return;

        String msg = victoria ? "VICTORIA" : "DERROTA";
        Color color = victoria ? new Color(40, 160, 80) : new Color(210, 50, 55);

        g2.setFont(new Font("Segoe UI", Font.BOLD, 22));
        g2.setColor(color);
        FontMetrics fm = g2.getFontMetrics();
        int x = (getWidth() - fm.stringWidth(msg)) / 2;
        g2.drawString(msg, x, getHeight() - 20);
    }
}
