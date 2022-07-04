package org.letscode.shoppingcart.model;

import org.letscode.shoppingcart.core.annotations.PK;
import org.letscode.shoppingcart.core.entity.Entity;

public class Cliente extends Entity<String> {
    @PK
    private String cpf;

    public Cliente(String cpf) {
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "Cliente [cpf=" + cpf + "]";
    }
}
