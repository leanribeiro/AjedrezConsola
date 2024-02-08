package clases.piezas;

import clases.juego.Mensaje;
import clases.juego.Tablero;

import java.util.ArrayList;
import java.util.List;

public class Reina extends Pieza{

    public Reina(String nombre, String color, int posicion_x, int posicion_y ) {
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

       Torre torre = new Torre(posicionXActual,posicionYActual);
       Alfil alfil = new Alfil(posicionXActual,posicionYActual);

       List<String> posicionesTorre = torre.posicionesValidasMover(tablero);
       List<String> posicionesAlfil = alfil.posicionesValidasMover(tablero);
       movimientos.addAll(posicionesTorre);
       movimientos.addAll(posicionesAlfil);

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
