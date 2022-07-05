package org.letscode.shoppingcart.repositories;

import org.letscode.shoppingcart.core.data.Repository;
import org.letscode.shoppingcart.model.Cliente;

public class ClienteRepository extends Repository<Cliente, String> {
    private static ClienteRepository instance;

    private ClienteRepository() {
        super(Cliente.class);
    }
    
    public ClienteRepository getInstance() {
        if(instance == null) {
            instance = new ClienteRepository();
        }
        return instance;
    }
}
