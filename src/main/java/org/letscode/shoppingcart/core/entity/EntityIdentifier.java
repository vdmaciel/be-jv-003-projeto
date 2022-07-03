package org.letscode.shoppingcart.core.entity;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EntityIdentifier<ID extends Object> {
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
