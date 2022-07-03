package org.letscode.shoppingcart.core.data;

import java.util.HashMap;
import java.util.Map;

import org.letscode.shoppingcart.core.entity.Entity;

public class EntityRegistry {
    private Map<String, Store<Entity<Object>, Object>> registry;

    public EntityRegistry(Map<String, Store<Entity<Object>, Object>> registry) {
        this.registry = registry;
    }

    @SuppressWarnings("unchecked")
    public <ID extends Object, T extends Entity<ID>> Store<T, ID> getStore(Class<T> clazz) {
        String className = clazz.getName();
        if (!registry.containsKey(className)) {
            registry.put(className, new Store<>(new HashMap<>(), 0));
        }
        return (Store<T, ID>) registry.get(className);
    }
}
