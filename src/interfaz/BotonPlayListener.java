package interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import clases.Juego;

public class BotonPlayListener implements ActionListener {

    private VentanaPrincipal vp;
    private Juego juego;

    public BotonPlayListener(VentanaPrincipal vp, Juego juego) {
        this.vp = vp;
        this.juego = juego;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        this.juego.aumentarGeneracion();
        this.vp.actualizarTablero(this.juego);

        this.vp.getEtiquetaGeneracion().setText("Generación " + this.juego.getGeneracion());
        this.vp.getEtiquetaPoblacion().setText("Población " + this.juego.getPoblacion());
    }

}
