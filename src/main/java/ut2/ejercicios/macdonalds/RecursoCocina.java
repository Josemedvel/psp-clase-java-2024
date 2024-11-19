package ut2.ejercicios.macdonalds;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
public class RecursoCocina {
    private final String nombre;
    private final int usosConcurrentes;
    private int usosActuales = 0;
    private final Lock lock = new ReentrantLock();
    private final Condition concurrente = lock.newCondition();

    public RecursoCocina(String nombre, int capacidadMaxima) {
        this.nombre = nombre;
        this.usosConcurrentes = capacidadMaxima;
    }

    public void usarRecurso(Comida comida) {
        lock.lock();
        try{
            while (usosActuales >= usosConcurrentes) {
                concurrente.await(); // la comida del pedido espera a ser preparada
            }
            usosActuales++;
            Thread.sleep(comida.getTiempoPreparacion());
            System.out.println(comida.getNombre() + " del pedido " + comida.getPedido().getIdPedido()+ " preparado");
            comida.getPedido().notificarComidaLista();
            usosActuales--;
            concurrente.signalAll();
        }catch(InterruptedException e){
            e.printStackTrace();
        }finally{
            lock.unlock();
        }
    }
}
