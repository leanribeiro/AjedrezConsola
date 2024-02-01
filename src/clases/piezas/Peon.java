package clases.piezas;

import clases.juego.Tablero;

public class Peon extends Pieza{

    public Peon(int posicion_x, int posicion_y) {
        super(posicion_x, posicion_y);
    }
    public Peon(String nombre, String color, int posicion_x, int posicion_y ) {
        super(nombre, color,posicion_x,posicion_y);
    }

    public void moverse(Tablero tablero) {
        if(super.getPosicion_x() == 1 || super.getPosicion_x() == 6){
            moverDosPosiciones();
        }else{
            moverUnaPosicion();
        }
        tablero.moverPieza(this);

    }

    private void moverUnaPosicion(){
        if(this.getColor().equals(Tablero.NEGRO)){
            setPosicion_x(this.getPosicion_x()-1);
        }else{
            setPosicion_x(this.getPosicion_x()+1);
        }
    }
    private void moverDosPosiciones(){
        if(this.getColor().equals(Tablero.NEGRO)){
            setPosicion_x(this.getPosicion_x()-2);
        }else{
            setPosicion_x(this.getPosicion_x()+2);
        }
    }


}
