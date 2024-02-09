package clases.piezas;

import clases.juego.Mensaje;
import clases.juego.Tablero;

import java.util.ArrayList;
import java.util.List;

public class Torre extends Pieza {

    public Torre(int posicion_x, int posicion_y){
        super.setPosicion_x(posicion_x);
        super.setPosicion_y(posicion_y);
    }

    public Torre(String nombre, String color, int posicion_x, int posicion_y) {
        super(nombre, color, posicion_x, posicion_y);
    }
    @Override
    public List<String> posicionesValidasMover(Tablero tablero) {
        return obtenerMovimientos(tablero);
    }

    private List<String> obtenerMovimientos(Tablero tablero) {
        List<String> movimientos = new ArrayList<>();
        int posicionXActual = super.getPosicion_x();
        int posicionYActual = super.getPosicion_y();

        if (tablero.validarPosicionAMover(posicionXActual + 1, posicionYActual)) {
            for (int x = posicionXActual; x <= 8 && tablero.validarPosicionAMover(x + 1 , posicionYActual); x++) {
                if (tablero.validarPosicionAMover(x + 1, posicionYActual)) {
                    movimientos.add(String.valueOf((x + 1)) + String.valueOf(posicionYActual));
                }
            }

        }
        if (tablero.validarPosicionAMover(posicionXActual, posicionYActual + 1)) {
            for (int y = posicionYActual; y < 8 && tablero.validarPosicionAMover(posicionXActual, y+1); y++) {
                if (tablero.validarPosicionAMover(posicionXActual, y + 1)) {
                    movimientos.add(String.valueOf((posicionXActual)) + String.valueOf(y + 1));
                }
            }

        }
        if (posicionYActual - 1 >= 0) {
            if (tablero.validarPosicionAMover(posicionXActual, posicionYActual - 1)) {
                for (int y = posicionYActual; y >= 0  && tablero.validarPosicionAMover(posicionXActual, y-1); y--) {
                    if (tablero.validarPosicionAMover(posicionXActual, y - 1)) {
                        movimientos.add(String.valueOf((posicionXActual)) + String.valueOf(y - 1));
                    }
                }
            }
        }
        if (posicionXActual - 1 >= 0) {
            if (tablero.validarPosicionAMover(posicionXActual - 1, posicionYActual)) {
                for (int x = posicionXActual; x >= 0  && tablero.validarPosicionAMover(x-1, posicionYActual); x--) {
                    if (tablero.validarPosicionAMover(x - 1, posicionYActual)) {
                        movimientos.add(String.valueOf((x - 1)) + String.valueOf(posicionYActual));
                    }
                }
            }
        }


        return movimientos;
    }
}
