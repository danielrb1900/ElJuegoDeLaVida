package clases;

public class Configuracion {

    private int alturaBotonTablero;
    private int anchuraBotonTablero;
    private int anchoTablero;
    private int altoTablero;

    public Configuracion() {
        this.alturaBotonTablero = 10;
        this.anchuraBotonTablero = 10;
        this.anchoTablero = 500;
        this.altoTablero = 500;
    }

    public int getAlturaBotonTablero() {
        return alturaBotonTablero;
    }

    public int getAnchuraBotonTablero() {
        return anchuraBotonTablero;
    }

    public void setAlturaBotonTablero(int alturaBotonTablero) {
        this.alturaBotonTablero = alturaBotonTablero;
    }

    public void setAnchuraBotonTablero(int anchuraBotonTablero) {
        this.anchuraBotonTablero = anchuraBotonTablero;
    }
    public int getAnchoTablero() {
        return anchoTablero;
    }

    public void setAnchoTablero(int anchoTablero) {
        this.anchoTablero = anchoTablero;
    }

    public int getAltoTablero() {
        return altoTablero;
    }

    public void setAltoTablero(int altoTablero) {
        this.altoTablero = altoTablero;
    }

}
