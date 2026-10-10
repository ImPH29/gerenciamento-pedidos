package com.pedro.pedidos;

import java.math.BigDecimal;

public class Produto {

    private final Long id;
    private final String nome;
    private final BigDecimal preco;

    public Produto(Long id, String nome, BigDecimal preco) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("O ID deve ser positivo.");
        }

        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("O nome do produto não pode ser vazio.");

        }

        if (preco == null || preco.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("O preço deve ser maior que zero.");

        }

        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public BigDecimal getPreco() {
        return preco;
    }
}
