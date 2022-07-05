package org.letscode.shoppingcart.domain;

import org.letscode.shoppingcart.core.annotations.PK;

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
}
