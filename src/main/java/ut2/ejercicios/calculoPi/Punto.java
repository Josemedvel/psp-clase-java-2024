package ut2.ejercicios.calculoPi;
import java.util.Random;

public class Punto{
    static Random rng = new Random();
    double posX;
    double posY;

    public Punto(){
        this.posY = rng.nextDouble(-2, 0);
        this.posX = rng.nextDouble(0,2);
    }

    public Punto(double posX, double posY){
        this.posX = posX;
        this.posY = posY;
    }
    public double distanciaHasta(Punto b){
        return Math.pow((this.posX-b.posX)*(this.posX-b.posX)+(this.posY-b.posY)*(this.posY-b.posY) ,0.5);
    }

    @Override
    public String toString() {
        return "POS X: " + posX + ", POS Y: " + posY;
    }
}
