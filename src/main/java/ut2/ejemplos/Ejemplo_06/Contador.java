package ut2.ejemplos.Ejemplo_06;

public class Contador {
    private int c = 0;

    public Contador(int c) {
        this.c = c;
    }

    public void incrementa() {
        int a = c;
        try {
            Thread.sleep(3);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        c = a + 1;
    }

    public void decrementa() {
        int a = c;
        try {
            Thread.sleep(3);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        c = a - 1;
    }

    public int getValor() {
        return c;
    }
}
