package org.letscode.shoppingcart.core.data;

import java.util.HashMap;
import java.util.Map;

import org.letscode.shoppingcart.core.entity.Entity;
import org.letscode.shoppingcart.core.utils.PKUtils;

/**
 * Classe que armazena em memória todas as entidades do sistema.
 */
public class EntityRegistry {
    private Map<String, Store<Entity<Object>, Object>> registry;

    public EntityRegistry(Map<String, Store<Entity<Object>, Object>> registry) {
        this.registry = registry;
    }

    /**
     * Retorna o armazenamento de uma única entidade.
     * 
     * @param clazz classe da entidade
     * @return
     */
    @SuppressWarnings("unchecked")
    public <ID extends Object, T extends Entity<ID>> Store<T, ID> getStore(Class<T> clazz) {
        // obtem a classe ou a superclasse que contém o campo anotado com @PK
        Class<T> rootAncestor = (Class<T>) PKUtils.getClassThatContainsFieldAnnotatedWithPK(clazz);

        String className = rootAncestor.getName();
        
        // se a classe não estiver no registro, cria um novo registro para a classe
        if (!registry.containsKey(className)) {
            registry.put(className, new Store<>(new HashMap<>(), 0));
        }

        return (Store<T, ID>) registry.get(className);
    }
}
