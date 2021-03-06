package org.letscode.shoppingcart.repositories;

import org.letscode.shoppingcart.core.data.Repository;
import org.letscode.shoppingcart.domain.Produto;

public class ProdutoRepository extends Repository<Produto, Long> {
    private static ProdutoRepository instance;

    private ProdutoRepository() {
        super(Produto.class);
    }

    public static ProdutoRepository getInstance() {
        if(instance == null) {
            instance = new ProdutoRepository();
        }
        return instance;
    }
}
