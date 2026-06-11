package clases;

public class Juego {

    private Tablero tablero;
    private int generacion;
    private int poblacion;

    public Juego() {
    }

    public Juego(Tablero tablero) {
        this.tablero = tablero;
        this.generacion = 0;
        this.poblacion = 0;
    }

    public Tablero getTablero() {
        return tablero;
    }

    public void setTablero(Tablero tablero) {
        this.tablero = tablero;
    }

    public int getGeneracion() {
        return generacion;
    }

    public void setGeneracion(int generacion) {
        this.generacion = generacion;
    }

    public int getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(int poblacion) {
        this.poblacion = poblacion;
    }

    // Método que devulve una matriz de booleans para saber si las celúlas vecinas
    // están en rango.
    public boolean[][] obtenerMatrizPequenia(int x, int y) {
        boolean[][] matriz = new boolean[3][3];

        int maxFilas = this.tablero.getFilas();
        int maxColumnas = this.tablero.getColumnas();

        // Recorremos las celulas vecinas
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {

                int tableroX = x + i;
                int tableroY = y + j;

                int filaMatriz = i + 1;
                int colMatriz = j + 1;

                boolean dentroDeLimites = (tableroX >= 0 && tableroX < maxFilas)
                        && (tableroY >= 0 && tableroY < maxColumnas);

                if (dentroDeLimites) {
                    matriz[filaMatriz][colMatriz] = true;
                } else {
                    matriz[filaMatriz][colMatriz] = false;
                }
            }
        }
        return matriz;
    }

    public int obtenerCelulasVecinasVivas(int x, int y) {
        boolean[][] celulasVecinasEnRango = obtenerMatrizPequenia(x, y);

        int celulasVecinasVivas = 0; // Para que no me cuente la misma célula

        for (int i = 0; i < celulasVecinasEnRango.length; i++) {
            for (int j = 0; j < celulasVecinasEnRango[i].length; j++) {

                if (!(i == 1 && j == 1)) {
                    int tableroX = x + (i - 1);
                    int tableroY = y + (j - 1);

                    // Si las celúla tiene vecina en la posición que corresponda y su estado es
                    // verdadero incrementa el contador
                    if (celulasVecinasEnRango[i][j]
                            && this.tablero.getCelulasTablero()[tableroX][tableroY].isEstado()) {
                        celulasVecinasVivas++;
                    }
                }

            }
        }

        return celulasVecinasVivas;

    }

    // La célula nace si esta muerta y tiene tres vecinas vivas
    public boolean nace(int x, int y) {
        int celulasVecinasVIvas = obtenerCelulasVecinasVivas(x, y);

        return celulasVecinasVIvas == 3 && !this.tablero.getCelulasTablero()[x][y].isEstado();
    }

    // La célula muere si esta viva y tiene entre más de 3 vecinas vivas o 1 o menos
    // vecinas vivas
    public boolean muere(int x, int y) {

        int celulasVecinasVIvas = obtenerCelulasVecinasVivas(x, y);

        return (celulasVecinasVIvas > 3 || celulasVecinasVIvas <= 1)
                && this.tablero.getCelulasTablero()[x][y].isEstado();
    }

    // La célula vivesi está viva y si tiene 2 o 3 células vecinas vivas
    public boolean vive(int x, int y) {
        int celulasVecinasVIvas = obtenerCelulasVecinasVivas(x, y);

        return (celulasVecinasVIvas == 2 || celulasVecinasVIvas == 3)
                && this.tablero.getCelulasTablero()[x][y].isEstado();
    }

    // Método que añade las células al tablero.
    public void crearTablero() {

        for (int i = 0; i < this.tablero.getFilas(); i++) {
            for (int j = 0; j < this.tablero.getColumnas(); j++) {
                Celula celula = new Celula();
                this.tablero.getCelulasTablero()[i][j] = celula;
            }
        }

    }

    // Método que cuenta la población
    public int contadorPoblacion() {
        int contador = 0;
        for (int i = 0; i < this.tablero.getFilas(); i++) {
            for (int j = 0; j < this.tablero.getColumnas(); j++) {
                if (this.tablero.getCelulasTablero()[i][j].isEstado()) {
                    contador++;
                }
            }
        }
        this.poblacion = contador;
        return this.poblacion;

    }

    public void aumentarGeneracion() {
        this.generacion++;
    }

    public void aumentarPoblacion() {
        this.poblacion++;
    }

    public void disminuirGeneracion() {
        this.generacion--;
    }

    public void disminuirPoblacion() {
        this.poblacion--;
    }

    public void matarCelulas() {

        for (int i = 0; i < this.tablero.getFilas(); i++) {
            for (int j = 0; j < this.tablero.getColumnas(); j++) {
                if (this.tablero.getCelulasTablero()[i][j].isEstado()) {
                    this.tablero.getCelulasTablero()[i][j].cambiarEstado();
                }
            }
        }

    }

    public boolean[][] empezarTurno() {
        boolean[][] copiaEstados = new boolean[this.tablero.getFilas()][this.tablero.getColumnas()];

        // Calculo todos los estados de las células
        for (int i = 0; i < copiaEstados.length; i++) {
            for (int j = 0; j < copiaEstados[i].length; j++) {

                if (nace(i, j)) {
                    copiaEstados[i][j] = true;
                    aumentarPoblacion();
                } else if (muere(i, j)) {
                    copiaEstados[i][j] = false;
                    disminuirPoblacion();
                } else {
                    copiaEstados[i][j] = this.tablero.getCelulasTablero()[i][j].isEstado();
                }
            }
        }

        // Aplico los cambios.
        for (int i = 0; i < copiaEstados.length; i++) {
            for (int j = 0; j < copiaEstados[i].length; j++) {
                this.tablero.getCelulasTablero()[i][j].setEstado(copiaEstados[i][j]);
            }
        }

        return copiaEstados;
    }

}
