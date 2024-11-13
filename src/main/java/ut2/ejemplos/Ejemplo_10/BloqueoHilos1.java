package ut2.ejemplos.Ejemplo_10;

public class BloqueoHilos1 {
    public static void main(String[] args) {
        ObjetoCompartido comp = new ObjetoCompartido();
        HiloCadena1 a = new HiloCadena1(comp, " Hola ");
        HiloCadena1 b = new HiloCadena1(comp, " Adios ");
        a.start();
        b.start();
    }
}
