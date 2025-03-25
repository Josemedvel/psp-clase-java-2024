package ut2.ejercicios.ordinaria;

import java.util.concurrent.Semaphore;

// la mesa tendrá los dos semáforos,
// de poner y de quitar de la mesa
public class Mesa {
    private final Semaphore semaforoCoger = new Semaphore(0,true);
    private final Semaphore semaforoDejar = new Semaphore(10, true);

    public Semaphore getSemaforoCoger() {
        return semaforoCoger;
    }

    public Semaphore getSemaforoDejar() {
        return semaforoDejar;
    }

    public synchronized int getGalletasEntran(){
        return semaforoDejar.availablePermits();
    }

    public synchronized int getGalletasQuedan(){
        return semaforoCoger.availablePermits();
    }

    public void dejarGalleta() {
        try {
            semaforoDejar.acquire(); // se quita un espacio de mesa
            semaforoCoger.release(); // se añade una galleta disponible para comer
            //mostrarPermisos();
        }catch(InterruptedException ex){
            ex.printStackTrace();
        }
    }
    public void cogerGalleta(){
        try{
            semaforoCoger.acquire(); // se consume una galleta
            semaforoDejar.release(); // se deja el hueco para que la abuela ponga otra galleta
            //mostrarPermisos();
        }catch(InterruptedException ex){
            ex.printStackTrace();
        }
    }
    private void mostrarPermisos(){
        System.out.println("SemaforoCoger: " + semaforoCoger.availablePermits());
        System.out.println("SemaforoDejar: " + semaforoDejar.availablePermits());
    }
}
