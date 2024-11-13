package ut2.ejemplos.Ejemplo_09;

public class SacarDinero extends Thread{
    private Cuenta c;

    public SacarDinero(String n, Cuenta c){
        super(n);
        this.c = c;
    }

    @Override
    public void run(){
        for(int i = 1; i < 5; i++){
            c.retirarDinero(30, getName());
        }
    }
}
