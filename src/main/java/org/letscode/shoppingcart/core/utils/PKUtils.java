package org.letscode.shoppingcart.core.utils;

import java.util.Arrays;

import org.letscode.shoppingcart.core.annotations.PK;

public class PKUtils {
    /**
     * Busca pela classe que contém o campo annotado com @PK, 
     * se a classe não contém o campo annotado com @PK, 
     * repete o processo para a superclasse
     * 
     * @param clazz qualquer classe que herde de Entity
     * @return a classe que contém o campo annotado com @PK
     */
    public static Class<?> getClassThatContainsFieldAnnotatedWithPK(Class<?> clazz) {
        Class<?> currentClass = clazz;
        while (currentClass != null) {
            if (Arrays.asList(currentClass.getDeclaredFields()).stream().anyMatch(f -> f.isAnnotationPresent(PK.class))) {
                return currentClass;
            }
            currentClass = currentClass.getSuperclass();
        }

        throw new RuntimeException("PK not found in class " + clazz.getName());
    }
}
