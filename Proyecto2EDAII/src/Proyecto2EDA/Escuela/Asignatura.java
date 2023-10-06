package Proyecto2EDA.Escuela;
import java.util.Scanner;
public class  Asignatura implements Comparable<Asignatura>{
    private String Nombre;
    private int clave;
    public static int cont=0;



    public Asignatura  (String Nombre, int clave) {
        this.Nombre = Nombre;
        this.clave = clave;
    }
    
    public Asignatura  (int clave) {
        this.clave = clave;
    }

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






    @Override
    public String toString() {
        return "Asignatura:[" +
            "Nombre= " + getNombre() + "\n" +
            "clave= " + getClave() + "\n" +
            "]";
    }




    public String getNombre() {
        return this.Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }


    public int getClave() {
        return this.clave;
    }

    public void setClave(int clave) {
        this.clave = clave;
    }

    @Override
    public boolean equals(Object obj) {

        Integer entero = (Integer) obj;
        
    return this.clave == entero.intValue();   // Compara solo el atributo clave
}
@Override
    public int compareTo(Asignatura A2) {
        return Integer.compare(this.getClave(), A2.getClave());
    }









}
