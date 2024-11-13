package ut2.ejemplos.Ejemplo_11;

public class ObjetoCompartido2 {
    private int turno = 0; // Controla cuál hilo tiene el turno para imprimir

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }

    public void pintaCadena(String cadena) {
        System.out.print(cadena);
    }
}
