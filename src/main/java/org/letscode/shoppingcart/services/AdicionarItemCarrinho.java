package org.letscode.shoppingcart.services;

import org.letscode.shoppingcart.domain.Cliente;
import org.letscode.shoppingcart.domain.ItemCarrinho;
import org.letscode.shoppingcart.domain.Produto;
import org.letscode.shoppingcart.repositories.ItemCarrinhoRepository;

import java.util.List;

public class AdicionarItemCarrinho {

    public static void add(Cliente clt, Produto pdt, int qtd) {
        List<ItemCarrinho> carrinho = CarrinhoDoCliente.carrinhoDoCliente(clt);

        boolean alreadyExists = false;
        for (ItemCarrinho item: carrinho) {
            if (item.getProduto().equals(pdt)) {
                item.setAmount(item.getAmount() + qtd);
                alreadyExists = true;
            }
        }

        if (!alreadyExists) {
            novo(clt, pdt, qtd);
        }

    }

    public static void novo(Cliente clt, Produto pdt, int qtd) {
        ItemCarrinhoRepository db = ItemCarrinhoRepository.getInstance();

        ItemCarrinho item = new ItemCarrinho(clt, pdt, qtd);

        db.save(item);
    }
}
