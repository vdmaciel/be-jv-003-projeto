package org.letscode.shoppingcart.services.carrinho.processamentos;

import org.letscode.shoppingcart.domain.ItemCarrinho;
import org.letscode.shoppingcart.domain.Produto;

import java.math.BigDecimal;
import java.util.List;

public class CalcularFreteCompra implements ProcessarCarrinho {

    public void processar(List<ItemCarrinho> carrinho) {
        double pesoTotal = 0.0;

        for (ItemCarrinho item: carrinho) {
            if(!(item.getProduto().getCategoria().equals(Produto.Categoria.DIGITAL) || item.getProduto().getCategoria().equals(Produto.Categoria.MEDICAMENTO))){
                pesoTotal += item.getProduto().getPeso();
            }
        }

        BigDecimal freteTotal;

        if (pesoTotal <= 1.0){
            freteTotal = new BigDecimal(5 + pesoTotal * 0.3);
        } else if (pesoTotal <= 5) {
            freteTotal = new BigDecimal(15 + pesoTotal * 0.4);
        }else{
            freteTotal = new BigDecimal(30 + pesoTotal * 0.5);
        }

        System.out.println("Frete total: " + freteTotal.toString());
    }
}
