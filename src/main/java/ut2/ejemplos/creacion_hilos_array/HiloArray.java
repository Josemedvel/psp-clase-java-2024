package ut2.ejemplos.creacion_hilos_array;

public class HiloArray extends Thread{
    public HiloArray(String nombre){
        super(nombre);
    }
    @Override
    public void run(){
        System.out.println("Ejecutando " + getName());
    }
}
