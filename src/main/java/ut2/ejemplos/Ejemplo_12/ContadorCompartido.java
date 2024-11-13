package ut2.ejemplos.Ejemplo_12;

public class ContadorCompartido {
    private int n = 0;
    public int getN(){
        return n;
    }
    public void setN(String id, int n){
        this.n = n;
        System.err.println(id + ": " + n);
    }
}
