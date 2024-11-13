package ut2.ejemplos.Ejemplo_04;
// en este ejemplo habrá veces que podremos terminar y otras que saltará la excepción
public class Ejemplo04 extends Thread{
    public void interrumpir(){
        interrupt();
    }
    @Override
    public void run() {
        try{
            while(!isInterrupted()){
                System.out.println("Inicio del bucle del hilo y hago cosas");
                sleep(1);
                System.out.println("Fin del bucle del hilo... aquí habríamos terminado de hacer lo necesario");
            }
        }catch(InterruptedException e){
            System.out.println("HA OCURRIDO UNA EXCEPCION");
        }
        System.out.println("Fin del hilo");
    }

    public static void main(String[] args) {
        Ejemplo04 hilo = new Ejemplo04();
        hilo.start();
        for(int i = 0; i < 2000000000; i++); //no hace nada
        for(int i = 0; i < 2000000000; i++);
        hilo.interrumpir();
    }
}
