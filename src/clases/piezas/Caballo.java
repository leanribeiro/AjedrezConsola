package clases.piezas;

import clases.juego.Mensaje;
import clases.juego.Tablero;

import java.util.ArrayList;
import java.util.List;

public class Caballo extends Pieza{

    public Caballo(String nombre, String color, int posicion_x, int posicion_y ) {
        super(nombre, color,posicion_x,posicion_y);
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
        int[] movimientosX = {2, 2, -2, -2, 1, -1, 1, -1};
        int[] movimientosY = {1, -1, 1, -1, -2, -2, 2, 2};

        for (int i = 0; i < movimientosX.length; i++) {
            int nuevaX = posicionXActual + movimientosX[i];
            int nuevaY = posicionYActual + movimientosY[i];
            if (tablero.validarPosicionAMover(nuevaX, nuevaY)) {
                movimientos.add(String.valueOf(nuevaX) + String.valueOf(nuevaY));
            }
        }

//        if(tablero.validarPosicionAMover(posicionXActual+2,posicionYActual +1)){
//            movimientos.add(String.valueOf(posicionXActual+2) + String.valueOf(posicionYActual + 1));
//        }
//        if(tablero.validarPosicionAMover(posicionXActual+2,posicionYActual -1)){
//            movimientos.add(String.valueOf(posicionXActual+2) + String.valueOf(posicionYActual -1));
//        }
//        if(tablero.validarPosicionAMover(posicionXActual-2,posicionYActual + 1)){
//            movimientos.add(String.valueOf(posicionXActual-2) + String.valueOf(posicionYActual +1));
//        }
//        if(tablero.validarPosicionAMover(posicionXActual-2,posicionYActual -1)){
//            movimientos.add(String.valueOf(posicionXActual-2) + String.valueOf(posicionYActual -1));
//        }
//        if(tablero.validarPosicionAMover(posicionXActual+1,posicionYActual - 2)){
//            movimientos.add(String.valueOf(posicionXActual+1) + String.valueOf(posicionYActual -2));
//        }
//        if(tablero.validarPosicionAMover(posicionXActual-1,posicionYActual - 2)){
//            movimientos.add(String.valueOf(posicionXActual-1) + String.valueOf(posicionYActual -2));
//        }
//        if(tablero.validarPosicionAMover(posicionXActual+1,posicionYActual + 2)){
//            movimientos.add(String.valueOf(posicionXActual+1) + String.valueOf(posicionYActual +2));
//        }
//        if(tablero.validarPosicionAMover(posicionXActual-1,posicionYActual + 2)){
//            movimientos.add(String.valueOf(posicionXActual-1) + String.valueOf(posicionYActual +2));
//        }

        return movimientos;
    }

}
