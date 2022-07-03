package org.letscode.shoppingcart.core.persistence;

import java.util.HashMap;

import org.letscode.shoppingcart.core.contracts.IPersistor;
import org.letscode.shoppingcart.core.data.EntityRegistry;

public class InMemoryPersistor implements IPersistor {
    EntityRegistry storage = new EntityRegistry(new HashMap<>());

    @Override
    public void persist(EntityRegistry storage) {
        this.storage = storage;
    }

    @Override
    public EntityRegistry retrieve() {
        return storage;
    }

}
