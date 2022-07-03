package org.letscode.shoppingcart.core.entity;

public abstract class Entity<ID> {
    protected EntityIdentifier<ID> identifier;

    public EntityIdentifier<ID> getIdentifier() {
        return identifier;
    }
}
