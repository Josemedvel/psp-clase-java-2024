package ut2.ejemplos.Ejemplo_03;
import java.time.Instant;
import java.time.Duration;
public class Ejemplo03 extends Thread{
    @Override
    public void run() {
        long segundos_maximos = 5;
        Instant inicio = Instant.now();

        while(Duration.between(inicio, Instant.now()).getSeconds() < segundos_maximos){
            System.out.println("Todavía ejecuto");
            System.out.println("Estamos en el segundo "+Duration.between(inicio, Instant.now()).getSeconds());
            try{
                Thread.sleep(1000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println("He terminado");
    }

    public static void main(String[] args) {
        Ejemplo03 hilo_temporal = new Ejemplo03();
        hilo_temporal.start();
        try {
            hilo_temporal.join();
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
