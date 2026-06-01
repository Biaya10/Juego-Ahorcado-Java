package proyectofinal.vista;

import proyectofinal.Ahorcado;
import javax.swing.*;
import java.awt.*;

/**
 * Ventana principal del juego (JFrame). Orquesta los paneles de la vista
 * y centraliza el manejo de eventos: seleccion de letras, pistas y nueva partida.
 * No contiene logica del juego; cada accion es procesada por Ahorcado.
 *
 * @author Amanda Carolina Chindoy Muchavisoy
 */
public class VentanaJuego extends JFrame {

    private static final String FUENTE = "Segoe UI";

    private final transient Ahorcado juego;
    private final PanelAhorcado panelAhorcado;
    private final PanelPalabra  panelPalabra;
    private final PanelLetras   panelLetras;
    private final JButton[] btnPistas = new JButton[3];
    private final JLabel lblVidas;
    private final JLabel lblVictorias;

    public VentanaJuego(String nombreJugador) {
        this.juego = new Ahorcado(nombreJugador);

        // Paneles de juego
        panelAhorcado = new PanelAhorcado();
        panelPalabra  = new PanelPalabra();
        panelLetras   = new PanelLetras(this);

        // Labels de estado (inicializados antes de initUI)
        lblVidas      = new JLabel();
        lblVictorias  = new JLabel();

        initUI();
        actualizar();
    }

    private void initUI() {
        setTitle("El Ahorcado - Proyecto POO");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(920, 660);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel raiz = new JPanel(new BorderLayout(8, 8));
        raiz.setBackground(PanelBase.C_FONDO_APP);
        raiz.setBorder(BorderFactory.createEmptyBorder(12, 14, 12, 14));
        setContentPane(raiz);

        raiz.add(crearPanelTitulo(),   BorderLayout.NORTH);
        raiz.add(crearPanelCentral(),  BorderLayout.CENTER);
        raiz.add(crearPanelInferior(), BorderLayout.SOUTH);

        setVisible(true);
    }

    // -------------------------------------------------------------------------
    // Construccion del layout
    // -------------------------------------------------------------------------

