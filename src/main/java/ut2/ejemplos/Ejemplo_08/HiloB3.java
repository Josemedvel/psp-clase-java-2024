package ut2.ejemplos.Ejemplo_08;

public class HiloB3 extends Thread{
    private Contador3 contador;

    public HiloB3(String n, Contador3 c){
        setName(n);
        contador = c;
    }

    @Override
    public void run(){
            for (int i = 0; i < 300; i++) {
                contador.decrementa();
            }
            System.out.println(getName() + " contador vale " + contador.getValor());
    }
}
