package org.letscode.shoppingcart;

import org.letscode.shoppingcart.core.data.EntityManager;
import org.letscode.shoppingcart.core.persistence.InMemoryPersistor;
import org.letscode.shoppingcart.model.Cliente;
import org.letscode.shoppingcart.model.Produto;

public class Aplicacao {
    public static void main(String[] args) {
        EntityManager em = new EntityManager(new InMemoryPersistor());
        Produto produto = new Produto("Produto 1");
        Produto produto2 = new Produto("Produto 2");
        Cliente cliente = new Cliente("999.999.999-99");

        em.save(produto);
        em.save(produto2);
        em.save(cliente);

        System.out.println(em.get(1, Produto.class));
        System.out.println(em.get(2, Produto.class));
        System.out.println(em.get("999.999.999-99", Cliente.class));
    }
}
