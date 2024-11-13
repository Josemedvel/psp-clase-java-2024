package ut2.ejercicios.calculoPi;

public class TareaMonteCarlo extends Thread{
    private int lanzamientos;
    private int puntosEnElCirculo = 0;
    private Punto centroDiana;

    public TareaMonteCarlo(int lanzamientos, Punto centro){
        this.lanzamientos = lanzamientos;
        this.centroDiana = centro;
    }

    @Override
    public void run(){
        for(int i = 0; i < lanzamientos; i++){
            Punto dardo = new Punto();
            //System.out.println(dardo);
            //System.out.println(dardo.distanciaHasta(centroDiana));
            if(dardo.distanciaHasta(centroDiana) <= 1){
                puntosEnElCirculo++;
            }
        }
    }
    public int getPuntosEnElCirculo(){
        return this.puntosEnElCirculo;
    }
}
