package clases.piezas;

import clases.juego.Mensaje;
import clases.juego.Tablero;

import java.util.ArrayList;
import java.util.List;

public class Rey extends Pieza{

    public Rey(String nombre, String color, int posicion_x, int posicion_y ) {
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

        int[] movimientosX = {0,0,1,-1,1,1,-1,-1};
        int[] movimientosY = {1,-1,0,0,1,-1,-1,1};
        for(int i=0;i<movimientosX.length;i++){
            int nuevaX = posicionXActual + movimientosX[i];
            int nuevaY = posicionYActual + movimientosY[i];
            if (tablero.validarPosicionAMover(nuevaX, nuevaY)) {
                movimientos.add(String.valueOf(nuevaX) + String.valueOf(nuevaY));
            }
        }

        return movimientos;
    }


}
