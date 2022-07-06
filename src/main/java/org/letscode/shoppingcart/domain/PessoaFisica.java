package org.letscode.shoppingcart.domain;

import org.letscode.shoppingcart.core.annotations.PK;

import java.util.Objects;

public class PessoaFisica extends Cliente {
    @PK
    private String cpf;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public PessoaFisica(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "PessoaFisica [cpf=" + cpf + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PessoaFisica pessoa = (PessoaFisica) o;
        return Objects.equals(cpf, pessoa.cpf);
    }
}
