package org.letscode.shoppingcart;

import org.letscode.shoppingcart.core.data.EntityManager;
import org.letscode.shoppingcart.core.persistence.FilePersistor;
import org.letscode.shoppingcart.domain.Cliente;
import org.letscode.shoppingcart.domain.PessoaFisica;
import org.letscode.shoppingcart.domain.Produto;
import org.letscode.shoppingcart.repositories.ClienteRepository;
import org.letscode.shoppingcart.repositories.ProdutoRepository;

public class Aplicacao {
    public static void main(String[] args) {
        EntityManager em = EntityManager.getInstance();
        em.setPersistor(new FilePersistor());
        ProdutoRepository repository = ProdutoRepository.getInstance();
        ClienteRepository clienteRepository = ClienteRepository.getInstance();

        Produto produto = new Produto.Builder()
            .comNome("Produto 1")
            .comFrete(2.00)
            .comTaxaAdicional(1.00)
            .build();

        Produto produto2 = new Produto.Builder()
            .comNome("Produto 2")
            .comFrete(2.00)
            .build();
            
        Cliente cliente = new PessoaFisica("999.999.999-99");

        repository.save(produto);
        repository.save(produto2);
        em.save(cliente);

        System.out.println(em.get(1, Produto.class));
        System.out.println(em.get(2, Produto.class));
        System.out.println(em.get(1, Cliente.class));
        System.out.println(clienteRepository.getPessoaFisica("999.999.999-99"));
    }
}
