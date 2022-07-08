package org.letscode.shoppingcart.domain;

import org.letscode.shoppingcart.core.annotations.AutoIncrement;
import org.letscode.shoppingcart.core.annotations.PK;
import org.letscode.shoppingcart.core.entity.Entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class Produto extends Entity<Long> {
    @PK
    @AutoIncrement
    private Long id;

    private String nome;

    private BigDecimal preco;

    private Double frete;

    private Double taxaAdicional;

    private Double peso;

    public enum Categoria {
        DIGITAL, MEDICAMENTO, LIMPEZA, ALIMENTO, VESTUARIO
    }

    private Categoria categoria;

    private double desconto = 0.1;

    public Produto(Builder builder) {
        this.nome = builder.nome;
        this.preco = builder.preco;
        this.frete = builder.frete;
        this.taxaAdicional = builder.taxaAdicional;
        this.peso = builder.peso;
        this.categoria = builder.categoria;
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

    public BigDecimal getPreco() {
        return preco;
    }

    public Double getPeso() {
        return peso;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return Objects.equals(id, produto.id);
    }

    @Override
    public String toString() {
        return "Produto [frete=" + frete + ", id=" + id + ", nome=" + nome + ", taxaAdicional=" + taxaAdicional
                + ", peso=" + peso + ", categoria=" + categoria +"]";
    }

    public static class Builder {
        private String nome;

        private BigDecimal preco;

        private Double frete;

        private Double taxaAdicional;

        private Double peso;

        private Categoria categoria;

        public Builder() {

        }

        public Builder comNome(String nome) {
            this.nome = nome;
            return this;
        }

        public Builder comPreco(BigDecimal preco) {
            this.preco = preco;
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

        public Builder comPeso(Double peso) {
            this.peso = peso;
            return this;
        }

        public Builder comCategoria(Categoria categoria) {
            this.categoria = categoria;
            return this;
        }

        public Produto build() {
            return new Produto(this);
        }
    }
}
