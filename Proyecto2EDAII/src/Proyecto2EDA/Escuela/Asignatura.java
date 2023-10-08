package Proyecto2EDA.Escuela;
import java.util.Scanner;

/**Clase que almacena los datos de una asignatura y los metodos para procesar esos datos.
 * 
 <p>Autor: Daniel Hernandez</p>
 <p>Ultima modificación 07/09/2023</p> 
 */
public class  Asignatura implements Comparable<Asignatura>{
    private String Nombre;
    private int clave;
    /**Numero de asignaturas creadas.
     * 
     */
    public static int cont=0;


    /**
     * 
     * @param Nombre Nombre de la asignatura.
     * @param clave Clave numerica de la asignatura.
     */
    public Asignatura  (String Nombre, int clave) {
        this.Nombre = Nombre;
        this.clave = clave;
    }
    
    /**
     * 
     * @param clave Clave numerica de la asignatura.
     */
    public Asignatura  (int clave) {
        this.clave = clave;
    }
        /** Crea una nueva asignatura.
         * 
         * @return Objeto Asignatura.
         */
        public static Asignatura crear(){
            //scanner
        Scanner cin = new Scanner(System.in);
        System.out.println("Asignatura");
        System.out.println("Dame el nombre de la asignatura");
        String n= cin.nextLine();
        System.out.println("Dame la clave de la asignatura");
        int key = cin.nextInt();
      
        

        Asignatura A = new Asignatura(n, key);
        cont++;
        return A;
    }





    /** Genera una cadena de texto a partir de los datos de la asignatura.
     * 
     * @return Datos de la asignatura en forma de texto.
     */
    @Override
    public String toString() {
        return "Asignatura:[" +
            "Nombre= " + getNombre() + "\n" +
            "clave= " + getClave() + "\n" +
            "]";
    }



    /**Getter del nombre
     * 
     * @return Nombre de la asignatura.
     */
    public String getNombre() {
        return this.Nombre;
    }
    
    /**Setter del nombre
     * 
     * @param Nombre Nombre de la asignatura.
     */
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    /** Getter de la clave.
     * 
     * @return Clave de la asignatura.
     */
    public int getClave() {
        return this.clave;
    }
    
    /**Setter de la clave
     * 
     * @param clave Clave de la asignatura.
     */
    public void setClave(int clave) {
        this.clave = clave;
    }

    /** Define la igualdad entre objetos de la clase Asignaura.
     * 
     * @param obj Objeto Asignatura.
     * @return Booleano resultado de comparar las claves.
     */
    @Override
    public boolean equals(Object obj) {

        Integer entero = (Integer) obj;
        
    return this.clave == entero.intValue();   // Compara solo el atributo clave
}

/**Define la comparacion entre objetos de la clase Asignatura.
 * 
 * @param A2 Objeto Asignatura.
 * @return 0 si son iguales, menor que 0 si es menor, mayor que 0 si es mayor.
 */
@Override
    public int compareTo(Asignatura A2) {
        return Integer.compare(this.getClave(), A2.getClave());
    }









}
