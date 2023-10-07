package Proyecto2EDA.Busquedas;
import java.util.Scanner;
import Proyecto2EDA.Escuela.Alumno;
import Proyecto2EDA.Escuela.Asignatura;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import Proyecto2EDA.Utilerias.Utilerias;

/**Busqueda binaria en objetos.
 * 
 <p>Autor: Daniel Hernandez</p>
 <p>Ultima modificación 07/09/2023</p> 
 */
public class BB{





    /**
     * Scanner para leer datos ingresados por el usuario
     */
    static Scanner sc = new Scanner(System.in);
    
    /**Busqueda de indice
     * 
     * @param <T> Objeto generico comparable, alumno o asignatura.
     * @param v Elemento buscado.
     * @param list Lista en donde buscar.
     * @return Indice del valor encontrado, regresa -1 si falla.
     */
    static public <T extends Comparable<T>> int BBI (T v, List<T> list){
        if(list.isEmpty())
        return-1;
        int b = -1;
        int aux=0;
        int mid= (list.size())/2;
        
        if(v.compareTo(list.get(mid))==0){
                b=mid;
              return b;      
        }else if(v.compareTo(list.get(mid))>0){
            aux+=BBI(v, list.subList(mid+1, list.size()));
            if(aux==-1){
                 return -1;  
            }else{
              
                b=mid+1+aux;
            }
        }else if(v.compareTo(list.get(mid))<0){
            b=0;
            b+=BBI(v, list.subList(0,mid));
        }
        return b;
    }
    
    /** Busqueda de todas las instancias de un elemento.
     * 
     * @param <T> Objeto generico comparable, alumno o ssignatura.
     * @param v Elemento buscado.
     * @param list Lista en donde buscar.
     * @param mid Indice intermedio de la lista.
     * @return Lista de todos los indices del elemento, regresa una lista vacia si falla.
     */
    static public <T extends Comparable<T>> LinkedList<Integer> EncontrarIndicesdetodaslasincidencias(T v, List<T> list, int mid) {
        LinkedList<Integer> index = new LinkedList<>();
        if (mid<0) {
            return index;
        }
        index.add(mid);
        int lb= mid -1;
        int rbound=mid+ 1;
        while ((lb>=0 && list.get(lb).compareTo(v)==0) || (rbound< list.size() && list.get(rbound).compareTo(v) == 0)) {
            if (lb>=0 && list.get(lb).compareTo(v)==0) {
                index.add(lb);
                lb--;
            }
            if (rbound< list.size() && list.get(rbound).compareTo(v)==0) {
                index.add(rbound);
                rbound++;
            }
        }
        return index;
    }
    
    /** Menu de usuario para busqueda lineal
     * 
     * @param <T> Objeto generico comparable, alumno o Asignatura.
     * @param a Lista de alumnos.
     * @param m Lista de Asignaturas.
     */
    static public <T extends Comparable<T>> void menu(LinkedList<Alumno> a, LinkedList<Asignatura> m ){
        boolean c=true;
        Object v = null;
        LinkedList<T> list = new LinkedList<>();
        System.out.println("Que quieres buscar?");
        System.out.println("1.-Alumno por nombre");
        System.out.println("2.- Materia por clave");
        int d= sc.nextInt();
        sc.nextLine();
        Collections.sort(a);
        Collections.sort(m);
        Utilerias.clearScreen();
        if(d==1){
            System.out.println("Dame el nombre del alumno");
            list = (LinkedList<T>)a;
            String st;
            st=sc.nextLine();
            v = new Alumno(st);
        }else{
            System.out.println("Dame la clave de la materia");
            list = (LinkedList<T>)m;
             int cl = sc.nextInt();
             v = new Asignatura(cl);
             
        }
        Utilerias.clearScreen();
        System.out.println("Lista ordenada para Binary Search");
        imprimirLista(list);
        Utilerias.pause();
        int ind=BBI((T)v, list);
        LinkedList<Integer> index = EncontrarIndicesdetodaslasincidencias((T)v, list, ind);
        do {
            Utilerias.clearScreen();
            System.out.println("Escoge una opcion: ");
            System.out.println("1.-Busqueda Booleana");
            System.out.println("2.-Indice encontrado");
            System.out.println("3.-Cantidad de veces encontrado");
            System.out.println("4.-Todos los datos");
            int s = sc.nextInt();
            switch (s) {
                case 1:
       
                    if(ind!=-1){
                        System.out.println("Encontrado");
                    }else{
                        System.out.println("No encontrado");
                    }
                    Utilerias.pause();
                    break;
                case 2:
                    if(ind>=0){
                            for (Integer integer : index) {
                                System.out.println("Index: " + integer);
                            }
                    }else{
                        System.out.println("No encontrado");
                    }
                      Utilerias.pause();
                    break;
                case 3:
                    System.out.println("Numero encontrado " + index.size() + " veces");
                    Utilerias.pause();
                    break;
                case 4:
                    if(ind!=-1){
                        IO(index, list);
                    }else{
                        System.out.println("No encontrado");
                    }
                    Utilerias.pause();
                break;
                default:
                return;
            }
        } while (c);



    }


    /** Imprime los valores de la lista 2 indicados en la lista 1
     * 
     * @param list Lista de indices.
     * @param list2 Lista de Objetos.
     */
    public static void IO(LinkedList<Integer> list, LinkedList<?> list2 ){
        System.out.println("Sistema de impresion");
        for (int i = 0; i < list.size(); i++) {
            System.out.println("Encontrado en el Indice: " + list.get(i) );
            System.out.println(list2.get(list.get(i)).toString());
        }
    }
    
    /** Imprime los elementos de una lista.
     * 
     * @param listaPrint Lista que se quiere imprimir. 
     */
    public static void imprimirLista(List<?> listaPrint){ 
        if(listaPrint.isEmpty())
        System.out.println("Lista vacia");
    
        for(Object var : listaPrint){
                System.out.println(var);
            }
    }

    
}