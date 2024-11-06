package ut2.ejemplos.primer_ejemplo;

public class HiloClase extends Thread{
    public HiloClase(String nombre){
        super(nombre);
    }

    @Override
    public void run(){
        for(int i = 0; i < 200; i++){
            System.out.println("Hola desde el hilo:" + getName() +", con prioridad: " + getPriority());
        }
    }
}
