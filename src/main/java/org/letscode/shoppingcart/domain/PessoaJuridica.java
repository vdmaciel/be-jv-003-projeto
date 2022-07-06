package org.letscode.shoppingcart.domain;

import org.letscode.shoppingcart.core.annotations.PK;

import java.util.Objects;

public class PessoaJuridica extends Cliente {
    @PK
    private String cnpj;

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    
    public PessoaJuridica(String cnpj) {
        this.cnpj = cnpj;
    }

    @Override
    public String toString() {
        return "PessoaJuridica [cnpj=" + cnpj + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(cnpj);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PessoaJuridica pessoa = (PessoaJuridica) o;
        return Objects.equals(cnpj, pessoa.cnpj);
    }
}
