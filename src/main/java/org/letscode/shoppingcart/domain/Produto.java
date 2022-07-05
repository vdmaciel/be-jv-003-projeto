package org.letscode.shoppingcart.domain;

import org.letscode.shoppingcart.core.annotations.AutoIncrement;
import org.letscode.shoppingcart.core.annotations.PK;
import org.letscode.shoppingcart.core.entity.Entity;

public class Produto extends Entity<Long> {
    @PK
    @AutoIncrement
    private Long id;

    private String nome;

    private Double frete;

    private Double taxaAdicional;

    public Produto(Builder builder) {
        this.nome = builder.nome;
        this.frete = builder.frete;
        this.taxaAdicional = builder.taxaAdicional;
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

    public Double getFrete() {
        return frete;
    }

    public Double getTaxaAdicional() {
        return taxaAdicional;
    }

    @Override
    public String toString() {
        return "Produto [frete=" + frete + ", id=" + id + ", nome=" + nome + ", taxaAdicional=" + taxaAdicional + "]";
    }

    public static class Builder {
        private String nome;

        private Double frete;
    
        private Double taxaAdicional;

        public Builder() {

        }

        public Builder comNome(String nome) {
            this.nome = nome;
            return this;
        }

        public Builder comFrete(Double frete) {
            this.frete = frete;
            return this;
        }

        public Builder comTaxaAdicional(Double taxa) {
            this.taxaAdicional = taxa;
            return this;
        }

        public Produto build() {
            return new Produto(this);
        }
    }
}
