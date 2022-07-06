package org.letscode.shoppingcart.services;

import org.letscode.shoppingcart.domain.Cliente;
import org.letscode.shoppingcart.domain.ItemCarrinho;

import java.util.List;

public class CalculaTotalCompra {

    public static Double calculaTotalCompra(Cliente cliente) {
        List<ItemCarrinho> carrinho = CarrinhoDoCliente.carrinhoDoCliente(cliente);

        Double total = .0;

        for (ItemCarrinho item: carrinho) {
            Double totalDoItem = .0;

            if (item.getAmount() >= 3) {
                Double preco = item.getProduto().getPreco();
                Double multiplicador = item.getProduto().getDesconto();
                totalDoItem = preco * (1 - multiplicador);
            } else {
                totalDoItem = item.getProduto().getPreco();
            }

            total += totalDoItem;
        }

        return total;
    }
}
