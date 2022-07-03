package org.letscode.shoppingcart.core.data;

import java.util.List;

import org.letscode.shoppingcart.core.contracts.IPersistor;
import org.letscode.shoppingcart.core.entity.Entity;

public class EntityManager {
    private EntityRegistry registry;
    private IPersistor persistor;

    public EntityManager(IPersistor persistor) {
        this.persistor = persistor;
        this.registry = this.persistor.retrieve();
    }

    @SuppressWarnings("unchecked")
    public <T extends Entity<ID>, ID extends Object> T get(Object id, Class<? extends Entity<ID>> clazz) {
        return (T) registry.getStore(clazz).get((ID) id);
    }

    @SuppressWarnings("unchecked")
    public <T extends Entity<ID>, ID extends Object> void save(T entity) {
        this.registry.getStore(entity.getClass()).put(entity);
        this.persistor.persist(this.registry);
    }

    @SuppressWarnings("unchecked")
    public <T extends Entity<ID>, ID extends Object> void delete(T entity) {
        this.registry.getStore(entity.getClass()).remove(entity);
        this.persistor.persist(this.registry);
    }

    @SuppressWarnings("unchecked")
    public <T extends Entity<ID>, ID extends Object> List<T> getAll(Class<? extends Entity<ID>> clazz) {
        return (List<T>) this.registry.getStore(clazz).getAll();
    }
}
