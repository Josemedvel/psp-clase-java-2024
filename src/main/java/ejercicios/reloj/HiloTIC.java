package ejercicios.reloj;

public class HiloTIC extends Thread{
    private String cadena = "TIC\n";

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
