package Proyecto2EDA.Utilerias;

/**
 * Este archivo contiene funciones de Utileria
 * @author Daniel H., Isaac L., Sebastian J.
 * @version 1.0
 */

public class Utilerias{
    /**
     * Se encarga de limpiar lo que se muestra en pantalla para tener una ejecucion lo mas limpia posible
    */
    public static void clearScreen(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    /**
     * Se encarga de dar una ligera pausa hasta que se presione una tecla
    */

    public static void pause(){
        System.out.println("Press Any Key To Continue...");
        new java.util.Scanner(System.in).nextLine();
    }
}