package org.letscode.shoppingcart.core.entity;

import java.io.Serializable;

/**
 * Classe que representa uma entidade do sistema.
 * 
 * @param <ID> tipo do identificador da entidade
 */
public abstract class Entity<ID> implements Serializable {
    protected EntityIdentifier<ID> identifier;

    public EntityIdentifier<ID> getIdentifier() {
        return identifier;
    }
}
