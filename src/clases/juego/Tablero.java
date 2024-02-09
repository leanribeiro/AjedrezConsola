package clases.juego;

import clases.piezas.*;

import java.util.HashMap;
import java.util.List;


public class Tablero {
    public static final String NEGRO = "NEGRO";
    public static final String BLANCO = "BLANCO";

    public static final String ESPACIO_VACIO = "Ev";
    public static final String CABALLO_NEGRO = "Cn";
    public static final String ALFIL_NEGRO = "An";
    public static final String REY_NEGRO = "Rn";
    public static final String REINA_NEGRO = "rn";
    public static final String PEON_NEGRO = "Pn";

    public static final String TORRE_BLANCO = "Tb";
    public static final String TORRE_NEGRO = "Tn";
    public static final String CABALLO_BLANCO = "Cb";
    public static final String ALFIL_BLANCO = "Ab";
    public static final String REY_BLANCO = "Rb";
    public static final String REINA_BLANCO = "rb";
    public static final String PEON_BLANCO = "Pb";



    private String[] columnas = {"A","B","C","D","E","F","G","H"};
    private Pieza[][] tablero = new Pieza[8][8];

    private HashMap<String, String> piezas = new HashMap<>();
    private Jugador jugadorBlancas;
    private Jugador jugadorNegras;

    private Pieza[] piezasBlancas;
    private Pieza[] piezasNegras;

    public void crearMapPiezas() {
        piezas.put(CABALLO_BLANCO, "\u265E");
        piezas.put(ALFIL_BLANCO, "\u265D");
        piezas.put(REY_BLANCO, "\u265A");
        piezas.put(REINA_BLANCO, "\u265B");
        piezas.put(PEON_BLANCO, "\u265F");
        piezas.put(TORRE_BLANCO, "\u265C");

        piezas.put(TORRE_NEGRO, "\u2656");
        piezas.put(CABALLO_NEGRO, "\u2658");
        piezas.put(ALFIL_NEGRO, "\u2657");
        piezas.put(REY_NEGRO, "\u2654");
        piezas.put(REINA_NEGRO, "\u2655");
        piezas.put(PEON_NEGRO, "\u2659");

        piezas.put(ESPACIO_VACIO, "\u00A0");
    }

    public void iniciarTablero() {
        llenarPiezasNegrasIni();
        llenarPiezasBlancasIni();
        actualizarTablero();
        llenarEspaciosVacios();
        mostrarTablero(false,null);
    }
    private void llenarPiezasNegrasIni() {
        Pieza t1 = new Torre(TORRE_NEGRO + "1", NEGRO, 0, 0);
        Pieza c1 = new Caballo(CABALLO_NEGRO + "1", NEGRO, 0, 1);
        Pieza a1 = new Alfil(ALFIL_NEGRO + "1", NEGRO, 0, 2);
        Pieza reina = new Reina(REINA_NEGRO + "N", NEGRO, 0, 3);
        Pieza rey = new Rey(REY_NEGRO+ "N", NEGRO, 0, 4);
        Pieza a2 = new Alfil(ALFIL_NEGRO + "2", NEGRO, 0, 5);
        Pieza c2 = new Caballo(CABALLO_NEGRO + "2", NEGRO, 0, 6);
        Pieza t2 = new Torre(TORRE_NEGRO + "2", NEGRO, 0, 7);
        Pieza p1 = new Peon(PEON_NEGRO + "1", NEGRO, 1, 0);
        Pieza p2 = new Peon(PEON_NEGRO + "2", NEGRO, 1, 1);
        Pieza p3 = new Peon(PEON_NEGRO + "3", NEGRO, 1, 2);
        Pieza p4 = new Peon(PEON_NEGRO + "4", NEGRO, 1, 3);
        Pieza p5 = new Peon(PEON_NEGRO + "5", NEGRO, 1, 4);
        Pieza p6 = new Peon(PEON_NEGRO + "6", NEGRO, 1, 5);
        Pieza p7 = new Peon(PEON_NEGRO + "7", NEGRO, 1, 6);
        Pieza p8 = new Peon(PEON_NEGRO + "8", NEGRO, 1, 7);
        Pieza[] piezasNegras = {t1, c1, a1, reina, rey, a2, c2, t2, p1, p2, p3, p4, p5, p6, p7, p8};
        setPiezasNegras(piezasNegras);
    }

