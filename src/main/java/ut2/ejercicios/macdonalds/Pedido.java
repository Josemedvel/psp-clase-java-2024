package ut2.ejercicios.macdonalds;

public class Pedido{
    private final int idPedido;
    private final String nombreCliente;
    private Comida[] pedidoComida;
    private int elementosPreparados = 0;
    public Pedido(int idPedido, String nombreCliente) {
        this.idPedido = idPedido;
        this.nombreCliente = nombreCliente;
    }
    public int getIdPedido() {
        return idPedido;
    }
    public void setPedidoComida(Comida[] pedidoComida) {
        this.pedidoComida = pedidoComida;
    }
    public String getNombreCliente() {
        return nombreCliente;
    }
    public Comida[] getPedidoComida() {
        return pedidoComida;
    }
    public String pedidoToString() {
        String[] nombresComida = new String[pedidoComida.length];
        for(int i = 0; i < pedidoComida.length; i++) {
            nombresComida[i] = pedidoComida[i].getNombre();
        }
        return "["+String.join(", ", nombresComida)+"]";
    }
    public void prepararPedido(){
        for(Comida comida : pedidoComida){
               comida.start(); // creamos un nuevo hilo y lo iniciamos
        }
    }
    public synchronized void notificarComidaLista(){
        elementosPreparados++;
        if(elementosPreparados == pedidoComida.length) {
            System.out.println("El pedido con id " + idPedido + " de " + nombreCliente + " ha sido preparado.");
        }
    }
}
