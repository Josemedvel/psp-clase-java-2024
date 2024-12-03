package ut2.ejercicios.productor_consumidor;

// recurso compartido
import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class BufferCompartido {
    private final Semaphore semaforoProductor;
    private final Semaphore semaforoConsumidor;
    private ArrayList<Integer> buffer = new ArrayList<>();
    public BufferCompartido(int capacityProductor, int capacityConsumidor) {
        semaforoProductor = new Semaphore(capacityProductor);
        semaforoConsumidor = new Semaphore(0); // empieza teniendo 0
    }
    public synchronized Integer consumir(){
        return buffer.remove(0);
    }
    public synchronized void producir(Integer numero){
        buffer.add(numero);
    }
    public boolean acquireSemaforoConsumidor(){
        try{
            semaforoConsumidor.acquire();
            return true;
        }catch(InterruptedException e){
            return false;
        }
    }
    public boolean acquireSemaforoProductor(){
        try{
            semaforoProductor.acquire();
            return true;
        }catch(InterruptedException e){
            return false;
        }
    }
    public void releaseSemaforoProductor(){
        semaforoProductor.release();
    }
    public void releaseSemaforoConsumidor(){
        semaforoConsumidor.release();
    }
    public Semaphore getSemaphoreProductor(){
        return semaforoProductor;
    }
    public Semaphore getSemaphoreConsumidor(){
        return semaforoConsumidor;
    }
    public int getBufferSize(){
        return buffer.size();
    }
}
