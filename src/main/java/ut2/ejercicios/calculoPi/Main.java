package ut2.ejercicios.calculoPi;

public class Main {
    public static void main(String[] args) {
        // creación del canvas
        Punto centroDiana = new Punto(1,-1);
        int numeroTotalDardos = 100000000;
        int numeroHilos = 8;
        int numDardosPorHilo = numeroTotalDardos / numeroHilos;
        int numDardosSobrantes = numeroTotalDardos % numeroHilos;
        TareaMonteCarlo[] hilos = new TareaMonteCarlo[numeroHilos];

        for(int i = 0; i < numeroHilos; i++){
            if(i == numeroHilos - 1){
                hilos[i] = new TareaMonteCarlo(numDardosPorHilo + numDardosSobrantes, centroDiana);
            }else{
                hilos[i] = new TareaMonteCarlo(numDardosPorHilo, centroDiana);
            }
            hilos[i].start();
        }
        int totalDardosEnElCirculo = 0;
        for(int i = 0; i < hilos.length; i++){
            try {
                hilos[i].join();
                totalDardosEnElCirculo += hilos[i].getPuntosEnElCirculo();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }

        double aproximacionPi = 4.0 * totalDardosEnElCirculo / numeroTotalDardos;
        System.out.println("Aproximación de Pi: " + aproximacionPi);



    }
}
