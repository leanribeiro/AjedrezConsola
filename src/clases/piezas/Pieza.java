package clases.piezas;

import clases.juego.Mensaje;
import clases.juego.Tablero;

import java.util.ArrayList;
import java.util.List;

public class Pieza {
    private String nombre;
    private String color;
    private int posicion_x;
    private int posicion_y;

    public Pieza() {
    }

    public Pieza(String nombre, String color, int posicion_x, int posicion_y) {
        this.nombre = nombre;
        this.color = color;
        this.posicion_x = posicion_x;
        this.posicion_y = posicion_y;
    }

    public Pieza(int posicion_x, int posicion_y) {
        this.posicion_x = posicion_x;
        this.posicion_y = posicion_y;
    }

    public void moverse(int posX, int posY) {
        setPosicion_x(posX);
        setPosicion_y(posY);
    }

    public List<String> posicionesValidasMover(Tablero tablero) {
        List<String> movimientos = new ArrayList<>();
        return movimientos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPosicion_x() {
        return posicion_x;
    }

    public void setPosicion_x(int posicion_x) {
        this.posicion_x = posicion_x;
    }

    public int getPosicion_y() {
        return posicion_y;
    }

    public void setPosicion_y(int posicion_y) {
        this.posicion_y = posicion_y;
    }

    public void movimiento(Pieza pieza, Tablero tablero) {
        Mensaje mensajesFuncionalidades = new Mensaje();
        List<String> movimientos = pieza.posicionesValidasMover(tablero);
        String casilla = mensajesFuncionalidades.funcionalidadMovimiento(tablero, movimientos);

        boolean casillaValida = false;
        var casillaSeleccionada = casilla.split("");
        casillaValida = validacionCasilla(casillaValida, casilla, casillaSeleccionada, tablero, movimientos);
        boolean quiereComer = tablero.validarPosicionAComer(Integer.parseInt(String.valueOf(casillaSeleccionada[0].charAt(0))),
                tablero.getIndexByLetra(casillaSeleccionada[1]), this.getColor());
        if (casillaValida) {
            tablero.moverPieza(pieza, Integer.parseInt(String.valueOf(casillaSeleccionada[0].charAt(0))),
                    tablero.getIndexByLetra(casillaSeleccionada[1]),quiereComer);
        }
    }

    public boolean validacionCasilla(boolean casillaValida, String casilla, String[] casillaSeleccionada, Tablero tablero, List<String> movimientos) {
        Mensaje mensaje = new Mensaje();
        while (casilla != "" && !casillaValida && casilla.toUpperCase().charAt(0) != 'X') {
            if (casilla.length() == 2 ||  casilla.length() == 3 ) {
                if (Character.isDigit(casillaSeleccionada[0].charAt(0)) &&
                        Character.isLetter(casillaSeleccionada[1].toUpperCase().charAt(0))
                        && tablero.esPosicionValidaAMostrar(Integer.parseInt(casillaSeleccionada[0]),
                        tablero.getIndexByLetra(casillaSeleccionada[1]), movimientos)
                ) {
                    casillaValida = true;
                }
            }

            if (!casillaValida) {
                casilla = mensaje.pedirCasillaValida();
                casillaSeleccionada = casilla.split("");
            }


        }

        return casillaValida;
    }

    public void mover(Pieza[][] tablero, int posicion_x, int posicion_y) {
        tablero[posicion_x][posicion_y] = this;
    }
}
