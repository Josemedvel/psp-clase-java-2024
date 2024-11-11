package ut2.ejercicios.aproximacion_pi;
import java.util.Random;

public class Punto {
    public double x;
    public double y;
    static Random rng = new Random();

    public Punto(double x, double y){
        this.x = x;
        this.y = y;
    }

    public Punto(){
        this.x = rng.nextDouble(-1,1);
        this.y = rng.nextDouble(-1,1);
    }

    public double distanciaHasta(Punto b){
        return Math.pow(Math.pow(this.x-b.x, 2) + Math.pow(this.y-b.y, 2), 0.5);
    }

}
