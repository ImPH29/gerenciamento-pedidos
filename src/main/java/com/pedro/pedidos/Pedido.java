package com.pedro.pedidos;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Pedido {

    private final List<ItemPedido> itens = new ArrayList<>();

    public void adicionarItem(ItemPedido item) {
        if(status != StatusPedido.PENDENTE){
            throw new IllegalStateException(
                    "Só é possível adicionar itens a pedidos pendentes."
            );
        }

        if (item == null) {

            throw new IllegalArgumentException(
                    "O item do pedido não pode ser nulo."
            );
        }

        itens.add(item);

    }

    public BigDecimal calcularTotal() {
        BigDecimal total = BigDecimal.ZERO;

        for (ItemPedido item : itens) {
            total = total.add(item.calcularSubtotal());
        }
        return total;
    }

    private StatusPedido status = StatusPedido.PENDENTE;

    public StatusPedido getStatus(){
        return status;
    }

    public void cancelar(){

        if(status != StatusPedido.PENDENTE){
            throw new IllegalStateException(
                    "Apenas pedidos pendentes podem ser cancelados."
            );
        }

        status = StatusPedido.CANCELADO;

    }

    public void pagar() {
        if (status != StatusPedido.PENDENTE) {
            throw new IllegalStateException(
                    "Apenas pedidos pendentes podem ser pagos."
            );
        }

        status = StatusPedido.PAGO;
    }

}