    private void llenarPiezasBlancasIni() {
        Pieza t1 = new Torre(TORRE_BLANCO + "1", BLANCO, 7, 0);
        Pieza c1 = new Caballo(CABALLO_BLANCO + "1", BLANCO, 7, 1);
        Pieza a1 = new Alfil(ALFIL_BLANCO + "1", BLANCO, 7, 2);
        Pieza reina = new Reina(REINA_BLANCO + "N", BLANCO, 7, 3);
        Pieza rey = new Rey(REY_BLANCO + "N", BLANCO, 7, 4);
        Pieza a2 = new Alfil(ALFIL_BLANCO + "2", BLANCO, 7, 5);
        Pieza c2 = new Caballo(CABALLO_BLANCO + "2", BLANCO, 7, 6);
        Pieza t2 = new Torre(TORRE_BLANCO + "2", BLANCO, 7, 7);
        Pieza p1 = new Peon(PEON_BLANCO + "1", BLANCO, 6, 0);
        Pieza p2 = new Peon(PEON_BLANCO + "2", BLANCO, 6, 1);
        Pieza p3 = new Peon(PEON_BLANCO + "3", BLANCO, 6, 2);
        Pieza p4 = new Peon(PEON_BLANCO + "4", BLANCO, 6, 3);
        Pieza p5 = new Peon(PEON_BLANCO + "5", BLANCO, 6, 4);
        Pieza p6 = new Peon(PEON_BLANCO + "6", BLANCO, 6, 5);
        Pieza p7 = new Peon(PEON_BLANCO + "7", BLANCO, 6, 6);
        Pieza p8 = new Peon(PEON_BLANCO + "8", BLANCO, 6, 7);
        Pieza[] piezasBlancas = {t1, c1, a1, reina, rey, a2, c2, t2, p1, p2, p3, p4, p5, p6, p7, p8};
        setPiezasBlancas(piezasBlancas);
    }

    public boolean esPosicionValidaAMostrar(int x, int y, List<String> movimientos){
        boolean result = false;
        for(String movimiento :movimientos ){
            var mov = movimiento.split("");
            if(mov.length == 2){
                if((Integer.parseInt(mov[0])== x && Integer.parseInt(mov[1]) == y )){
                    result =  true;
                }
            }
            if(mov.length ==3){
                if((Integer.parseInt(mov[0])== x && Integer.parseInt(mov[1]) == y ) && mov[2].equals("M")){
                    result =  true;
                }
            }

        }

        return result;
    }


    public void mostrarTablero(boolean mostrarValidas, List<String> movimientos) {
        System.out.println("        A     B     C    D     E     F     G     H");

        for (int i = 0; i < tablero.length; i++) {
            System.out.println("      -----------------------------------------------");
            for (int j = 0; j < tablero[i].length; j++) {
                String nombrePieza =  "";
                if(tablero[i][j] !=null){
                    nombrePieza = tablero[i][j].getNombre().substring(0, tablero[i][j].getNombre().length() - 1);
                }
                if (j == 0) {
                    System.out.print("     " + i);
                }
                if (!piezas.containsKey(nombrePieza)) {
                    if (j == 7) {
                        if(mostrarValidas && esPosicionValidaAMostrar(i,j,movimientos)){
                            System.out.print(" "+"\033[0;32m"+i+getColumnaByIndex(j)+"\033[0m");
                        }else{
                            System.out.print(" _ ");
                        }
                    } else {
                        if(mostrarValidas  && esPosicionValidaAMostrar(i,j,movimientos)){
                            System.out.print(" "+"\033[0;32m"+i+getColumnaByIndex(j)+"\033[0m");
                        }else{
                            System.out.print(" _ ");
                        }

                    }
                } else {
                    if (j == 0) {
                        System.out.print("  ");
                    }
                    if (j == 7) {
                        System.out.print(" " + piezas.get(nombrePieza) + " ");
                    } else {
                        System.out.print(piezas.get(nombrePieza) + " ");

                    }
                }
                System.out.print(" | ");


            }
            System.out.println("");
        }
        System.out.println("      -----------------------------------------------");
    }



