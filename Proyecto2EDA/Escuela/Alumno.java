package Proyecto2EDA.Escuela;
import java.util.Scanner;

public class Alumno{
public static int cont=0;
private String alumno;
private int ncuenta;

    public Alumno(String alumno, int ncuenta) {
        this.alumno = alumno;
        this.ncuenta = ncuenta;
    }

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




    public String getAlumno() {
        return this.alumno;
    }

    public void setAlumno(String alumno) {
        this.alumno = alumno;
    }

    public int getNcuenta() {
        return this.ncuenta;
    }

    public void setNcuenta(int ncuenta) {
        this.ncuenta = ncuenta;
    }




    @Override
    public String toString() {
        return "Alumno[\n" +
            "alumno= " + getAlumno() + "\n" +
            "ncuenta= " + getNcuenta() + "\n" +
            "]";
    }

    @Override
    public boolean equals(Object obj) {
    return this.getAlumno().equals((String)obj); // Compara solo el atributo clave
}





}