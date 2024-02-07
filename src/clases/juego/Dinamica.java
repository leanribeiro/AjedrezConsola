package clases.juego;

import clases.piezas.Pieza;

import java.util.ArrayList;
import java.util.List;

public class Dinamica {
    static List<Jugador> jugadores = new ArrayList<>();
    static Mensaje mensajesFunciones = new Mensaje();
    public void inicio() {
        mensajesFunciones.bienvenidaJuego();
        menuFunc();
    }

    public void menuFunc() {

        boolean salirJuego = false;
        do{
            int opcionMenu = mensajesFunciones.elegirOpcionMenu();
            switch (opcionMenu) {
                case 1:
                    iniciarRegistro();
                    break;
                case 2:
                    iniciarJuego();
                    break;
                case 3:
                    //Reglas
                    break;
                case 4:
                    mensajesFunciones.agradecimientoSalida();
                    salirJuego = true;
            }
        }while(!salirJuego);


    }
    public static void iniciarRegistro(){
        mensajesFunciones.pedirRegistro(jugadores);
    }

    private static void iniciarJuego() {
        Tablero tablero = new Tablero();
        tablero.crearMapPiezas();
        tablero.iniciarTablero();
        pedirPosicionMovimiento(tablero);
    }

    private static void pedirPosicionMovimiento(Tablero tablero) {
        boolean salirJuego = false;
        while (!salirJuego) {
            int[] posicion = mensajesFunciones.pedirPosicionDePiezaParaElegir(tablero);
            if (posicion[0] != -1 && posicion[1] != -1) {
                Pieza pieza = tablero.obtenerPiezaByPosicion(posicion[0], posicion[1], Tablero.NEGRO);
                boolean valido = false;
                while (!valido) {
                    if (pieza == null) {
                        mensajesFunciones.mostrarMsjIngreseValida("pieza");
                        posicion = mensajesFunciones.pedirPosicionDePiezaParaElegir(tablero);
                        pieza = tablero.obtenerPiezaByPosicion(posicion[0], posicion[1], Tablero.NEGRO);
                    } else {
                        valido = true;
                    }
                }
                pieza.movimiento(pieza, tablero);
                tablero.mostrarTablero(false, null);
            } else {
                salirJuego = mensajesFunciones.validarSalida();

            }
        }
        mensajesFunciones.agradecimientoSalida();


    }
}
