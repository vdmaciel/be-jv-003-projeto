package org.letscode.shoppingcart.domain;

import org.letscode.shoppingcart.core.annotations.AutoIncrement;
import org.letscode.shoppingcart.core.annotations.PK;
import org.letscode.shoppingcart.core.entity.Entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class ItemCarrinho extends Entity<Long> {

    @PK
    @AutoIncrement
    private Long id;
    private Cliente cliente;
    private Produto produto;
    private int amount = 0;

    public ItemCarrinho(Cliente cliente, Produto produto, int amount) {
        this.cliente = cliente;
        this.produto = produto;
        this.amount = amount;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Produto getProduto() {
        return produto;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public BigDecimal valorTotal(){
        return produto.getPreco().multiply(new BigDecimal(amount));
    }
}
