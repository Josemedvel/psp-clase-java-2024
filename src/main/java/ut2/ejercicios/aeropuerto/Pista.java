package ut2.ejercicios.aeropuerto;

import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
public class Pista {
    private ReentrantLock lock = new ReentrantLock();
    private Condition ocupada = lock.newCondition();
    private final String nombre;
    private final int capacidad;
    private final ArrayList<Permiso> permisos;
    private int usadaPorActualmente = 0;
    public Pista(String nombre, int capacidad, ArrayList<Permiso> permisos) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.permisos = permisos;
    }
    public String getNombre() {
        return nombre;
    }
    synchronized public int getCapacidad() {
        return capacidad;
    }
    synchronized public boolean disponible() {
        return capacidad > usadaPorActualmente;
    }
    public ArrayList<Permiso> getPermisos() {
        return permisos;
    }

    public void ocuparPista(String avion){
        lock.lock();
        try{
            while(usadaPorActualmente >= capacidad){
                ocupada.await();
            }
            usadaPorActualmente++;
            System.out.println("El avión "+ avion + " ha ocupado la pista " + nombre);
        }catch(InterruptedException e){
            e.printStackTrace();
        }finally{
            lock.unlock();
        }
    }
    public void liberarPista(String avion){
        lock.lock();
        usadaPorActualmente--;
        System.out.println("El avión "+ avion + " ha abandonado la pista " + nombre);
        ocupada.signal();
        lock.unlock();
    }
}
