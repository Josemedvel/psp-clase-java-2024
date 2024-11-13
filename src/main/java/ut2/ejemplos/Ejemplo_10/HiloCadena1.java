package ut2.ejemplos.Ejemplo_10;

import java.util.logging.Level;
import java.util.logging.Logger;

//Si cambiamos el bloque synchronized podemos alterar el orden final de ejecución

public class HiloCadena1 extends Thread{
    private ObjetoCompartido objeto;
    String cadena;
    public HiloCadena1(ObjetoCompartido comp, String cadena){
        this.objeto = comp;
        this.cadena = cadena;
    }
    @Override
    public void run(){
        /*for(int i = 0; i < 10; i++){
            try{
                synchronized (objeto){
                    objeto.pintaCadenas(cadena);
                }
                sleep(30);
            }catch(InterruptedException ex){
                Logger.getLogger(HiloCadena1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }*/
        synchronized(objeto){
            try {
                for (int i = 0; i < 10; i++) {
                    objeto.pintaCadenas(cadena);
                    sleep(30);
                }
            }catch(InterruptedException ex){
                Logger.getLogger(HiloCadena1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
