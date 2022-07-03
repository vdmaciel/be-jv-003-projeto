package org.letscode.shoppingcart.repositories;

import org.letscode.shoppingcart.core.data.EntityManager;
import org.letscode.shoppingcart.core.data.Repository;
import org.letscode.shoppingcart.model.Cliente;

public class ClienteRepository extends Repository<Cliente, String> {

    public ClienteRepository(EntityManager em) {
        super(em, Cliente.class);
    }
    
}
