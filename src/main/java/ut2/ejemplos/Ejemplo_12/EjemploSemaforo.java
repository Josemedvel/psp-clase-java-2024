package ut2.ejemplos.Ejemplo_12;

import java.util.concurrent.Semaphore;

public class EjemploSemaforo {
    int i = 0;

    public void printSomething(){
        i++;
        System.out.println("-Valor actual de i: " + i);
    }
    public static void main(String[] args) {
        final EjemploSemaforo example = new EjemploSemaforo();
        final Semaphore semaphore = new Semaphore(1);
        // el 1 es el número de hilos que pueden acceder concurrentemente a la zona crítica


        //aquí hacemos una clase anónima
        final Runnable r = new Runnable(){
          @Override
          public void run(){
              try{
                  semaphore.acquire();
                  //sección crítica
                  example.printSomething();
                  Thread.sleep(1000);
                  semaphore.release();
              }catch(InterruptedException ex){
                  ex.printStackTrace();
              }
          }
        };
        new Thread(r).start();
        new Thread(r).start();
        new Thread(r).start();
    }
}