    private JPanel crearPanelTitulo() {
        JPanel panel = new JPanel(new BorderLayout(0, 0));
        panel.setBackground(PanelBase.C_FONDO_APP);
        panel.setBorder(BorderFactory.createEmptyBorder(0, 0, 6, 0));

        JLabel titulo = new JLabel("EL AHORCADO", SwingConstants.CENTER);
        titulo.setFont(new Font(FUENTE, Font.BOLD, 34));
        titulo.setForeground(PanelBase.C_ACENTO);
        panel.add(titulo, BorderLayout.CENTER);

        JPanel infoPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 18, 2));
        infoPanel.setBackground(PanelBase.C_FONDO_APP);

        lblVictorias.setFont(new Font(FUENTE, Font.PLAIN, 14));
        lblVictorias.setForeground(PanelBase.C_TEXTO_DIM);

        lblVidas.setFont(new Font(FUENTE, Font.BOLD, 15));
        lblVidas.setForeground(PanelBase.C_ROJO);

        infoPanel.add(lblVictorias);
        infoPanel.add(lblVidas);
        panel.add(infoPanel, BorderLayout.EAST);
        return panel;
    }

    private JPanel crearPanelCentral() {
        JPanel central = new JPanel(new BorderLayout(10, 0));
        central.setBackground(PanelBase.C_FONDO_APP);

        central.add(panelAhorcado, BorderLayout.WEST);

        JPanel derecho = new JPanel();
        derecho.setLayout(new BoxLayout(derecho, BoxLayout.Y_AXIS));
        derecho.setBackground(PanelBase.C_FONDO_APP);

        panelPalabra.setAlignmentX(Component.LEFT_ALIGNMENT);
        panelLetras.setAlignmentX(Component.LEFT_ALIGNMENT);

        derecho.add(panelPalabra);
        derecho.add(Box.createRigidArea(new Dimension(0, 8)));
        derecho.add(panelLetras);
        derecho.add(Box.createVerticalGlue());

        central.add(derecho, BorderLayout.CENTER);
        return central;
    }

    private JPanel crearPanelInferior() {
        JPanel inferior = new JPanel(new BorderLayout(8, 0));
        inferior.setBackground(PanelBase.C_FONDO_APP);
        inferior.setBorder(BorderFactory.createEmptyBorder(8, 0, 0, 0));

        // Botones de pistas
        JPanel pnlPistas = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 0));
        pnlPistas.setBackground(PanelBase.C_FONDO_APP);

        JLabel lblTituloPistas = new JLabel("Pistas:  ");
        lblTituloPistas.setFont(new Font(FUENTE, Font.BOLD, 13));
        lblTituloPistas.setForeground(PanelBase.C_TEXTO_DIM);
        pnlPistas.add(lblTituloPistas);

        String[] nombresPistas = {"Categoria", "Revelar Letra", "Descripcion"};
        for (int i = 0; i < 3; i++) {
            final int idx = i;
            btnPistas[i] = crearBoton(nombresPistas[i], PanelBase.C_AMARILLO, new Color(68, 62, 28));
            btnPistas[i].addActionListener(e -> activarPista(idx));
            pnlPistas.add(btnPistas[i]);
        }
        inferior.add(pnlPistas, BorderLayout.WEST);

        // Boton nueva partida
        JButton btnNueva = crearBoton("Nueva Partida", PanelBase.C_ACENTO, new Color(48, 28, 68));
        btnNueva.addActionListener(e -> nuevaPartida());
        inferior.add(btnNueva, BorderLayout.EAST);

        return inferior;
    }

    private JButton crearBoton(String texto, Color fg, Color bg) {
        JButton btn = new JButton(texto);
        btn.setFont(new Font(FUENTE, Font.BOLD, 13));
        btn.setForeground(fg);
        btn.setBackground(bg);
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);
        btn.setOpaque(true);
        btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btn.setBorder(BorderFactory.createEmptyBorder(9, 18, 9, 18));
        return btn;
    }

    // -------------------------------------------------------------------------
    // Logica de eventos
    // -------------------------------------------------------------------------

    /** Llamado por PanelLetras al hacer clic en una letra. */
    public void procesarLetraDesdeUI(char letra) {
        juego.procesarLetra(letra);
        actualizar();
        if (juego.isJuegoTerminado()) {
            Timer t = new Timer(350, e -> mostrarResultado());
            t.setRepeats(false);
            t.start();
        }
    }

    private void activarPista(int indice) {
        String msg = juego.usarPista(indice);
        panelPalabra.mostrarMensajePista(msg);
        actualizar();
        if (juego.isJuegoTerminado()) {
            Timer t = new Timer(350, e -> mostrarResultado());
            t.setRepeats(false);
            t.start();
        }
    }

    private void nuevaPartida() {
        juego.iniciarNuevaPartida();
        panelPalabra.limpiarMensajePista();
        panelLetras.resetearBotones();
        for (JButton btn : btnPistas) btn.setEnabled(true);
        actualizar();
    }

    private void actualizar() {
        panelAhorcado.actualizar(juego);
        panelPalabra.actualizar(juego);
        panelLetras.actualizar(juego);
        actualizarBarraEstado();
        sincronizarBotonesPistas();
    }

    private void actualizarBarraEstado() {
        int vidas = juego.getVidasRestantes();
        StringBuilder sb = new StringBuilder("Vidas: ");
        for (int i = 0; i < 7; i++) sb.append(i < vidas ? "♥ " : "♡ ");
        lblVidas.setText(sb.toString().trim());

        lblVictorias.setText(juego.getJugador().getNombre()
                + "   |   Victorias: " + juego.getJugador().getVictorias());
    }

    private void sincronizarBotonesPistas() {
        for (int i = 0; i < btnPistas.length; i++) {
            if (juego.isPistaUsada(i) || juego.isJuegoTerminado()) {
                btnPistas[i].setEnabled(false);
            }
        }
    }

    private void mostrarResultado() {
        String nombre = juego.getJugador().getNombre();
        String palabra = juego.getPalabraActual().getTexto();
        if (juego.isVictoria()) {
            JOptionPane.showMessageDialog(this,
                    "¡Felicitaciones, " + nombre + "!\n"
                    + "Adivinaste: " + palabra,
                    "Victoria", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this,
                    "¡Perdiste, " + nombre + "!\n"
                    + "La palabra era: " + palabra,
                    "Derrota", JOptionPane.ERROR_MESSAGE);
        }
    }
}
