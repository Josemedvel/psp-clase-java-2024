package terminacion_hilo;

public class Main {
    public static void main(String[] args) {
        HiloParada h1 = new HiloParada("H1");
        HiloParada h2 = new HiloParada("H2");
        HiloParada h3 = new HiloParada("H3");
        h1.start();
        h2.start();
        h3.start();
        try{
            Thread.sleep(3000);
            h2.parar();
            h3.parar();
        }catch(InterruptedException ex){
            ex.printStackTrace();
        }
    }
}
