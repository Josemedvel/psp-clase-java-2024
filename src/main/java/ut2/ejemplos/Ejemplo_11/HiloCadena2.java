package ut2.ejemplos.Ejemplo_11;

public class HiloCadena2 extends Thread{
    private String cadena;
    private ObjetoCompartido2 c;

    public HiloCadena2(ObjetoCompartido2 comp, String cadena){
        this.cadena = cadena;
        this.c = comp;
    }
    @Override
    public void run(){
        // aquí es importante hacer el bloque de sincronización sobre el objeto compartido
        // si no no funciona
        synchronized(c) {
            for (int i = 0; i < 10; i++) {
                c.pintaCadena(this.cadena);
                c.notify();
                try {
                    c.wait();
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            } // for
            c.notifyAll(); // despertar todos los wait sobre el objeto
        }
        System.out.println("\n" + this.cadena + " finalizado");
    }

}
