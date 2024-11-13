package ut2.ejemplos.Ejemplo02_2;

public class Ejemplo02_2 extends Thread{
    @Override
    public void run() {
        System.out.println(
                "Dentro del hilo : " + Thread.currentThread().getName()
                + "\n\tPrioridad : " + Thread.currentThread().getPriority()
                + "\n\tID :        " + Thread.currentThread().threadId()
                + "\n\tHilos activos : " + Thread.activeCount()
        );
    }

    public static void main(String[] args) {
        Thread.currentThread().setName("Principal");
        System.out.println(Thread.currentThread().getName());
        System.out.println(Thread.currentThread());

        Ejemplo02_2 h = null;

        for (int i = 0; i < 3; i++) {
            h = new Ejemplo02_2(); //crear hilo
            h.setName("HILO " + i);    //damos nombre al hilo
            h.setPriority(i + 1);     //damos prioridad
            h.start();              //iniciar hilo	  

            System.out.println(
                    "Informacion del " + h.getName() + ": " + h.toString());
        }
        System.out.println("3 HILOS CREADOS...");
        System.out.println("Hilos activos: " + Thread.activeCount());
    }
}
