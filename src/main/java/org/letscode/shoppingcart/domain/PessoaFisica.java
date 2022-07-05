package org.letscode.shoppingcart.domain;

import org.letscode.shoppingcart.core.annotations.PK;

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
}
