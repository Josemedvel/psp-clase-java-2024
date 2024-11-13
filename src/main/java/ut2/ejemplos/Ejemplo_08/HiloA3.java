package ut2.ejemplos.Ejemplo_08;

public class HiloA3 extends Thread {
    private Contador3 contador;

    public HiloA3(String n, Contador3 cont) {
        setName(n);
        contador = cont;
    }

    @Override
    public void run() {
        for (int i = 0; i < 300; i++) {
            contador.incrementa();
        }
        System.out.println(getName() + " contador vale " + contador.getValor());
    }
}
