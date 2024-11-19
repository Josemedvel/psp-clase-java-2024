package ut2.ejercicios.macdonalds;

public class Comida extends Thread{
    private final String nombre;
    private final int tiempoPreparacion;
    private Pedido pedido;
    private final RecursoCocina recurso;
    public Comida(String nombre, int tiempoPreparacion, RecursoCocina recurso) {
        this.nombre = nombre;
        this.tiempoPreparacion = tiempoPreparacion;
        this.recurso = recurso;
    }
    public int getTiempoPreparacion() {
        return tiempoPreparacion * 1000;
    }
    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
    public String getNombre() {
        return nombre;
    }
    public Pedido getPedido() {
        return pedido;
    }
    @Override
    public void run(){
        recurso.usarRecurso(this);
    }
}
