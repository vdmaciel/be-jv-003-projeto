package org.letscode.shoppingcart.repositories;

import org.letscode.shoppingcart.core.data.Repository;
import org.letscode.shoppingcart.domain.ItemCarrinho;

public class ItemCarrinhoRepository extends Repository<ItemCarrinho, Long> {
    private static ItemCarrinhoRepository instance;

    private ItemCarrinhoRepository() {
        super(ItemCarrinho.class);
    }

    public static ItemCarrinhoRepository getInstance() {
        if(instance == null) {
            instance = new ItemCarrinhoRepository();
        }
        return instance;
    }
}

