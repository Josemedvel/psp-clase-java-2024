package ut2.ejemplos.Ejemplo_11;

public class BloqueoHilos2 {
    public static void main(String[] args) {
        ObjetoCompartido2 comp = new ObjetoCompartido2();
        HiloCadena2 a = new HiloCadena2(comp, "TIC\n", 0);
        HiloCadena2 b = new HiloCadena2(comp, "\tTAC\n", 1);
        HiloCadena2 c = new HiloCadena2(comp, "\t\tTEC\n", 2);
        a.start();
        b.start();
        c.start();
    }

}
