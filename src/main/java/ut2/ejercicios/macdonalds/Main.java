package ut2.ejercicios.macdonalds;

public class Main {
    public static void main(String[] args) {
        RecursoCocina plancha = new RecursoCocina("plancha", 2);
        RecursoCocina mezcladora = new RecursoCocina("mezcladora", 1);
        RecursoCocina mesa = new RecursoCocina("mesa", 3);
        RecursoCocina freidora = new RecursoCocina("freidora", 3);

        //cosas del pedido 1
        Comida patatasFritas_1 = new Comida("patatas fritas", 2, freidora);
        Comida hamburguesaSimple_1 = new Comida("hamburguesa Simple", 2, plancha);
        Comida hamburguesaPremium_1 = new Comida("hamburguesa Premium", 4, plancha);

        //cosas del pedido 2
        Comida wrapPollo_2 = new Comida("wrap pollo", 3, mesa);
        Comida wrapPolloPicante_2 = new Comida("wrap pollo picante", 3, mesa);
        Comida patatasFritas_2 = new Comida("patatas fritas", 2, freidora);
        Comida hamburguesaPremium_2 = new Comida("hamburguesa Premium", 4, plancha);

        //cosas del pedido 3
        Comida ensalada_3 = new Comida("ensalada", 1, mezcladora);

        //pedidos
        //Pedido Jose
        Pedido pedidoJose = new Pedido(1, "Jose");
        patatasFritas_1.setPedido(pedidoJose);
        hamburguesaSimple_1.setPedido(pedidoJose);
        hamburguesaPremium_1.setPedido(pedidoJose);
        pedidoJose.setPedidoComida(new Comida[]{patatasFritas_1, hamburguesaSimple_1, hamburguesaPremium_1});
        pedidoJose.prepararPedido();

        //Pedido Ana
        Pedido pedidoAna = new Pedido(2, "Ana");
        wrapPollo_2.setPedido(pedidoAna);
        wrapPolloPicante_2.setPedido(pedidoAna);
        patatasFritas_2.setPedido(pedidoAna);
        hamburguesaPremium_2.setPedido(pedidoAna);
        pedidoAna.setPedidoComida(new Comida[]{patatasFritas_2, wrapPolloPicante_2, hamburguesaPremium_2, wrapPollo_2});
        pedidoAna.prepararPedido();

        //Pedido Lorenzo
        Pedido pedidoLorenzo = new Pedido(3, "Lorenzo");
        ensalada_3.setPedido(pedidoLorenzo);
        pedidoLorenzo.setPedidoComida(new Comida[]{ensalada_3});
        pedidoLorenzo.prepararPedido();
    }
}
