package ut2.ejemplos.Ejemplo_07;

public class Contador2 {
    private int contador;

    public Contador2(int c){
        contador = c;
    }
    public void incrementa(){
        contador = contador + 1;
    }
    public void decrementa(){
        contador = contador - 1;
    }
    public int getValor(){
        return contador;
    }
}
