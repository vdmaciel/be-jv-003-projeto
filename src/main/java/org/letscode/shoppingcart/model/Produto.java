package org.letscode.shoppingcart.model;

import org.letscode.shoppingcart.core.annotations.AutoIncrement;
import org.letscode.shoppingcart.core.annotations.PK;
import org.letscode.shoppingcart.core.entity.Entity;

public class Produto extends Entity<Long> {
    @PK
    @AutoIncrement
    private Long id;

    private String nome;

    public Produto(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Produto [id=" + id + ", nome=" + nome + "]";
    }
}
