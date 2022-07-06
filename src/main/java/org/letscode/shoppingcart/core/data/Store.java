package org.letscode.shoppingcart.core.data;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.letscode.shoppingcart.core.annotations.AutoIncrement;
import org.letscode.shoppingcart.core.annotations.PK;
import org.letscode.shoppingcart.core.entity.Entity;
import org.letscode.shoppingcart.core.entity.EntityIdentifier;

/**
 * Classe responsável por realizar o mapeamento entre chaves primarias e instancias de uma entidade específica
 *
 * @param <T> tipo da entidade
 * @param <ID> tipo do identificador da entidade
 */
public class Store<T extends Entity<ID>, ID extends Object> {
    private Map<String, T> data;
    private Integer sequence;

    public Store(Map<String, T> data, Integer sequence) {
        this.data = data;
        this.sequence = sequence;
    }

    /**
     * Verifica se o campo anotado com @PK também é anotado com @AutoIncrement
     * Se for, gera um novo ID para o objeto baseado no valor da sequência de IDs gerados anteriormente
     * @param entity objeto a ser salvo
     */
    public void applyAutoIncrementIdIfPossible(T entity) {
        for (Field field : this.getEntityFields(entity.getClass())) {
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

    /**
     * Busca por todos os campos publicos, privados e protegidos da classe e suas superclasses
     * @param clazz
     * @return lista de campos da classe
     */
    private List<Field> getEntityFields(Class<?> clazz) {
        List<Field> fields = new ArrayList<>();
        while(clazz != Object.class) {
            fields.addAll(Arrays.asList(clazz.getDeclaredFields()));
            clazz = clazz.getSuperclass();
        }
        return fields;
    }

    /**
     * Instancia um identificador de entidade para o objeto se este ainda não o possuir
     * o identificador é instanciado utilizand o valor armazenado no campo anotado com @PK
     * @param entity objeto a ser salvo
     */
    public void assignEntityIdentifier(T entity) {
        boolean isAssigned = false;
        for (Field field : this.getEntityFields(entity.getClass())) {
            if (field.isAnnotationPresent(PK.class)) {
                isAssigned = true;
                try {
                    Field identifier = Entity.class.getDeclaredField("identifier");
                    identifier.setAccessible(true);
                    field.setAccessible(true);
                    Object primaryKeyValue = field.get(entity);
                    Object identifierValue = identifier.get(entity);
                    if(identifierValue == null) {
                        identifier.set(entity, new EntityIdentifier<>(primaryKeyValue));
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

    /**
     * Gera um novo ID para o objeto baseado no valor da sequência de IDs gerados anteriormente
     * @return novo ID sequencial
     */
    public Integer getNextId() {
        sequence++;
        return sequence;
    }

    /**
     * Obtém o objeto salvo no armazenamento com o ID informado
     * @param id ID do objeto a ser buscado
     */
    public T get(ID key) {
        return data.get(EntityIdentifier.getPKHash(key));
    }

    /**
     * Salva o objeto no armazenamento
     * @param entity objeto a ser salvo
     */
    public void put(T entity) {
        applyAutoIncrementIdIfPossible(entity);
        assignEntityIdentifier(entity);

        data.put(entity.getIdentifier().getValue(), entity);
    }

    /**
     * Remove o objeto do armazenamento
     * @param entity objeto a ser removido
     */
    public void remove(ID key) {
        data.remove(EntityIdentifier.getPKHash(key));
    }

    /**
     * Obtém todos os objetos salvos no armazenamento
     * @return lista de objetos
     */
    public List<T> getAll() {
        return data.values().stream().collect(java.util.stream.Collectors.toList());
    }

}
