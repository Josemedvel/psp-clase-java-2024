package ut2.ejemplos.terminacion_hilo;

public class HiloParada extends Thread{
    private boolean ejecucion = true;
    private int contador = 0;
    public HiloParada(String nombre){
        super(nombre);
    }
    @Override
    public void run(){
        while(ejecucion){
            System.out.println(getName()+ ": "+ (contador++));
            try{
                sleep(1000);
            }catch(InterruptedException ex){
                ex.printStackTrace();
            }
        }
    } // run
    public void parar(){
        ejecucion = false;
    }
}
