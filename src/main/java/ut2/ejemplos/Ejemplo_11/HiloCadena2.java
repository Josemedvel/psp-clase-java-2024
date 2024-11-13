package ut2.ejemplos.Ejemplo_11;

public class HiloCadena2 extends Thread {
    private final String cadena;
    private final ObjetoCompartido2 c;
    private final int id; // Identificador del turno para el hilo

    public HiloCadena2(ObjetoCompartido2 comp, String cadena, int id) {
        this.cadena = cadena;
        this.c = comp;
        this.id = id;
    }

    @Override
    public void run() {
        synchronized (c) {
            for (int i = 0; i < 10; i++) {
                while (c.getTurno() != id) { // Espera hasta que sea su turno
                    //esta implementación funciona siempre, porque SOLO ESPERAMOS CUANDO NO ES NUESTRO TURNO, al estilo de usar una Condition
                    //Como todos los hilos están esperando excepto uno, no hay problema para que los métodos de ObjetoCompartido2 no sean synchronized,
                    // aunque se podrían poner o sería bastante recomendable
                    try {
                        c.wait(); // Espera ser notificado
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }

                c.pintaCadena(cadena); // Imprime su cadena
                c.setTurno((id + 1) % 3); // Cambia el turno al siguiente hilo
                c.notifyAll(); // Notifica a todos los hilos para que el siguiente despierte
            }
        }
        System.out.println("\n" + cadena + " finalizado");
    }
}
