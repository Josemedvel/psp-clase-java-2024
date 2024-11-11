package ut2.ejercicios.aproximacion_pi;

public class Main {
    public static void main(String[] args) {
        Punto centroDiana = new Punto(0,0);
        int numDardos = 100000;
        int numDardosEnElCirculo = 0;
        Dardo [] dardos = new Dardo[numDardos];

        for(int i = 0; i < dardos.length; i++){
            dardos[i] = new Dardo(centroDiana);
            dardos[i].start();
        }

        for(int i = 0; i < dardos.length; i++){
            try{
                dardos[i].join();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        for(int i = 0; i < dardos.length; i++){
            if(dardos[i].getDentro()){
                numDardosEnElCirculo++;
            }
        }
        double aproximacion = 4.0 * ((double)numDardosEnElCirculo / (double)numDardos);
        System.out.println(aproximacion);
    }
}
