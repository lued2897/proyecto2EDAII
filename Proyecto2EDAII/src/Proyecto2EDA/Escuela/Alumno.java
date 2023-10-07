package Proyecto2EDA.Escuela;
import java.util.Scanner;

/**Clase que almacena los datos de un alumno y los metodos para procesar esos datos.
 * 
 <p>Autor: Daniel Hernandez</p>
 <p>Ultima modificación 07/09/2023</p> 
 */
public class Alumno implements Comparable<Alumno>{
/**Numero de alumnos creados
 * 
 */
public static int cont=0;
private String alumno;
private int ncuenta;
    /**
     * 
     * @param alumno Nombre del alumno.
     * @param ncuenta Numero de cuenta.
     */
    public Alumno(String alumno, int ncuenta) {
        this.alumno = alumno;
        this.ncuenta = ncuenta;
    }
    
    /**
     * 
     * @param alumno Nombre del alumno.
     */
    public Alumno(String alumno) {
        this.alumno = alumno;
    }
    
    /** Crea un objetod e clase alumno.
     * 
     * @return Objeto Alumno.
     */
    public static Alumno crear(){
            //scanner
        Scanner cin = new Scanner(System.in);
        System.out.println("Bienvenido al menu de creacion de alumno");
        System.out.println("Dame el nombre del alumno");
        String P=cin.nextLine();
        System.out.println("Dame su numero de cuenta");
        int nc = cin.nextInt();
        Alumno A = new Alumno(P,nc);
        cont++;
        return A;
    }
    
    /**Getter del nombre.
     * 
     * @return Nombre del alumno.
     */
    public String getAlumno() {
        return this.alumno;
    }
    
    /** Setter del nombre
     * 
     * @param alumno Nombre del alumno.
     */
    public void setAlumno(String alumno) {
        this.alumno = alumno;
    }
    
    /** Getter del numero de cuenta.
     * 
     * @return Numero de cuenta del alumno.
     */
    public int getNcuenta() {
        return this.ncuenta;
    }

    /** Setter del numerod de cuenta.
     * 
     * @param ncuenta Numero de cuenta del alumno.
     */
    public void setNcuenta(int ncuenta) {
        this.ncuenta = ncuenta;
    }



    /** Henera una cadena  de texto a partir de la informacion del alumno.
     * 
     * @return Datos del alumno en forma de texto.
     */
    @Override
    public String toString() {
        return "Alumno[\n" +
            "alumno= " + getAlumno() + "\n" +
            "ncuenta= " + getNcuenta() + "\n" +
            "]";
    }

    /** Define Igualdad entre objetos de la clase Alumno.
     * 
     * @param obj
     * @return 
     */
    @Override
    public boolean equals(Object obj) {
    return this.getAlumno().equals((String)obj);
    }

    /**Define la comparacion entre objetos de la clase alumno.
     * 
     * @param A2 Objeto Alumno
     * @return 0 si son iguales, menor que 0 si es menor, mayor que 0 si es mayor.
     */
    @Override
    public int compareTo(Alumno A2) {
       return this.getAlumno().compareTo(A2.getAlumno());
    }



}