package com.pedro.pedidos;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class ItemPedidoTest {
    @Test
    void naoDeveAceitarQuantidadeZero() {
        Produto produto = new Produto(
                1L, "Notebook",
                new BigDecimal("3500.00")
        );

        assertThrows(IllegalArgumentException.class, () ->
                new ItemPedido(produto, 0)
        );
    }

    @Test
    void naoDeveAceitarProdutoNulo(){
        assertThrows(IllegalArgumentException.class, ()->
    new ItemPedido(null,2)
    );

    }

    @Test
    void DeveCalcularSubtotalCorretamente() {
        Produto produto = new Produto(
                1L,
                "Notebook",
                new BigDecimal("3500.00")
        );

        ItemPedido item = new ItemPedido(produto, 2);

        assertEquals(
                new BigDecimal("7000.00"),
                item.calcularSubtotal()
        );
    }
}
