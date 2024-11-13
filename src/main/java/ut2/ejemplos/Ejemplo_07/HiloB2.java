package ut2.ejemplos.Ejemplo_07;

public class HiloB2 extends Thread{
    private Contador2 contador;

    public HiloB2(String n, Contador2 c){
        setName(n);
        contador = c;
    }

    @Override
    public void run(){
        synchronized(contador) {
            for (int i = 0; i < 300; i++) {
                contador.decrementa();
            }
            System.out.println(getName() + " contador vale " + contador.getValor());
        }
    }
}
