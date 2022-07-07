package org.letscode.shoppingcart.services.carrinho.processamentos;

import org.letscode.shoppingcart.domain.ItemCarrinho;

import java.math.BigDecimal;
import java.util.List;

public class CalculaTotalCompra implements ProcessarCarrinho{

    public void processar(List<ItemCarrinho> carrinho) {
        BigDecimal total = new BigDecimal(0.0);

        for (ItemCarrinho item: carrinho) {
            total = total.add(item.valorTotal());
        }

        System.out.println("Valor total: "+ total.toString());
    }
}
