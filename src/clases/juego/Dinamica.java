package clases.juego;

import clases.piezas.Pieza;

import java.util.Scanner;

public class Dinamica {
    public void bienvenidaJuego() {
        System.out.println("----------------------------------------------------");
        System.out.println("-------------Bienvenido al mejor ajedrez------------");
        System.out.println();
        System.out.println("-------------Autores: Adrian Venegas    -------------");
        System.out.println("-------------         Leandro Ribeiro   -------------");

        System.out.println("-----------------------------------------------------");
        System.out.println("-----------------------------------------------------");
        mostrarMenu();
    }


    public void mostrarMenu() {
        System.out.println("--------------------       MENU           -----------");
        System.out.println("---------------- 1- Registro de jugadores -----------");
        System.out.println("---------------- 2- Iniciar Juego         -----------");
        System.out.println("---------------- 3- Reglas                -----------");
        System.out.println("---------------- 4- Salir                 -----------");
        menuFunc();
    }

    public void menuFunc() {
        Scanner sc = new Scanner(System.in);
        System.out.print("ELIJA OPCION:    ");
        int opcionMenu = sc.nextInt();
        System.out.println();

        while (opcionMenu != 4) {
            switch (opcionMenu) {
                case 1:
                    //Registro jugadores
                    break;
                case 2:
                    iniciarJuego();
                    break;
                case 3:
                    //Reglas
                    break;
                default:
                    System.out.println("Ingrese una opcion valida");
                    mostrarMenu();
                    break;
            }
            opcionMenu = sc.nextInt();
        }
    }

    private static void iniciarJuego() {
        Tablero tablero = new Tablero();
        tablero.crearMapPiezas();
        tablero.iniciarTablero();
        pedirPosicionMovimiento(tablero);
    }

    private static void pedirPosicionMovimiento(Tablero tablero) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ahora elija la pieza a mover: ");
        System.out.println("Elija el numero de la fila:   ");
        int xIni = sc.nextInt();
        sc.nextLine();
        System.out.println("Elija la letra de la columna: ");
        int yIni = tablero.getColumnaIndex(sc.nextLine().toUpperCase());

        Pieza pieza = tablero.obtenerPiezaByPosicion(xIni,yIni,Tablero.NEGRO);
        if(pieza == null){
            System.out.println("Ingrese una pieza valida");
        }else{

//            boolean movimientoValido = tablero.validarPosicionAMover(pieza.getPosicion_x(), yIni);
//            System.out.println(movimientoValido);
            int xFin=-1;
            int yFin=-1;
            mostrarMensajeSegunPieza(sc, pieza, xFin,yFin);

        }


    }


    private static void mostrarMensajeSegunPieza( Scanner sc,Pieza pieza,  int xFin, int yFin ){
        switch (pieza.getNombre().substring(0,pieza.getNombre().length()-1)){
            case Tablero.ALFIL_BLANCO, Tablero.ALFIL_NEGRO:
                System.out.println("Prueba alfil");
                break;
            case Tablero.CABALLO_BLANCO , Tablero.CABALLO_NEGRO:
                System.out.println("Prueba caballo");

                break;

            case Tablero.PEON_BLANCO, Tablero.PEON_NEGRO:
                System.out.println("Prueba peon");

                break;
            case Tablero.TORRE_BLANCO, Tablero.TORRE_NEGRO:
                System.out.println("Prueba torre");

                break;
            case Tablero.REINA_BLANCO, Tablero.REINA_NEGRO:
                System.out.println("Prueba reina");

                break;
            case Tablero.REY_BLANCO, Tablero.REY_NEGRO:
                System.out.println("Prueba rey");

                break;
        }
    }

}
