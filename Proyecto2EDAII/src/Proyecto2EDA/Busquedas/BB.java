package Proyecto2EDA.Busquedas;
import java.util.Scanner;
import Proyecto2EDA.Escuela.Alumno;
import Proyecto2EDA.Escuela.Asignatura;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import Proyecto2EDA.Utilerias.Utilerias;
public class BB{






    static Scanner sc = new Scanner(System.in);
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



    public static void IO(LinkedList<Integer> list, LinkedList<?> list2 ){
        System.out.println("Sistema de impresion");
        for (int i = 0; i < list.size(); i++) {
            System.out.println("Encontrado en el Indice: " + list.get(i) );
            System.out.println(list2.get(list.get(i)).toString());
        }
    }
    

    public static void imprimirLista(List<?> listaPrint){ 
        if(listaPrint.isEmpty())
        System.out.println("Lista vacia");
    
        for(Object var : listaPrint){
                System.out.println(var);
            }
    }

    
}