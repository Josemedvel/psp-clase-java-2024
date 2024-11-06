package formas_hilo;

public class Main {
    public static void main(String[] args) {
        HiloThread ht = new HiloThread("Thread");
        ht.start();
        Thread hr = new Thread(new HiloRunnable());
        hr.start();
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("Ha ejecutado un hilo desde Runnable anónimo");
            }
        };
        Thread hra = new Thread(r);
        hra.start();
    }
}
