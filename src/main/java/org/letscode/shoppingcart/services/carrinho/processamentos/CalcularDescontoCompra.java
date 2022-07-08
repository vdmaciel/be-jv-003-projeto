package org.letscode.shoppingcart.services.carrinho.processamentos;

import org.letscode.shoppingcart.domain.ItemCarrinho;
import org.letscode.shoppingcart.domain.Produto;

import java.math.BigDecimal;
import java.util.List;

public class CalcularDescontoCompra implements ProcessarCarrinho {
    public void processar(List<ItemCarrinho> carrinho){
        BigDecimal valorTotalComDesconto = BigDecimal.valueOf(0);

        for (ItemCarrinho item: carrinho) {
            if(item.getProduto().getCategoria().equals(Produto.Categoria.LIMPEZA)){

                item.getProduto().setDesconto((item.valorTotal().multiply(BigDecimal.valueOf(4))).divide(BigDecimal.valueOf(100)));
                valorTotalComDesconto = item.valorTotal().subtract(item.getProduto().getDesconto());

            }
            if(item.getProduto().getCategoria().equals(Produto.Categoria.VESTUARIO)){

                item.getProduto().setDesconto((item.valorTotal().multiply(BigDecimal.valueOf(8))).divide(BigDecimal.valueOf(100)));
                valorTotalComDesconto = item.valorTotal().subtract(item.getProduto().getDesconto());
            }
        }

        System.out.println("Valor total com desconto: " + valorTotalComDesconto.toString());

    }
}