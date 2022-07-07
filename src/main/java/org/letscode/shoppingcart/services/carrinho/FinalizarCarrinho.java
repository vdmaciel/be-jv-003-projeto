package org.letscode.shoppingcart.services.carrinho;

import java.util.List;

import org.letscode.shoppingcart.domain.Cliente;
import org.letscode.shoppingcart.domain.ItemCarrinho;
import org.letscode.shoppingcart.services.carrinho.processamentos.ProcessarCarrinho;

public class FinalizarCarrinho {

    List<ProcessarCarrinho> processamentos;

    public FinalizarCarrinho(List<ProcessarCarrinho> processamentos) {
        this.processamentos = processamentos;
    }

    public void finalizar(Cliente cliente){
        List<ItemCarrinho> carrinho = CarrinhoDoCliente.carrinhoDoCliente(cliente);
    
        processamentos.forEach(proc -> proc.processar(carrinho));
    }

}
