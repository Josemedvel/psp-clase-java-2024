package ut2.ejercicios.ordinaria;

public class Nieto extends Thread{
    private long tiempoComerGalleta = 1500;
    private long tiempoEspera = 2000;
    private int numGalletasComidas = 0;
    private Mesa mesa;
    public Nieto(String nombre, Mesa mesa){
        super(nombre);
        this.mesa = mesa;
    }
    @Override
    public void run(){
        while(true){
            try {
                if (numGalletasComidas >= 10) { // se aplica espera de comida
                    sleep(tiempoEspera);
                }
                mesa.cogerGalleta();
                System.out.println(this.getName() + " ha cogido una galleta, quedan: " + mesa.getGalletasQuedan());
                sleep(tiempoComerGalleta);
                this.numGalletasComidas++;
                System.out.println(this.getName() + " ha terminado su galleta, lleva: " + numGalletasComidas);
                System.out.println();
            }catch(InterruptedException ex){
                ex.printStackTrace();
            }
        }
    }
}
