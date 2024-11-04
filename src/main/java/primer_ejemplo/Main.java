package primer_ejemplo;

public class Main {
    public static void main(String[] args) {
        HiloClase hilo1 = new HiloClase("Hilo_1");
        HiloClase hilo2 = new HiloClase("Hilo_2");
        HiloClase hilo3 = new HiloClase("Hilo_3");
        hilo1.setPriority(10);
        hilo2.setPriority(5);
        hilo3.setPriority(1);
        hilo1.start();
        hilo2.start();
        hilo3.start();
    }
}
