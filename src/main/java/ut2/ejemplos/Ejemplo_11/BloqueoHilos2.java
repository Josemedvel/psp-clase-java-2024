package ut2.ejemplos.Ejemplo_11;

public class BloqueoHilos2 {
    public static void main(String[] args) {
        ObjetoCompartido2 comp = new ObjetoCompartido2();
        HiloCadena2 a = new HiloCadena2(comp, "TIC\n");
        HiloCadena2 b = new HiloCadena2(comp, "\tTAC\n");
        a.start();
        b.start();

    }

}
