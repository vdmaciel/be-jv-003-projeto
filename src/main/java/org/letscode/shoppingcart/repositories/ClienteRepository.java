package org.letscode.shoppingcart.repositories;

import org.letscode.shoppingcart.core.data.Repository;
import org.letscode.shoppingcart.domain.Cliente;
import org.letscode.shoppingcart.domain.PessoaFisica;
import org.letscode.shoppingcart.domain.PessoaJuridica;

public class ClienteRepository extends Repository<Cliente, String> {
    private static ClienteRepository instance;

    private ClienteRepository() {
        super(Cliente.class);
    }
    
    public static ClienteRepository getInstance() {
        if(instance == null) {
            instance = new ClienteRepository();
        }
        return instance;
    }

    public PessoaFisica getPessoaFisica(String cpf) {
        var cliente = this.getAll()
            .stream()
            .filter(c -> (PessoaFisica.class == c.getClass()))
            .filter(c -> ((PessoaFisica)c).getCpf().equals(cpf))
            .findFirst();

        if(cliente.isEmpty()) {
            return null;
        } else {
            return (PessoaFisica) cliente.get();
        }
    }

    public PessoaJuridica getPessoaJuridica(String cnpj) {
        var cliente = this.getAll()
            .stream()
            .filter(c -> (PessoaJuridica.class == c.getClass()))
            .filter(c -> ((PessoaJuridica)c).getCnpj().equals(cnpj))
            .findFirst();

        if(cliente.isEmpty()) {
            return null;
        } else {
            return (PessoaJuridica) cliente.get();
        }
    }
}
