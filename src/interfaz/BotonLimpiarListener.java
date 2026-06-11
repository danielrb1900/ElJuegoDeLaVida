package interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import clases.Juego;

public class BotonLimpiarListener implements ActionListener {

    private VentanaPrincipal vp;
    private Juego juego;

    public BotonLimpiarListener(VentanaPrincipal vp, Juego juego) {
        this.vp = vp;
        this.juego = juego;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.vp.apagarBotones();
        this.juego.matarCelulas();
        this.juego.setPoblacion(0);
        this.juego.setGeneracion(0);

        this.vp.getEtiquetaGeneracion().setText("Generación: " + this.juego.getGeneracion());
        this.vp.getEtiquetaPoblacion().setText("Población: " + this.juego.getPoblacion());
    }

    

}
