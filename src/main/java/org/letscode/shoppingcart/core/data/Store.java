package org.letscode.shoppingcart.core.data;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import org.letscode.shoppingcart.core.annotations.AutoIncrement;
import org.letscode.shoppingcart.core.annotations.PK;
import org.letscode.shoppingcart.core.entity.Entity;
import org.letscode.shoppingcart.core.entity.EntityIdentifier;

public class Store<T extends Entity<ID>, ID extends Object> {
    private Map<String, T> data;
    private Integer sequence;

    public Store(Map<String, T> data, Integer sequence) {
        this.data = data;
        this.sequence = sequence;
    }

    public void applyAutoIncrementIdIfPossible(T entity) {
        for (Field field : entity.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(PK.class) && field.isAnnotationPresent(AutoIncrement.class)) {
                if (field.getType() == Integer.class || field.getType() == Long.class) {
                    try {
                        field.setAccessible(true);
                        if (field.get(entity) == null) {
                            if(field.getType() == Integer.class) {
                                field.set(entity, Integer.valueOf(getNextId()));
                            } else if(field.getType() == Long.class) {
                                field.set(entity, Long.valueOf(getNextId()));
                            }
                        }
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }

    public void assignEntityIdentifier(T entity) {
        boolean isAssigned = false;
        for (Field field : entity.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(PK.class)) {
                isAssigned = true;
                try {
                    Field identifier = entity.getClass().getSuperclass().getDeclaredField("identifier");
                    identifier.setAccessible(true);
                    field.setAccessible(true);
                    if(identifier.get(entity) == null) {
                        identifier.set(entity, new EntityIdentifier<>(field.get(entity)));
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
        if(!isAssigned) {
            throw new RuntimeException("No PK field found in " + entity.getClass().getName());
        }
    }

    public Integer getNextId() {
        sequence++;
        return sequence;
    }

    public T get(ID key) {
        return data.get(EntityIdentifier.getPKHash(key));
    }

    public void put(T entity) {
        applyAutoIncrementIdIfPossible(entity);
        assignEntityIdentifier(entity);
        data.put(entity.getIdentifier().getValue(), entity);
    }

    public void remove(ID key) {
        data.remove(EntityIdentifier.getPKHash(key));
    }

    public List<T> getAll() {
        return data.values().stream().collect(java.util.stream.Collectors.toList());
    }

}
