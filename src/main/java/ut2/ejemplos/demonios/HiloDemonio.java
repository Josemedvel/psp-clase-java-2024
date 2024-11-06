package ut2.ejemplos.demonios;

public class HiloDemonio extends Thread{
    private int contador = 0;
    public HiloDemonio(String nombre){
        super(nombre);
    }
    @Override
    public void run(){
        try{
            while(true){
                System.out.println(getName() + ": " + (contador++));
                sleep(500);
            }
        }catch (InterruptedException ex){
            ex.printStackTrace();
        }

    }
}
