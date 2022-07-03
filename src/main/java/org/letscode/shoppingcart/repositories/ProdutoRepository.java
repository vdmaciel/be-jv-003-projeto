package org.letscode.shoppingcart.repositories;

import org.letscode.shoppingcart.core.data.EntityManager;
import org.letscode.shoppingcart.core.data.Repository;
import org.letscode.shoppingcart.model.Produto;

public class ProdutoRepository extends Repository<Produto, Long> {

    public ProdutoRepository(EntityManager em) {
        super(em, Produto.class);
    }
}
