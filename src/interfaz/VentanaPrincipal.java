package interfaz;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import clases.Configuracion;
import clases.Juego;

public class VentanaPrincipal extends JFrame {

    // DIMENSIONES
    private static final int ANCHO_VENTANA = 750;
    private static final int ALTO_VENTANA = 750;
    private static final int ANCHO_BOTON_CONTROL = 80;
    private static final int ALTO_BOTON_CONTROL = 50;
    private static final int INICIO_X_BOTONES = 85;
    private static final int Y_BOTONES = 620;
    private static final int SEPARACION_BOTONES = 115;
    private static final int X_TABLERO = 120;
    private static final int Y_TABLERO = 80;
    private static final int ANCHO_INFO = 200;
    private static final int ALTO_INFO = 60;
    private static final int X_INFO = 240;
    private static final int Y_INFO = 10;

    // Estilos botones del tablero
    private static Color colorBoton = new Color(59, 59, 59);

    // COLORES
    private static final Color COLOR_FONDO = new Color(30, 30, 30);
    private static final Color COLOR_BOTON_PLAY = new Color(255, 149, 0);
    private static final Color COLOR_TEXTO = Color.WHITE;
    private static final Color COLOR_BORDE = new Color(100, 100, 100);
    private static final Color COLOR_BOTON = new Color(30, 58, 95);
    private static final Color COLOR_BOTON_APAGADO = colorBoton;
    private static final Color COLOR_BOTON_ENCENDIDO = Color.WHITE;

    private JButton botonPlay;
    private JButton botonLimpiar;
    private JLabel etiquetaGeneracion;
    private JLabel etiquetaPoblacion;
    private JPanel panelBotones;
    private Configuracion config = new Configuracion();
    private JButton[][] botonesTablero = new JButton[config.getAnchoTablero() / config.getAnchuraBotonTablero()][config.getAltoTablero() / config.getAlturaBotonTablero()];

    // Getters y setters
    public JLabel getEtiquetaGeneracion() {
        return etiquetaGeneracion;
    }

    public void setEtiquetaGeneracion(JLabel etiquetaGeneracion) {
        this.etiquetaGeneracion = etiquetaGeneracion;
    }

    public JLabel getEtiquetaPoblacion() {
        return etiquetaPoblacion;
    }

    public void setEtiquetaPoblacion(JLabel etiquetaPoblacion) {
        this.etiquetaPoblacion = etiquetaPoblacion;
    }

    public JButton[][] getBotonesTablero() {
        return botonesTablero;
    }

    public void setBotonesTablero(JButton[][] botonesTablero) {
        this.botonesTablero = botonesTablero;
    }

    public Configuracion getConfig() {
        return config;
    }

    public void setConfig(Configuracion config) {
        this.config = config;
    }

    public static Color getColorBotonApagado() {
        return COLOR_BOTON_APAGADO;
    }

    public static Color getColorBotonEncendido() {
        return COLOR_BOTON_ENCENDIDO;
    }

    public Color getColor(JButton boton) {
        return boton.getBackground();
    }

