package ut2.ejemplos.Ejemplo_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejemplo03_2 extends Thread{
    boolean stopHilo = false;
    public void pararHilo(){
        stopHilo = true;
    }
    @Override
    public void run() {
        while(!stopHilo){
            System.out.println("hola");
            try{
                Thread.sleep(1000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Ejemplo03_2 hilo = new Ejemplo03_2();
        hilo.start();
        boolean salir = false;
        try(BufferedReader lectorTeclado = new BufferedReader(new InputStreamReader(System.in, "UTF-8"))){
            while(!salir){
              String entrada = lectorTeclado.readLine();
              if(entrada.equalsIgnoreCase("fin")){
                salir = true;
                hilo.pararHilo();
              }
            }
        }catch(IOException e){
            e.printStackTrace();
        }

    }
}
