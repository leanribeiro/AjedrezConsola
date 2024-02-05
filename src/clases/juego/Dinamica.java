package clases.juego;

import clases.piezas.Pieza;

public class Dinamica {
    public void inicio() {
        Mensaje mensajeFunc = new Mensaje();
        mensajeFunc.bienvenidaJuego();
        menuFunc(mensajeFunc);
    }

    public void menuFunc(Mensaje mensajeFunc) {
        int opcionMenu = mensajeFunc.elegirOpcionMenu();
        switch (opcionMenu) {
            case 1:
                //Registro jugadores
                break;
            case 2:
                iniciarJuego(mensajeFunc);
                break;
            case 3:
                //Reglas
                break;
            case 4:
                mensajeFunc.agradecimientoSalida();
        }
    }

    private static void iniciarJuego(Mensaje mensajeFunc) {
        Tablero tablero = new Tablero();
        tablero.crearMapPiezas();
        tablero.iniciarTablero();
        pedirPosicionMovimiento(tablero, mensajeFunc);
    }

    private static void pedirPosicionMovimiento(Tablero tablero, Mensaje mensajeFunc) {
        boolean salirJuego = false;
        int[] posicion = mensajeFunc.pedirPosicionDePiezaParaElegir(tablero);
        Pieza pieza = tablero.obtenerPiezaByPosicion(posicion[0], posicion[1], Tablero.NEGRO);
        boolean valido = false;
        while (!valido) {
            if (pieza == null) {
                mensajeFunc.mostrarMsjIngreseValida("pieza");
                posicion = mensajeFunc.pedirPosicionDePiezaParaElegir(tablero);
                pieza = tablero.obtenerPiezaByPosicion(posicion[0], posicion[1], Tablero.NEGRO);
            } else {
                valido = true;
            }
        }

        seguirJuegoSegunPieza(tablero, pieza);


    }


    private static void seguirJuegoSegunPieza(Tablero tablero, Pieza pieza) {
        switch (pieza.getNombre().substring(0, pieza.getNombre().length() - 1)) {
            case Tablero.ALFIL_BLANCO, Tablero.ALFIL_NEGRO:

                System.out.println("Prueba alfil");
                break;
            case Tablero.CABALLO_BLANCO, Tablero.CABALLO_NEGRO:
                System.out.println("Prueba caballo");

                break;

            case Tablero.PEON_BLANCO, Tablero.PEON_NEGRO:
                System.out.println("Prueba peon");
                pieza.movimiento(pieza, tablero);

                break;
            case Tablero.TORRE_BLANCO, Tablero.TORRE_NEGRO:
                System.out.println("Prueba torre");
                pieza.movimiento(pieza, tablero);
                break;
            case Tablero.REINA_BLANCO, Tablero.REINA_NEGRO:
                System.out.println("Prueba reina");

                break;
            case Tablero.REY_BLANCO, Tablero.REY_NEGRO:
                System.out.println("Prueba rey");

                break;
        }
        tablero.mostrarTablero(false, null);
    }

}
