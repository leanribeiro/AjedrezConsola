package clases.piezas;

import clases.juego.Tablero;

import java.util.ArrayList;
import java.util.List;

public class Peon extends Pieza{

    public Peon(int posicion_x, int posicion_y) {
        super(posicion_x, posicion_y);
    }
    public Peon(String nombre, String color, int posicion_x, int posicion_y ) {
        super(nombre, color,posicion_x,posicion_y);
    }
    @Override
    public List<String> posicionesValidasMover(Tablero tablero){
          List<String> mov = obtenerMovimientos(tablero);
          return mov;
    }

    private List<String> obtenerMovimientos(Tablero tablero){
        List<String> movimientos =  new ArrayList<>();
        int posicionXActual = super.getPosicion_x();
        int posicionYActual = super.getPosicion_y();
        if(posicionXActual== 1 || posicionXActual == 6){
            if(this.getColor().equals(Tablero.NEGRO)){
                if(tablero.validarPosicionAMover(posicionXActual + 2,posicionYActual)){
                    movimientos.add(String.valueOf((posicionXActual + 2)) + String.valueOf(posicionYActual));
                }
                if(tablero.validarPosicionAMover(posicionXActual + 1,posicionYActual)){
                    movimientos.add(String.valueOf((posicionXActual + 1)) + String.valueOf(posicionYActual));
                }
            }else{
                movimientos.add(String.valueOf(posicionXActual  -2));
                movimientos.add(String.valueOf(posicionXActual - 1));
            }

        }

        return movimientos;
    }


    @Override
    public void moverse() {
        if(super.getPosicion_x()== 1 || super.getPosicion_x() == 6){
            moverDosPosiciones();
        }else{
            moverUnaPosicion();
        }
    }

    private void moverUnaPosicion(){
        if(this.getColor().equals(Tablero.NEGRO)){
            setPosicion_x(this.getPosicion_x()+1);
        }else{
            setPosicion_x(this.getPosicion_x()-1);
        }
    }
    private void moverDosPosiciones(){
        if(this.getColor().equals(Tablero.NEGRO)){
            setPosicion_x(this.getPosicion_x()+2);
        }else{
            setPosicion_x(this.getPosicion_x()-2);
        }
    }



}
