package ut2.ejercicios.productor_consumidor;

public class Consumidor extends Thread{
    private static int id = 0;
    private final BufferCompartido buffer;
    public Consumidor(BufferCompartido buffer) {
        super("Consumidor " + id);
        this.buffer = buffer;
        id++;
    }
    @Override
    public void run() {
        try {
            while (true) {
                if(buffer.acquireSemaforoConsumidor()){
                    int numero = buffer.consumir();
                    int tiempoConsumo = 500;
                    sleep(tiempoConsumo);
                    System.out.println(getName()+ ": Consumido " + numero);
                    buffer.releaseSemaforoProductor();
                }
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }
}
