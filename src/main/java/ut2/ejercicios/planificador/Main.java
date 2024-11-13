package ut2.ejercicios.planificador;

public class Main {
    public static void main(String[] args) {
        TareaHilo descarga = new TareaHilo("Descarga", 3,1);
        TareaHilo renderizado = new TareaHilo("Renderizado", 5, 2);
        TareaHilo computadoDatos = new TareaHilo("ComputadoDatos", 7, 3);
        descarga.start();
        renderizado.start();
        computadoDatos.start();
    }
}
