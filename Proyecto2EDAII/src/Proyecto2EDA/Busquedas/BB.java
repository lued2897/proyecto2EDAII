package Proyecto2EDA.Busquedas;
import java.util.Scanner;

import Proyecto2EDA.Escuela.Alumno;
import Proyecto2EDA.Escuela.Asignatura;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class BB{






    static Scanner sc = new Scanner(System.in);
 

    
    static public <T extends Comparable<T>> int BBI (T v, List<T> list){
        int b = -1;
        int mid= (list.size()-1)/2;
        if (list.isEmpty()) {
            return b; 
        }    
        //System.out.println(mid);
        if(list.get(mid).compareTo(v)==0){
                b=mid;
              return b;
              
        }else if(list.get(mid).compareTo(v)>0){
            b=mid+1;
            b+=BBI(v, list.subList(mid+1, list.size()));
        }else if(list.get(mid).compareTo(v)<0){
            b=0;
            b+=BBI(v, list.subList(0,mid));
        }

        return b;
    }

    static public <T extends Comparable<T>> LinkedList<Integer> EncontrarIndicesdetodaslasincidencias (T v, List<T> list, int mid){
               LinkedList<Integer> index = new LinkedList<>();
                       if (mid<0) {
                     return index; 
                     }  
               index.add(mid);
              int lb=mid-1;
              int rbound = mid +1;

              do{
                
                 if(list.get(lb).compareTo(v)==0){
                  index.add(lb);
                  lb--;
                 }
                  if(list.get(rbound).compareTo(v)==0){
                       index.add(rbound);
                  rbound++;
                 }
              }while(list.get(lb).compareTo(v)==0 || list.get(rbound).compareTo(v)==0);

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
        System.out.println("Lista oirdenada para Binary Search");
        imprimirLista(list);
        
        int ind=BBI((T)v, list);
        LinkedList<Integer> index = EncontrarIndicesdetodaslasincidencias((T)v, list, ind);
        do {
            System.out.println("Escoge una opcion: ");
            System.out.println("1.-Busqueda Booleana");
            System.out.println("2.-Indice encontrado");
            System.out.println("3.-Cantidad de veces encontrado");

            int s = sc.nextInt();
            switch (s) {
                case 1:
       
                    if(ind!=-1){
                        System.out.println("Encontrado");
                    }else{
                        System.out.println("No encontrado");
                    }
                    break;
                case 2:
                    if(ind>=0){
                        IO(index, list);
                    }else{
                        System.out.println("No encontrado");
                    }
            
                    break;
                case 3:
                    System.out.println("Numero encontrado " + index.size() + " veces");
                    
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