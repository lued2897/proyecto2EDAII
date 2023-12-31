package Proyecto2EDA;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import Proyecto2EDA.Busquedas.BB;
import Proyecto2EDA.Busquedas.BL;
import Proyecto2EDA.Escuela.*;
import Proyecto2EDA.Utilerias.Utilerias;

/** Clase Main de la actividad 2: busqueda.
 * 
 <p>Autor: Daniel Hernandez</p>
 <p>Ultima modificación 07/09/2023</p>
 */
public class Main {
    public static void main(String[] args) {

        LinkedList<Alumno> a = new LinkedList<>();
        LinkedList<Asignatura> m  = new LinkedList<>();
        int s;
        Scanner cin = new Scanner(System.in);
       
        
        do{
                Utilerias.clearScreen();
                System.out.println("Bienvenido al sistema de busqueda de alumnos");
                System.out.println("Escoge una opcion");
                System.out.println("1.-Agregar Alumno");
                System.out.println("2.-Agregar materia");
                System.out.println("3.-Imprimir Listas");
                System.out.println("4.-Busqueda lineal");
                System.out.println("5.-Busqueda Binaria");
                s=cin.nextInt();
                switch (s) {
                case 1: a.add(Alumno.crear());break;
                case 2: m.add(Asignatura.crear()); break;
                case 3: System.out.println("1.-Lista Alumnos 2.-Lista Materias"); s=cin.nextInt(); if(s==1){Imprimir(a);}else{Imprimir(m);} ; break;
                case 4: BL.menu(a, m);break;
                case 5: BB.menu(a, m);break;
                default:
                return;
            }
        }while(true);
}
    
/**Imprime el contenido de una lista
 * 
 * @param list Lista ligada de alumnos o materias 
 */
public static void Imprimir(LinkedList<?> list){
if(list.isEmpty()){
        System.out.println("Lista vacia");
        Utilerias.pause();
        return;
}
for (Object object : list) {
        System.out.println(object.toString());
}
Utilerias.pause();



}


}