    private void llenarEspaciosVacios() {

        for (int i = 0; i < tablero.length ; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                if (tablero[i][j] == null) {
                    Pieza espacioVacio = new Pieza(ESPACIO_VACIO, "", i, j);
                    tablero[i][j] = espacioVacio;
                }

            }
        }
    }

    public void actualizarTablero(){
        for (Pieza pieza : getPiezasBlancas()) {
            if(pieza.getPosicion_x() != -1 && pieza.getPosicion_y() !=-1){
                tablero[pieza.getPosicion_x()][pieza.getPosicion_y()] = pieza;
            }
        }
        for (Pieza pieza : getPiezasNegras()) {
            if(pieza.getPosicion_x() != -1 && pieza.getPosicion_y() !=-1){
                tablero[pieza.getPosicion_x()][pieza.getPosicion_y()] = pieza;
            }
        }
    }

    public boolean validarPosicionAMover(int posicion_x, int posicion_y) {
        boolean esValida = false;
        if (posicion_x <8 && posicion_y < 8 && posicion_x >=0 && posicion_y >=0  &&
                tablero[posicion_x][posicion_y].getNombre().equals(ESPACIO_VACIO)  ) {
            esValida = true;
        }
        return esValida;
    }

    public boolean validarPosicionAComer(int posicion_x, int posicion_y,String colorJugadorActual) {
        boolean esValida = false;
        if (posicion_x <8 && posicion_y < 8 && posicion_x >=0 && posicion_y >=0  &&
                !tablero[posicion_x][posicion_y].getNombre().equals(ESPACIO_VACIO)
                && !tablero[posicion_x][posicion_y].getColor().equals(colorJugadorActual)  ) {
            esValida = true;
        }
        return esValida;
    }

    public Pieza obtenerPiezaByPosicion(int x, int y, String color){
        Pieza pieza = null;
        if(x < 8 && y < 8  && tablero[x][y].getColor().equals(color)){
            pieza=tablero[x][y];
        }
        return pieza;
    }

    public int getIndexByLetra(String columnaBuscada){
        int index = -1;
        for(int i=0;i<getColumnas().length;i++){
            if(getColumnas()[i].equals(columnaBuscada.toUpperCase())){
                index = i;
            }
        }
        return index;
    }
    public String getColumnaByIndex(int index){
        return getColumnas()[index];
    }

    public void moverPieza(Pieza pieza,int nuevaPosX, int nuevaPosY, boolean quiereComer){
        int xAntiguo = pieza.getPosicion_x();
        int yAntiguo = pieza.getPosicion_y();
        tablero[xAntiguo][yAntiguo] = new Pieza(ESPACIO_VACIO, "", pieza.getPosicion_x(), pieza.getPosicion_y());

        if(quiereComer){
            comerPieza(pieza, nuevaPosX,nuevaPosY);
        }else{
            pieza.moverse(nuevaPosX,nuevaPosY);
        }
        actualizarTablero();
    }

    private void comerPieza(Pieza pieza,int posX, int posY){
        Pieza piezaAntigua =  tablero[posX][posY];
        piezaAntigua.moverse(-1,-1);
        pieza.moverse(posX,posY);
    }


    public void setColumnas(String[] columnas) {
        this.columnas = columnas;
    }
    public String[] getColumnas() {
        return columnas;
    }


    public Pieza[][] getTablero() {
        return tablero;
    }

    public void setTablero(Pieza[][] tablero) {
        this.tablero = tablero;
    }

    public Pieza[] getPiezasBlancas() {
        return piezasBlancas;
    }

    public void setPiezasBlancas(Pieza[] piezasBlancas) {
        this.piezasBlancas = piezasBlancas;
    }

    public Pieza[] getPiezasNegras() {
        return piezasNegras;
    }

    public void setPiezasNegras(Pieza[] piezasNegras) {
        this.piezasNegras = piezasNegras;
    }

}
