
package main;

import clases.Celula;
import clases.Configuracion;
import clases.Juego;
import clases.Tablero;
import interfaz.VentanaPrincipal;

public class Main {

    public static void main(String[] args) {

        Configuracion config = new Configuracion();

        // Variables que guardan la cantidad de células que tendrá el tablero
        int anchoTablero = config.getAnchoTablero() / config.getAnchuraBotonTablero();
        int altoTablero = config.getAltoTablero() / config.getAlturaBotonTablero();

        Celula[][] celulas = new Celula[anchoTablero][altoTablero];
        Tablero tablero = new Tablero(celulas, anchoTablero, altoTablero);
        Juego juego = new Juego(tablero);
        
        juego.crearTablero();

        VentanaPrincipal vp = new VentanaPrincipal(juego);
        vp.setVisible(true);

    }

}