    public VentanaPrincipal(Juego juego) {

        setTitle("El Juego de la Vida");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        setSize(ANCHO_VENTANA, ALTO_VENTANA);
        getContentPane().setBackground(COLOR_FONDO);

        //PANEL INFO
        JPanel panelInfo = new JPanel();
        panelInfo.setLayout(null);
        panelInfo.setBounds(X_INFO, Y_INFO, ANCHO_INFO, ALTO_INFO);
        panelInfo.setBackground(new Color(45, 45, 45));
        panelInfo.setBorder(BorderFactory.createLineBorder(COLOR_BORDE));

        etiquetaGeneracion = new JLabel("Generación: " + juego.getGeneracion());
        etiquetaGeneracion.setBounds(10, 5, 180, 25);
        etiquetaGeneracion.setForeground(COLOR_TEXTO);
        etiquetaGeneracion.setFont(new Font("Arial", Font.PLAIN, 14));
        etiquetaGeneracion.setHorizontalAlignment(SwingConstants.CENTER);

        etiquetaPoblacion = new JLabel("Población: " + juego.getPoblacion());
        etiquetaPoblacion.setBounds(10, 30, 180, 25);
        etiquetaPoblacion.setForeground(COLOR_TEXTO);
        etiquetaPoblacion.setFont(new Font("Arial", Font.PLAIN, 14));
        etiquetaPoblacion.setHorizontalAlignment(SwingConstants.CENTER);

        panelInfo.add(etiquetaGeneracion);
        panelInfo.add(etiquetaPoblacion);

        //PANEL TABLERO
        panelBotones = new JPanel();
        panelBotones.setLayout(null);
        panelBotones.setBounds(X_TABLERO, Y_TABLERO, config.getAnchoTablero(), config.getAltoTablero());
        panelBotones.setBackground(new Color(20, 20, 20));
        panelBotones.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(COLOR_BORDE),
                "Tablero",
                TitledBorder.CENTER,
                TitledBorder.TOP,
                new Font("Arial", Font.PLAIN, 12),
                COLOR_BORDE));

        //BOTONES DE CONTROL
        botonPlay = new JButton("Play");
        botonPlay.setBounds(INICIO_X_BOTONES + (1 * SEPARACION_BOTONES), Y_BOTONES, ANCHO_BOTON_CONTROL,
                ALTO_BOTON_CONTROL);
        aplicarEstiloBoton(botonPlay, COLOR_BOTON_PLAY);

        botonLimpiar = new JButton("Clear");
        botonLimpiar.setBounds(INICIO_X_BOTONES + (2 * SEPARACION_BOTONES), Y_BOTONES, ANCHO_BOTON_CONTROL,
                ALTO_BOTON_CONTROL);
        aplicarEstiloBoton(botonLimpiar, COLOR_BOTON);

        crearBotones(juego);

        panelBotones.revalidate();
        panelBotones.repaint();

        botonPlay.addActionListener(new BotonPlayListener(this, juego));
        botonLimpiar.addActionListener(new BotonLimpiarListener(this, juego));

        add(panelInfo);
        add(panelBotones);
        add(botonPlay);
        add(botonLimpiar);

        setVisible(true);

    }

    // MÉTODOS
    private void aplicarEstiloBoton(JButton boton, Color colorFondo) {
        boton.setBackground(colorFondo);
        boton.setForeground(COLOR_TEXTO);
        boton.setFont(new Font("Arial", Font.BOLD, 18));
        boton.setFocusPainted(false);
        boton.setBorderPainted(false);
        boton.setOpaque(true);
    }

    public void cambiarColorBoton(JButton boton) {

        if (boton.getBackground().equals(Color.WHITE)) {
            boton.setBackground(COLOR_BOTON_APAGADO);
            boton.setBorder(BorderFactory.createLineBorder(COLOR_BOTON_APAGADO));
        } else {
            boton.setBackground(COLOR_BOTON_ENCENDIDO);
            boton.setBorder(BorderFactory.createLineBorder(COLOR_BOTON_ENCENDIDO));
        }

    }

    public void actualizarTablero(Juego juego) {    

        boolean[][] copiaEstados = juego.empezarTurno();

        for (int i = 0; i < copiaEstados.length; i++) {
            for (int j = 0; j < copiaEstados[i].length; j++) {

                if (copiaEstados[i][j] && this.getColor(this.getBotonesTablero()[i][j]).equals(COLOR_BOTON_APAGADO)) {
                    this.cambiarColorBoton(this.getBotonesTablero()[i][j]);
                } else if (!copiaEstados[i][j]
                        && this.getColor(this.getBotonesTablero()[i][j]).equals(COLOR_BOTON_ENCENDIDO)) {
                    this.cambiarColorBoton(this.getBotonesTablero()[i][j]);
                }
            }
        }
    }

    public void crearBotones(Juego juego) {

        // Creo los botones y se los asigno a la clase Tablero
        for (int i = 0, x = 0; i < this.config.getAnchoTablero(); i += this.config.getAnchuraBotonTablero(), x++) {
            for (int j = 0, y = 0; j < this.config.getAltoTablero(); j += this.config.getAlturaBotonTablero(), y++) {
                botonesTablero[x][y] = new JButton();
                botonesTablero[x][y].setBounds(j, i, config.getAnchuraBotonTablero(), config.getAlturaBotonTablero());
                botonesTablero[x][y].setBackground(colorBoton);
                botonesTablero[x][y].setBorder(BorderFactory.createLineBorder(colorBoton));
                botonesTablero[x][y].addActionListener(new BotonPixelListener(this, botonesTablero[x][y],
                        juego.getTablero().getCelulasTablero()[x][y], juego));
                panelBotones.add(botonesTablero[x][y]);
            }
        }
    }

    public void eliminarBotones() {

        for (int i = 0, x = 0; i < config.getAnchoTablero(); i += config.getAnchuraBotonTablero(), x++) {
            for (int j = 0, y = 0; j < config.getAltoTablero(); j += config.getAlturaBotonTablero(), y++) {
                panelBotones.remove(botonesTablero[x][y]);
            }
        }
    }

    public void apagarBotones() {

        for (int i = 0, x = 0; i < config.getAnchoTablero(); i += config.getAnchuraBotonTablero(), x++) {
            for (int j = 0, y = 0; j < config.getAltoTablero(); j += config.getAlturaBotonTablero(), y++) {

                if (this.botonesTablero[x][y].getBackground().equals(COLOR_BOTON_ENCENDIDO)) {
                    this.botonesTablero[x][y].setBackground(COLOR_BOTON_APAGADO);
                    this.botonesTablero[x][y].setBorder(BorderFactory.createLineBorder(COLOR_BOTON_APAGADO));
                }
            }
        }
    }

}