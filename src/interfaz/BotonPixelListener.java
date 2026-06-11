package interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import clases.Celula;
import clases.Juego;

public class BotonPixelListener implements ActionListener {

    private VentanaPrincipal vp;
    private JButton boton;
    private Celula celula;
    private Juego juego;

    public BotonPixelListener(VentanaPrincipal vp, JButton boton, Celula celula, Juego juego) {
        this.vp = vp;
        this.boton = boton;
        this.celula = celula;
        this.juego = juego;
    }

    @Override
    public void actionPerformed(ActionEvent e) {    

        if (this.boton.getBackground().equals(VentanaPrincipal.getColorBotonApagado())) {
            this.juego.aumentarPoblacion();
        } else {
            this.juego.disminuirPoblacion();
        }
        
        // Cunado pulso el botón cambia el color y el estado de la célula
        this.vp.cambiarColorBoton(boton);
        this.celula.cambiarEstado();
        
        this.vp.getEtiquetaPoblacion().setText("Población: " + this.juego.getPoblacion());
    }

}
