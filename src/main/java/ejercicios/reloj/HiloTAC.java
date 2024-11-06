package ejercicios.reloj;

public class HiloTAC extends Thread{
    private String cadena = "\tTAC\n";

    @Override
    public void run(){
        while(true){
            System.out.println(cadena);
            try{
                sleep(2000);
            }catch(InterruptedException ex){
                ex.printStackTrace();
            }
        }
    }
}
