package ut2.ejemplos.Ejemplo_07;

public class CompartirInf2 {
    public static void main(String[] args) {
        Contador2 cont = new Contador2(0);
        HiloA2 hiloA2 = new HiloA2("HILOA2", cont);
        HiloB2 hiloB2 = new HiloB2("HILOB2", cont);
        hiloA2.start();
        hiloB2.start();
    }
}
