package proyecto2;

import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class Encadenamiento {
    
    public static void main(String[] args) {
        int opt= 0;
        LinkedList<Integer>[] t= new LinkedList[15];
        initLists(t);
        Scanner scan = new Scanner(System.in);
        
        while(opt != -1){
            Random rand= new Random();
            printMenu();
            opt = readInt();
            System.out.println(opt);
            System.out.println();
            
            
            switch(opt){
                case 0:
                    System.out.println("Ingrese el valor del elemento:");
                    int i = rand.nextInt(0,15);
                    t[i].add(readInt()); 
                    break;
                    
                case 1:
                    System.out.println("Contenido de la lista:");
                    System.out.println(Arrays.toString(t));
                    break;
                    
                case 2:
                    System.out.println("Adios");
                    opt= -1;
                    break;
                    
                default:
                    System.out.println("Opcion invalidia");
                    break;
            }
        }
            
    }
    
    private static void initLists(LinkedList[] t){
        
        for(int i=0; i<t.length; i++){
            t[i] = new LinkedList<Integer>();
        }
        
    }
    
    
    private static void printMenu(){
        System.out.println("****** Opciones: ******");
        System.out.println("(0) Agregar elemento:");
        System.out.println("(1) Mostrar lista:");
        System.out.println("(2) Salir:");
        System.out.println("Seleccione una opcion:");
    }
    
    private static int readInt(){
        
        int x;
        boolean isInt = false;
        do{
            //System.out.println("Ingrese un numero entero: ");
            try{
                Scanner scan = new Scanner(System.in);
                //scan.reset();
                x= scan.nextInt();
                return x;
            }catch (java.util.InputMismatchException e){
                System.out.println("*Error, no es un entero*\nIngrese un numero entro: ");
            }
        }while(!isInt); 
        return -1;
    }
    
    private static void printList(LinkedList[] t){
        
    }
}
