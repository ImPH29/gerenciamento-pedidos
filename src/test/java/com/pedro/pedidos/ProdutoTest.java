package com.pedro.pedidos;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

 class ProdutoTest {

     @Test
     void deveCriarProdutoComDadosValidos(){
         Produto produto = new Produto(
                 1L,
                 "Notebook",
                 new BigDecimal("3500.00")
         );

         assertEquals(1L, produto.getId());
         assertEquals("Notebook",produto.getNome());
         assertEquals(
                 0,
                 produto.getPreco().compareTo(new BigDecimal("3500.00"))
         );
     }

     @Test
     void naoDeveAceitarNomeVazio(){
         assertThrows(IllegalArgumentException.class, () ->
                 new Produto(1L, " ", new BigDecimal("3500.00"))
         );
     }

}
