package clases.piezas;

import clases.juego.Mensaje;
import clases.juego.Tablero;

import java.util.ArrayList;
import java.util.List;

public class Peon extends Pieza {

    public Peon(int posicion_x, int posicion_y) {
        super(posicion_x, posicion_y);
    }

    public Peon(String nombre, String color, int posicion_x, int posicion_y) {
        super(nombre, color, posicion_x, posicion_y);
    }

    @Override
    public List<String> posicionesValidasMover(Tablero tablero) {
        List<String> mov = obtenerMovimientos(tablero);
        return mov;
    }

    private List<String> obtenerMovimientos(Tablero tablero) {
        List<String> movimientos = new ArrayList<>();
        int posicionXActual = super.getPosicion_x();
        int posicionYActual = super.getPosicion_y();
        if (posicionXActual == 1 || posicionXActual == 6) {
            if (this.getColor().equals(Tablero.NEGRO)) {
                if (tablero.validarPosicionAMover(posicionXActual + 2, posicionYActual)) {
                    movimientos.add(String.valueOf((posicionXActual + 2)) + String.valueOf(posicionYActual));
                }
                if (tablero.validarPosicionAMover(posicionXActual + 1, posicionYActual)) {
                    movimientos.add(String.valueOf((posicionXActual + 1)) + String.valueOf(posicionYActual));
                }
            } else {
                if (tablero.validarPosicionAMover(posicionXActual - 2, posicionYActual)) {
                    movimientos.add(String.valueOf((posicionXActual - 2)) + String.valueOf(posicionYActual));
                }
                if (tablero.validarPosicionAMover(posicionXActual - 1, posicionYActual)) {
                    movimientos.add(String.valueOf((posicionXActual - 1)) + String.valueOf(posicionYActual));
                }
            }

        }else{
            if (this.getColor().equals(Tablero.NEGRO)) {
                if (tablero.validarPosicionAMover(posicionXActual + 1, posicionYActual)) {
                    movimientos.add(String.valueOf((posicionXActual + 1)) + String.valueOf(posicionYActual));
                }
            } else {
                if (tablero.validarPosicionAMover(posicionXActual - 1, posicionYActual)) {
                    movimientos.add(String.valueOf((posicionXActual - 1)) + String.valueOf(posicionYActual));
                }
            }
        }

        return movimientos;
    }

    @Override
    public void movimiento(Pieza pieza, Tablero tablero) {
        Mensaje mensajesFuncionalidades = new Mensaje();
        List<String> movimientos = pieza.posicionesValidasMover(tablero);
        String casilla = mensajesFuncionalidades.funcionalidadMovimiento(tablero, movimientos);

        boolean casillaValida = false;
        var casillaSeleccionada = casilla.split("");
        casillaValida = validacionCasilla(casillaValida, casilla, casillaSeleccionada, tablero, movimientos);
        if (casillaValida) {
            tablero.moverPieza(pieza, Integer.parseInt(String.valueOf(casillaSeleccionada[0].charAt(0))),
                    tablero.getIndexByLetra(casillaSeleccionada[1]));
        }
    }
}
