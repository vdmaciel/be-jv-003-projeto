package org.letscode.shoppingcart.services;

import org.letscode.shoppingcart.domain.Cliente;
import org.letscode.shoppingcart.domain.ItemCarrinho;
import org.letscode.shoppingcart.domain.Produto;

import java.util.List;

public class AdicionarItemCarrinho extends NovoItemCarrinho {

    public static void adicionarItemCarrinho(Cliente clt, Produto pdt, int qtd) {
        List<ItemCarrinho> carrinho = CarrinhoDoCliente.carrinhoDoCliente(clt);

        boolean alreadyExists = false;
        for (ItemCarrinho item: carrinho) {
            if (item.getProduto().equals(pdt)) {
                item.setAmount(item.getAmount() + qtd);
                alreadyExists = true;
            }
        }

        if (!alreadyExists) {
            NovoItemCarrinho.novoItemCarrinho(clt, pdt, qtd);
        }

    }
}
