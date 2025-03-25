package ut2.ejercicios.ordinaria;

public class Abuela extends Thread{
    private long tiempoEnUnaGalleta = 100;
    private Mesa mesa;
    public Abuela(Mesa mesa){
        this.mesa = mesa;
    }
    @Override
    public void run(){
        while(true){
            try{
                sleep(this.tiempoEnUnaGalleta); // lo que tarda
                mesa.dejarGalleta(); // intenta adquirir el semáforo, si no puede se bloquea
                System.out.println("Se ha dejado una galleta en la mesa, hay un total de "+mesa.getGalletasQuedan());
            }catch(InterruptedException ex){
                ex.printStackTrace();
            }
        }
    }
}
