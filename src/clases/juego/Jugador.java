package clases.juego;

public class Jugador {
    private String nombre;
    private String color;

    private String apodo;

    public Jugador(){}
    public Jugador(String nombre, String color, String apodo){
        this.nombre = nombre;
        this.color = color;
        this.apodo = apodo;
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

    public String getApodo() {
        return apodo;
    }

    public void setApodo(String apodo) {
        this.apodo = apodo;
    }

    public int getPuntacion() {
        return puntacion;
    }

    public void setPuntacion(int puntacion) {
        this.puntacion = puntacion;
    }

    private int puntacion;

}
