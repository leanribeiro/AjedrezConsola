package clases.piezas;

import clases.juego.Tablero;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
        List<String>  movimientos = new ArrayList<>();
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
    }

    public void mover(Pieza[][] tablero, int posicion_x, int posicion_y) {
        tablero[posicion_x][posicion_y] = this;
    }
}
