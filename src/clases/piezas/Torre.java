package clases.piezas;

import clases.juego.Mensaje;
import clases.juego.Tablero;

import java.util.ArrayList;
import java.util.List;

public class Torre extends Pieza {

    public Torre(String nombre, String color, int posicion_x, int posicion_y) {
        super(nombre, color, posicion_x, posicion_y);
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

    private boolean validacionCasilla(boolean casillaValida, String casilla, String[] casillaSeleccionada, Tablero tablero, List<String> movimientos) {
        Mensaje mensaje = new Mensaje();
        while (!casillaValida && casilla.toUpperCase().charAt(0) != 'X') {
            if (casilla.length() == 2) {
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

    @Override
    public List<String> posicionesValidasMover(Tablero tablero) {
        List<String> mov = obtenerMovimientos(tablero);
        System.out.println(mov);
        return mov;
    }

    private List<String> obtenerMovimientos(Tablero tablero) {
        List<String> movimientos = new ArrayList<>();
        int posicionXActual = super.getPosicion_x();
        int posicionYActual = super.getPosicion_y();

        if (tablero.validarPosicionAMover(posicionXActual + 1, posicionYActual)) {
            for (int x = posicionXActual; x <= 8 && tablero.validarPosicionAMover(x + 1, posicionYActual); x++) {
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
                for (int x = posicionXActual; x >= 0  && tablero.validarPosicionAMover(x+1, posicionYActual); x--) {
                    if (tablero.validarPosicionAMover(x - 1, posicionYActual)) {
                        movimientos.add(String.valueOf((x - 1)) + String.valueOf(posicionYActual));
                    }
                }
            }
        }


        return movimientos;
    }
}
