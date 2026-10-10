package com.pedro.pedidos;

import java.math.BigDecimal;


public class App {
    public static void main( String[] args )
    {

        Produto notebook = new Produto(
                1L,
                "Notebook",
                new BigDecimal("3500.00")
        );

        Produto teclado = new Produto(
                2L,
                "Teclado",
                new BigDecimal("150.00")
        );

        ItemPedido itemNotebook = new ItemPedido(notebook, 2);
        ItemPedido itemTeclado = new ItemPedido(teclado, 1);

        Pedido pedido = new Pedido();

        pedido.adicionarItem(itemNotebook);
        pedido.adicionarItem(itemTeclado);

        System.out.println("=== GERENCIAMENTO DE PEDIDOS ===");

        System.out.println("Status: " + pedido.getStatus());

        System.out.println("Subtotal dos notebooks: R$ "
                + itemNotebook.calcularSubtotal());

        System.out.println("Subtotal do teclado: R$ "
        + itemTeclado.calcularSubtotal());


        pedido.pagar();

        System.out.println("Status após pagamento: "
        + pedido.getStatus());

    }
}
