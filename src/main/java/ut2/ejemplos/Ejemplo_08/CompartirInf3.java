package ut2.ejemplos.Ejemplo_08;

public class CompartirInf3 {
    public static void main(String[] args) {
        Contador3 cont = new Contador3(0);
        HiloA3 hiloA3 = new HiloA3("HILOA2", cont);
        HiloB3 hiloB3 = new HiloB3("HILOB2", cont);
        hiloA3.start();
        hiloB3.start();
    }
}
