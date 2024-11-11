package ut2.ejercicios.aproximacion_pi;

public class Dardo extends Thread{
    private boolean dentro = false;
    private Punto centro;

    public Dardo(Punto centro){
        this.centro = centro;
    }

    public boolean getDentro(){
        return this.dentro;
    }

    @Override
    public void run(){
        Punto nuevoDardo = new Punto();
        double distancia = nuevoDardo.distanciaHasta(centro);
        dentro = distancia <= 1;
    }
}
