package com.pedro.pedidos;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class PedidoTest {

    @Test
    void deveCalcularTotalDeVariosItens() {
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

        assertEquals(
                new BigDecimal("7150.00"),
                pedido.calcularTotal()
        );
    }

    @Test
    void deveRetornarZeroQuandoPedidoEstiverVazio() {
        Pedido pedido = new Pedido();
        assertEquals(
                BigDecimal.ZERO,
                pedido.calcularTotal()
        );
    }

    @Test
    void naoDeveAceitarItemNulo() {
        Pedido pedido = new Pedido();

        assertThrows(
                IllegalArgumentException.class,
                () -> pedido.adicionarItem(null)
        );
    }
    @Test
    void naoDeveAdicionarItemAUmPedidoCancelado() {
        Pedido pedido = new Pedido();
        pedido.cancelar();

        Produto produto = new Produto(
                1L,
                "Notebook",
                new BigDecimal("3500.00")
        );

        ItemPedido item = new ItemPedido(produto, 1);

        assertThrows(
                IllegalStateException.class,
                () -> pedido.adicionarItem(item)
        );
    }


    @Test
    void devePermitirPagarPedidoPendente() {
        Pedido pedido = new Pedido();

        pedido.pagar();

        assertEquals(StatusPedido.PAGO, pedido.getStatus());
    }

    @Test
    void naoDevePermitirPagarPedidoCancelado() {
        Pedido pedido = new Pedido();
        pedido.cancelar();

        assertThrows(
                IllegalStateException.class,
                () -> pedido.pagar()
        );

        assertEquals(StatusPedido.CANCELADO, pedido.getStatus());
    }

    @Test
    void naoDevePermitirCancelarPedidoPago() {
        Pedido pedido = new Pedido();
        pedido.pagar();

        assertThrows(
                IllegalStateException.class,
                () -> pedido.cancelar()
        );

        assertEquals(StatusPedido.PAGO, pedido.getStatus());
    }

    @Test
    void naoDeveAdicionarItemAUmPedidoPago() {
        Pedido pedido = new Pedido();

        pedido.pagar();

        Produto produto = new Produto(
                1L,
                "Notebook",
                new BigDecimal("3500.00")
        );

        ItemPedido item = new ItemPedido(produto, 1);

        assertThrows(
                IllegalStateException.class,
                () -> pedido.adicionarItem(item)
        );
    }


}
