package ut2.ejemplos.creacion_hilos_array;

public class Main {
    public static void main(String[] args) {
        HiloArray[] array = new HiloArray[100];
        for(int i = 0; i < array.length; i++){
            array[i] = new HiloArray("Hilo " + i);
            array[i].start();
        }
        for(int i = 0; i < array.length; i++){
            try{
                array[i].join();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println("EJECUCION TERMINADA");

    }
}
