package clases.juego;

import java.util.List;
import java.util.Scanner;

public class Mensaje {
    //    Aqui tendremos los mensajes que se mostraran
    private Scanner sc = new Scanner(System.in);


    public void bienvenidaJuego() {
        System.out.println("----------------------------------------------------");
        System.out.println("-------------Bienvenido al AJEDREZ TORO------------");
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

    }

    public int elegirOpcionMenu() {
        System.out.print("ELIJA OPCION:    ");
        String opcion = sc.nextLine();
        boolean opcionValida = false;
        while (!opcionValida) {
            if((opcion.length() > 1 || opcion.length() < 1) || !Character.isDigit(opcion.charAt(0)) ){
                mostrarMsjIngreseValida("opcion");
                mostrarMenu();
                opcion = sc.nextLine();

            }else{
//                    mostrarMsjIngreseValida("opcion");
                    opcionValida=true;
            }
        }
        System.out.println();
        return Integer.parseInt(opcion);
    }

    public String funcionalidadMovimiento(Tablero tablero, List<String> movimientos) {
        System.out.println("Estas son los posibles movimientos: (aparecera el nombre de la casilla en verde) ");
        tablero.mostrarTablero(true, movimientos);
        System.out.println("Ingrese el nombre de la casilla a la que se quiere mover: (ingresa 'x' para cancelar)");

        String casilla = sc.nextLine();

        return casilla;

    }

    public int[] pedirPosicionDePiezaParaElegir(Tablero tablero) {
        int posicionPiezaX = -1;
        int posicionPiezaY = -1;
        int[] result = {posicionPiezaX, posicionPiezaY};

        System.out.println("Elija el numero de la fila y letra de columna:   ");
        System.out.println("(por ejemplo 1A, aquí elegerias la fila 1 y columna A)");
        String posicionPieza = sc.nextLine();

        boolean posicionValida = false;
        String[] posAux = posicionPieza.split("");
        while (!posicionValida && posicionPieza.toUpperCase().charAt(0) != 'X') {
            if (posicionPieza.length() == 2) {
                posAux = posicionPieza.split("");
                if (Character.isDigit(posAux[0].charAt(0)) &&
                        Character.isLetter(posAux[1].toUpperCase().charAt(0)) &&
                        Integer.parseInt(String.valueOf(posAux[0].charAt(0))) < 8 &&
                        tablero.getIndexByLetra(posAux[1]) != -1
                ) {
                    posicionValida = true;
                }
            }

            if (!posicionValida) {
                mostrarMsjIngreseValida("pieza");
                mostrarXparaSalir();
                posicionPieza = sc.nextLine();
            } else {
                result[0] = Integer.parseInt(posAux[0]);

                result[1] = tablero.getIndexByLetra(posAux[1]);
            }
        }

        return result;
    }

    public String pedirCasillaValida() {
        mostrarMsjIngreseValida("casilla");
        String casilla = sc.nextLine();
        return casilla;
    }


    public void mostrarMsjIngreseValida(String texto) {
        System.out.println("Ingrese una " + texto + " valida: ");
    }

    public void mostrarXparaSalir() {
        System.out.println("(ingresa 'X' para cancelar)");
    }
    public void agradecimientoSalida(){
        System.out.println("Gracias por jugar al mejor AJEDREZ TORO");
    }
}
