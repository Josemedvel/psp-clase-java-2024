package ut2.ejemplos.Ejemplo_12;

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Lock;

public class IncrementadorLento extends Thread{
    private final String id;
    private final ContadorCompartido cc;
    // imprescindible hacer el bloqueo estático para que sea común a todos los hilos
    private static Lock bloqueo = new ReentrantLock();
    public IncrementadorLento(String id, ContadorCompartido cc){
        this.id = id;
        this.cc = cc;
    }
    @Override
    public void run(){
        bloqueo.lock();
        try{
            int valor = cc.getN();
            valor++;
            sleep(1000);
            cc.setN(id, valor);
        }catch(InterruptedException ex){
            System.err.println(id + ": " + ex);
        }finally{ // necesario en caso de interrupción
            bloqueo.unlock();
        }
    }
}
