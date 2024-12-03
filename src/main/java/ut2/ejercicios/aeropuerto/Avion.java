package ut2.ejercicios.aeropuerto;
import java.util.Random;
public class Avion extends Thread{
    private final static Random rng = new Random();
    private final String nombre;
    private final Permiso permiso;
    private final int tiempoManiobra = rng.nextInt(2000, 6000);
    private final Pista[] pistasAeropuerto;
    static Reloj reloj;

    static {
        try {
            reloj = new Reloj(10);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Avion(String nombre, Permiso permiso, Pista[] pistasAeropuerto) {
        this.nombre = nombre;
        this.permiso = permiso;
        this.pistasAeropuerto = pistasAeropuerto;
    }
    public String getNombre() {
        return nombre;
    }
    public Permiso getPermiso() {
        return permiso;
    }
    public int getTiempoManiobra() {
        return tiempoManiobra;
    }
    synchronized public Pista getPistaDisponible(){
        for(int i = 0; i < pistasAeropuerto.length; i++){
            if(pistasAeropuerto[i].disponible()){ // es una pista que admite la acción que quiere realizar el avión
            //comprobar capacidad y bloquear en caso de haber
                return pistasAeropuerto[i];
            }
        }
        return pistasAeropuerto[rng.nextInt(0, pistasAeropuerto.length)];//si todas están ocupadas esperamos en una de forma aleatoria
    }
    @Override
    public void run() { // va a buscar la primera pista disponible con permisos para lo que quiere hacer el avión y
        try{
            Pista elegida = getPistaDisponible();
            elegida.ocuparPista(nombre);
            sleep(tiempoManiobra);
            elegida.liberarPista(nombre);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
