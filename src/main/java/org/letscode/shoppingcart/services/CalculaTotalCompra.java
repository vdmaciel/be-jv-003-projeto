package org.letscode.shoppingcart.services;

import org.letscode.shoppingcart.domain.Cliente;
import org.letscode.shoppingcart.domain.ItemCarrinho;
import org.letscode.shoppingcart.domain.Produto;
import org.letscode.shoppingcart.repositories.ItemCarrinhoRepository;

import java.util.ArrayList;
import java.util.List;

public class CalculaTotalCompra {

    public Double calculaTotalCompra(Cliente cliente) {
        ItemCarrinhoRepository db = ItemCarrinhoRepository.getInstance();

        List<ItemCarrinho> all = db.getAll();
        List<ItemCarrinho> carrinho = new ArrayList<ItemCarrinho>();

        for (ItemCarrinho item: all) {
            if(item.getCliente().equals(cliente)) carrinho.add(item);
        }

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
