package ut2.ejemplos.Ejemplo_06;

public class CompartirInf1 {
    // este programa
    public static void main(String[] args) {
        Contador cont = new Contador(100);
        HiloA a = new HiloA("HiloA", cont);
        HiloB b = new HiloB("HiloB", cont);
        a.start();
        b.start();
    }
}
