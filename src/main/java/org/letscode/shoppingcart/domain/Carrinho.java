package org.letscode.shoppingcart.domain;

import java.io.Serializable;
import java.util.List;

public class Carrinho {

    private List<ItemCarrinho> items;

    private Cliente cliente;

    public Carrinho(Cliente cliente, List<ItemCarrinho> items){
        this.cliente = cliente;
        this.items = items;
    }

    public List<ItemCarrinho> getItems() {
        return items;
    }

    public void setItems(List<ItemCarrinho> items) {
        this.items = items;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

}
