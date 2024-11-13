package ut2.ejemplos.Ejemplo_12;

public class Exec {
    public static void main(String[] args) {
        ContadorCompartido cc = new ContadorCompartido();
        new IncrementadorLento("A", cc).start();
        new IncrementadorLento("B", cc).start();
        new IncrementadorLento("C", cc).start();
    }
}
