package org.letscode.shoppingcart.services;

import org.letscode.shoppingcart.domain.Cliente;
import org.letscode.shoppingcart.domain.ItemCarrinho;
import org.letscode.shoppingcart.domain.Produto;
import org.letscode.shoppingcart.repositories.ItemCarrinhoRepository;

public class NovoItemCarrinho {

    public static void novoItemCarrinho(Cliente clt, Produto pdt, int qtd) {
        ItemCarrinhoRepository db = ItemCarrinhoRepository.getInstance();

        ItemCarrinho item = new ItemCarrinho(clt, pdt, qtd);

        db.save(item);
    }
}
