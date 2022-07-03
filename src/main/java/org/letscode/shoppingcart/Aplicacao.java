package org.letscode.shoppingcart;

import org.letscode.shoppingcart.core.data.EntityManager;
import org.letscode.shoppingcart.core.persistence.InMemoryPersistor;
import org.letscode.shoppingcart.model.Produto;

public class Aplicacao {
    public static void main(String[] args) {
        EntityManager em = new EntityManager(new InMemoryPersistor());
        Produto produto = new Produto("Produto 1");
        Produto produto2 = new Produto("Produto 2");

        em.save(produto);
        em.save(produto2);

        System.out.println(em.get(1, Produto.class));
    }
}
