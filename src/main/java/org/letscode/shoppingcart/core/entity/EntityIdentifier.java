package org.letscode.shoppingcart.core.entity;

import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Classe que representa uma identificador de entidade.
 * @param <T> tipo de identificador
 */
public class EntityIdentifier<ID extends Object> implements Serializable{
    private String value;

    public EntityIdentifier(ID value) {
        this.value = EntityIdentifier.getPKHash(value);
    }

    public static <K extends Object> String getPKHash(K value) {
        try {
            return new String(MessageDigest.getInstance("SHA-256").digest(value.toString().getBytes()), StandardCharsets.UTF_8);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getValue() {
        return value;
    }
}
