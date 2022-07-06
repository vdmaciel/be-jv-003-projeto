package org.letscode.shoppingcart.services;

import org.letscode.shoppingcart.domain.Cliente;
import org.letscode.shoppingcart.domain.ItemCarrinho;
import org.letscode.shoppingcart.repositories.ItemCarrinhoRepository;

import java.util.List;
import java.util.stream.Collectors;

public class CarrinhoDoCliente {

    public static List<ItemCarrinho> carrinhoDoCliente(Cliente cliente) {
        ItemCarrinhoRepository db = ItemCarrinhoRepository.getInstance();

        List<ItemCarrinho> all = db.getAll();
        List<ItemCarrinho> carrinho = all.stream().parallel().filter(item -> item.getCliente().equals(cliente)).collect(Collectors.toList());

        return carrinho;
    }
}
