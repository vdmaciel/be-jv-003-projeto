package org.letscode.shoppingcart.core.contracts;

import org.letscode.shoppingcart.core.data.EntityRegistry;

public interface IPersistor {
    public void persist(EntityRegistry storage);
    public EntityRegistry retrieve();
}
