package clases.piezas;

import clases.juego.Tablero;

import java.util.ArrayList;
import java.util.List;

public class Alfil extends Pieza {

    public Alfil(int posicion_x, int posicion_y) {
        super.setPosicion_x(posicion_x);
        super.setPosicion_y(posicion_y);
    }

    public Alfil(String nombre, String color, int posicion_x, int posicion_y) {
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

        boolean salirAbajoDerecha = false;
        for (int x = 0; x < 8 && !salirAbajoDerecha; x++) {
            if ((posicionXActual + x) < 8 && (posicionYActual + x) < 8) {
                if(tablero.validarPosicionAComer(posicionXActual + x + 1,posicionYActual + x + 1, super.getColor())){
                    movimientos.add(String.valueOf((posicionXActual + x + 1)) + String.valueOf(posicionYActual + x + 1) + "M");
                }
                if (tablero.validarPosicionAMover(posicionXActual + x + 1, posicionYActual + x + 1)) {
                    movimientos.add(String.valueOf((posicionXActual + x + 1)) + String.valueOf(posicionYActual + x + 1));
                } else {
                    salirAbajoDerecha = true;
                }
            }
        }
        boolean salirAbajoIzq = false;
        for (int x = 0; ((posicionXActual + x) < tablero.getTablero().length || (posicionYActual - x) >= 0)
                && !salirAbajoIzq; x++) {
            if(tablero.validarPosicionAComer(posicionXActual+x+1,posicionYActual - x - 1, super.getColor())){
                movimientos.add(String.valueOf((posicionXActual + x + 1)) + String.valueOf(posicionYActual - x - 1) + "M");
            }
            if (tablero.validarPosicionAMover(posicionXActual + x + 1, posicionYActual - x - 1)) {
                movimientos.add(String.valueOf((posicionXActual + x + 1)) + String.valueOf(posicionYActual - x - 1));
            } else {
                salirAbajoIzq = true;
            }
        }
        boolean salirArribaIzq = false;
        for (int x = 0; ((posicionXActual - x) >= 0 && (posicionYActual - x) >= 0)
                && !salirArribaIzq; x++) {
            if(tablero.validarPosicionAComer(posicionXActual - x - 1,posicionYActual - x - 1, super.getColor())){
                movimientos.add(String.valueOf((posicionXActual - x - 1)) + String.valueOf(posicionYActual - x - 1) + "M");
            }
            if (tablero.validarPosicionAMover(posicionXActual - x - 1, posicionYActual - x - 1)) {
                movimientos.add(String.valueOf((posicionXActual - x - 1)) + String.valueOf(posicionYActual - x - 1));
            } else {
                salirArribaIzq = true;
            }
        }

        boolean salirArribaDer = false;
        for (int x = 0; ((posicionXActual - x) >= 0 && (posicionYActual + x) < tablero.getTablero()[0].length)
                && !salirArribaDer; x++) {
            if(tablero.validarPosicionAComer(posicionXActual - x - 1,posicionYActual + x + 1, super.getColor())){
                movimientos.add(String.valueOf((posicionXActual - x - 1)) + String.valueOf(posicionYActual + x + 1) + "M");
            }
            if (tablero.validarPosicionAMover(posicionXActual - x - 1, posicionYActual + x + 1)) {
                movimientos.add(String.valueOf((posicionXActual - x - 1)) + String.valueOf(posicionYActual + x + 1));
            } else {
                salirArribaDer = true;
            }
        }

        return movimientos;
    }




}
