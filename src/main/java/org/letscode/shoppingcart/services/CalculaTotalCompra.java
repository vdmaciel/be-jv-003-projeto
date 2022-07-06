package org.letscode.shoppingcart.services;

import org.letscode.shoppingcart.domain.Cliente;
import org.letscode.shoppingcart.domain.ItemCarrinho;

import java.math.BigDecimal;
import java.util.List;

public class CalculaTotalCompra {

    public static BigDecimal calculaTotalCompra(Cliente cliente) {
        List<ItemCarrinho> carrinho = CarrinhoDoCliente.carrinhoDoCliente(cliente);

        BigDecimal total = new BigDecimal(0.0);

        for (ItemCarrinho item: carrinho) {
            total = total.add(item.valorTotal());
        }

        return total;
    }
}
