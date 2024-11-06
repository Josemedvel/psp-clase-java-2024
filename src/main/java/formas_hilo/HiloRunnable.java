package formas_hilo;

public class HiloRunnable implements Runnable{
    @Override
    public void run(){
        System.out.println("Ha ejecutado un hilo desde Runnable");
    }
}
