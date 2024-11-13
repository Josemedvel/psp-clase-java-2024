package ut2.ejercicios.planificador;

import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TareaHilo extends Thread {
    static final Lock bloqueo = new ReentrantLock();
    static final Condition turnoCondicion = bloqueo.newCondition();
    static int turnoActual = 1;
    static ArrayList<Integer> hiloIds = new ArrayList<>(); // Lista de IDs de hilos activos
    private final int idHilo;
    private int pasos;

    public TareaHilo(String nombre, int pasos, int idHilo) {
        super(nombre);
        this.pasos = pasos;
        this.idHilo = idHilo;
        hiloIds.add(this.idHilo); // Agregar el ID de hilo a la lista de hilos activos
    }

    @Override
    public void run() {
        while (pasos >= 0) {
            bloqueo.lock();
            try {
                if (pasos == 0) {
                    // Mensaje de finalización y eliminación del ID del hilo terminado
                    System.out.println("Ejecución terminada de la tarea " + getName());
                    hiloIds.remove(Integer.valueOf(idHilo));

                    // Cambiar turno al siguiente hilo en la lista (si quedan hilos)
                    if (!hiloIds.isEmpty()) {
                        turnoActual = hiloIds.get(turnoActual % hiloIds.size());
                    }
                    pasos--;
                    // Despertamos a otros hilos para que verifiquen si es su turno
                    turnoCondicion.signalAll();
                    //break; // Salimos del bucle ya que el hilo ha terminado su ejecución
                } else {
                    // Espera hasta que sea el turno del hilo actual
                    while (turnoActual != idHilo) {
                        turnoCondicion.await();
                    }

                    // Ejecución de un paso
                    System.out.println(getName() + ": ejecutando, quedan " + pasos + " pasos");
                    Thread.sleep(500);
                    pasos--;

                    // Cambia el turno al siguiente hilo
                    if (!hiloIds.isEmpty()) {
                        turnoActual = hiloIds.get((hiloIds.indexOf(idHilo) + 1) % hiloIds.size());
                    }
                    turnoCondicion.signalAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                bloqueo.unlock(); // Aseguramos liberar el bloqueo
            }
        }
    }
}
