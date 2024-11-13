package ut2.ejemplos.Ejemplo_08;

public class Contador3 {
    private int contador;

    public Contador3(int c){
        contador = c;
    }
    public synchronized void incrementa(){
        contador = contador + 1;
    }
    public synchronized void decrementa(){
        contador = contador - 1;
    }
    public synchronized int getValor(){
        return contador;
    }
}
