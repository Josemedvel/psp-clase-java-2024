package ut2.ejemplos.Ejemplo_07;

public class HiloA2 extends Thread{
    private Contador2 contador;

    public HiloA2(String n, Contador2 cont){
        setName(n);
        contador = cont;
    }

    @Override
    public void run(){
       synchronized (contador){
           for (int i = 0; i < 300; i++){
               contador.incrementa();
           }
           System.out.println(getName() + " contador vale " + contador.getValor());
       }
   }
}
