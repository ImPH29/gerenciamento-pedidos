package com.pedro.pedidos;

import java.math.BigDecimal;

public class ItemPedido {

    private final Produto produto;
    private final int quantidade;

    public ItemPedido(Produto produto, int quantidade){
        if (produto == null){
            throw new IllegalArgumentException(
                    "O produto não pode ser nulo."
            );
        }
        if (quantidade <= 0){
            throw new IllegalArgumentException(
                    "A quantidade deve ser maior que zero."
            );
        }

        this.produto = produto;
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public BigDecimal calcularSubtotal(){
        return produto.getPreco()
                .multiply(BigDecimal.valueOf(quantidade));
    }
}
