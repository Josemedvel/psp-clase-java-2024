package ut2.ejemplos.Ejemplo_05;

public class HijoJoin extends Thread{
    private final int n;
    public HijoJoin(String nombre, int n){
        super(nombre);
        this.n = n;
    }

    @Override
    public void run() {
        for(int i = 0; i <= n; i++){
            System.out.println(getName()+ ": " + i);
            try{
                sleep(1000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println("Fin del bucle " + getName());
    }
}
