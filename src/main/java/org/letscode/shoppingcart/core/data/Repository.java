package org.letscode.shoppingcart.core.data;

import java.util.List;

import org.letscode.shoppingcart.core.entity.Entity;

public abstract class Repository<T extends Entity<ID>, ID extends Object> {
    protected EntityManager em = EntityManager.getInstance();
    protected Class<T> clazz;

    public Repository(Class<T> clazz) {
        this.clazz = clazz;
    }

    public T getById(ID id) {
        return em.get(id, clazz);
    }

    public void save(T entity) {
        em.save(entity);
    }

    public void delete(T entity) {
        em.delete(entity);
    }

    public List<T> getAll() {
        return em.getAll(clazz);
    }
}
