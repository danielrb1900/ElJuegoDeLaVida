package clases;

public class Tablero {

    private Celula[][] celulasTablero;
    private int filas;
    private int columnas;

    public Tablero() {
    }

    public Tablero(Celula[][] celulasTablero) {
        this.celulasTablero = celulasTablero;
    }

    public Tablero(Celula[][] celulasTablero, int filas, int columnas) {
        this.celulasTablero = celulasTablero;
        this.filas = filas;
        this.columnas = columnas;
    }

    public Celula[][] getCelulasTablero() {
        return celulasTablero;
    }

    public void setCelulasTablero(Celula[][] celulasTablero) {
        this.celulasTablero = celulasTablero;
    }

    public int getColumnas() {
        return columnas;
    }

    public void setColumnas(int columnas) {
        this.columnas = columnas;
    }

    public int getFilas() {
        return filas;
    }

    public void setFilas(int filas) {
        this.filas = filas;
    }

}
