package ut2.ejemplos.Ejemplo_05;

public class Ejemplo05 {
    public static void main(String[] args) {
        HijoJoin h1 = new HijoJoin("Hilo 1", 2);
        HijoJoin h2 = new HijoJoin("Hilo 2", 5);
        HijoJoin h3 = new HijoJoin("Hilo 3", 7);

        h1.start();
        h2.start();
        h3.start();

        try{
            h1.join();
            h2.join();
            h3.join();
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Final del programa");
    }
}
