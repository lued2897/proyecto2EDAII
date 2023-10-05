package Proyecto2EDA.Busquedas;
import java.util.Scanner;

import Proyecto2EDA.Escuela.Alumno;

import java.util.LinkedList;
import java.util.List;

public class BB{
    private boolean rb;
    private LinkedList<Integer> ind;
    private int c=0;



    public BB(boolean rb, LinkedList<Integer> ind, int c) {
        this.rb = rb;
        this.ind = ind;
        this.c = c;
    }


    public boolean isRb() {
        return this.rb;
    }

    public boolean getRb() {
        return this.rb;
    }

    public void setRb(boolean rb) {
        this.rb = rb;
    }

    public LinkedList<Integer> getInd() {
        return this.ind;
    }

    public void setInd(LinkedList<Integer> ind) {
        this.ind = ind;
    }

    public int getC() {
        return this.c;
    }

    public void setC(int c) {
        this.c = c;
    }



    static Scanner sc = new Scanner(System.in);
 

     public BB BBC (object v, List<?> list){
        boolean bl;
        BB OBB = new BB(bl, ind, c);
      int lb;
      int rbound;
        int mid= (list.size()-1)/2;
       int t=list.size()-1;
        if(v==list.get(mid)){
             b++;
             lb=mid-1;
             rbound = mid +1;
            do{
               if(list.get(lb)==v){
                lb--;
                b++;
               }
                if(list.get(rbound)==v){
                rbound--;
                b++;
               }
              
                
 
            }while(list.get(lb)!=list.get(mid) && list.get(rbound)!=list.get(mid));
            return b;



        }else if(v> list.get(mid)){
            b=BBC(v, list.subList(mid+1, list.size()));
        }else if(v<list.get(mid)){
            b=BBC(v, list.subList(0,mid));
        }

        return b;

    }





    static public void menu(LinkedList<?> list){
        boolean c=true;

        System.out.println("Que valor quieres buscar");
        int v = sc.nextInt();
        list.sort(null);
        System.out.println("Lista oirdenada para Binary Search");
        E1.imprimirLista(list);
        do {
            System.out.println("Escoge una opcion: ");
            System.out.println("1.-Busqueda Booleana");
            System.out.println("2.-Indice encontrado");
            System.out.println("3.-Cantidad de veces encontrado");

            int a = sc.nextInt();
            switch (a) {
                case 1:
                    boolean b =BBB(v, list);
                    if(b){
                        System.out.println("Encontrado");
                    }else{
                        System.out.println("No encontrado");
                    }
                    break;
                case 2:
                    if(BBI(v, list)>=0){
                        System.out.println("Numero encontrado en el indice " + BBI(v, list));
                    }else{
                        System.out.println("No encontrado");
                    }
            
                    break;
                case 3:
                    System.out.println("Numero encontrado " + BBC(v, list) + " veces");
                    break;
                default:

                return;
            }



        } while (c);



    }





    
}