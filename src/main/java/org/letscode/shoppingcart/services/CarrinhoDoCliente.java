package org.letscode.shoppingcart.services;

import org.letscode.shoppingcart.domain.Cliente;
import org.letscode.shoppingcart.domain.ItemCarrinho;
import org.letscode.shoppingcart.repositories.ItemCarrinhoRepository;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDoCliente {

    public static List<ItemCarrinho> carrinhoDoCliente(Cliente cliente) {
        ItemCarrinhoRepository db = ItemCarrinhoRepository.getInstance();

        List<ItemCarrinho> all = db.getAll();
        List<ItemCarrinho> carrinho = new ArrayList<ItemCarrinho>();

        for (ItemCarrinho item: all) {
            if(item.getCliente().equals(cliente)) carrinho.add(item);
        }

        return  carrinho;
    }
}
