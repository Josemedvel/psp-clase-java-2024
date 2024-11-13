package ut2.ejemplos.Ejemplo_06;

public class HiloA extends Thread{
    private Contador contador;

    public HiloA(String n, Contador c){
        setName(n);
        contador = c;
    }
    @Override
    public void run(){
        for(int i = 0; i < 300; i++){
            contador.incrementa();
        }
        System.out.println(getName() + " contador vale " + contador.getValor());
    }
}
