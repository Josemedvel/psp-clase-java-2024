package formas_hilo;

public class HiloThread extends Thread{
    public HiloThread(String nombre){
        super(nombre);
    }

    @Override
    public void run(){
        System.out.println("Ha ejecutado: " + getName());
    }
}
