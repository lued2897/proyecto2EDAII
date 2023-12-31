package Proyecto2EDA.Busquedas;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.List;
import Proyecto2EDA.Escuela.*;
import Proyecto2EDA.Utilerias.Utilerias;


/**Busqueda lineal en objetos.
 * 
 <p>Autor: Daniel Hernandez</p>
 <p>Ultima modificación 07/09/2023</p> 
 */
public class BL{

     private boolean rb;
     private LinkedList<Integer> ind;
     private int c=0;

    /**
     * 
     * @param rb Resultado de la busqueda.
     * @param ind Indices del objeto.
     * @param c Numero de veces que aparece el objeto.
     */
    public BL(boolean rb, LinkedList<Integer> ind, int c) {
        this.rb = rb;
        this.ind = ind;
        this.c = c;
    }
    
    /**
     * 
     * @return Resultado de la busqueda.
     */
    public boolean isRb() {
        return this.rb;
    }
    
    /** Getter Resultado
     * 
     * @return Resultado de la busqueda
     */
    public boolean getRb() {
        return this.rb;
    }
    
    /** Setter Resultado
     * 
     * @param rb Resultado de la busqueda, True o False.
     */
    public void setRb(boolean rb) {
        this.rb = rb;
    }
    
    /** Getter Indices
     * 
     * @return Lista de indices del elemento buscado.
     */
    public LinkedList<Integer> getInd() {
        return this.ind;
    }

    /** Setter indices
     * 
     * @param ind Lista de indices del elemento buscado.
     */
    public void setInd(LinkedList<Integer> ind) {
        this.ind = ind;
    }
    
    /** Getter Conteo
     * 
     * @return Conteo de apariciones del elemento buscado.
     */
    public int getC() {
        return this.c;
    }

    /** Setter Conteo
     * 
     * @param c Conteo de apariciones del elemento buscado.
     */
    public void setC(int c) {
        this.c = c;
    }



    static Scanner sc = new Scanner(System.in);
    /**
     * 
     * @param v Elemento que se busca.
     * @param list Lista en donde se busca.
     * @return Objeto Bl, contiene resultado, indices y conteo de la busqueda.
     */
    static public BL BLB (Object v, List<?> list){
        boolean b = false;
        int count=0;
        LinkedList<Integer> index = new LinkedList<>();
        int j=0;
        for (Object i : list) {
            if(i.equals(v)){
                b=true;
                count++;
                index.add(j);
            }
            j++;
        }
        BL OBL = new BL(b, index, count);
        return OBL;
   }

    



    /** Menu de usuario para busqueda lineal.
     * 
     * @param a Lista de alumnos.
     * @param m Lista de asignaturas
     */
    static public void menu(LinkedList<Alumno> a, LinkedList<Asignatura> m ){
        boolean c=true;
        Object v = null;
        LinkedList<?> list = new LinkedList<>();
        System.out.println("Que quieres buscar?");
        System.out.println("1.-Alumno por nombre");
        System.out.println("2.- Materia por clave");
        int d= sc.nextInt();
        sc.nextLine();
        Utilerias.clearScreen();
        if(d==1){
            System.out.println("Dame el nombre del alumno");
            list = a;
            v = sc.nextLine();
        }else{
            System.out.println("Dame la clave de la materia");
            list = m;
             v = sc.nextInt();
             
        }
   
        BL OBL = BLB(v, list);
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
                    boolean b = OBL.getRb();
                    if(b){
                        System.out.println("Encontrado");
                    }else{
                        System.out.println("No encontrado");
                    }
                    Utilerias.pause();
                    break;
                case 2:
                    if(OBL.getC()>0){
                        System.out.println("Numero encontrado en los indices: ");
                       for (int i = 0; i < OBL.getInd().size(); i++) 
                        System.out.println("Encontrado en el Indice: " + OBL.getInd().get(i) );
    
                    }else{
                        System.out.println("No encontrado");
                    }
               Utilerias.pause();
                    break;
                case 3:
                    System.out.println("Numero encontrado " + OBL.getC() + " veces");
                    OBL.IO( list);
                    Utilerias.pause();
                    break;
                case 4: 
                    if(OBL.getRb()==true){
                         OBL.IO( list);
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

    /** Imprime los valores de una lista.
     * 
     * @param list Lista de objetos.
     */
    public void IO(LinkedList<?> list ){
        System.out.println("Sistema de impresion");
        for (int i = 0; i < this.getInd().size(); i++) {
            System.out.println("Encontrado en el Indice: " + this.getInd().get(i) );
            System.out.println(list.get(this.getInd().get(i)).toString());



        }



    }




    
}

