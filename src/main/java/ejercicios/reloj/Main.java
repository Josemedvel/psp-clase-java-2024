package ejercicios.reloj;

public class Main {
    public static void main(String[] args) {
        HiloTIC hTic = new HiloTIC();
        HiloTAC hTac = new HiloTAC();
        hTic.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        hTac.start();
    }
}
