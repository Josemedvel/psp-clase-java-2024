package ut2.ejercicios.productor_consumidor;
import java.util.Random;
public class Productor extends Thread{
    private static int id = 0;
    private final static Random rng = new Random();
    private final BufferCompartido buffer;
    public Productor(BufferCompartido buffer) {
        super("Productor " + id);
        this.buffer = buffer;
        id++;
    }
    @Override
    public void run() {
        try {
            while (true) {
                if(buffer.acquireSemaforoProductor()){
                    int numero = rng.nextInt(1,100);
                    System.out.println(getName()+ ": Produciendo " + numero);
                    buffer.producir(numero);
                    int tiempoProduccion = 1000;
                    sleep(tiempoProduccion);
                    buffer.releaseSemaforoConsumidor();
                }
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }


    }
}
