package org.letscode.shoppingcart.services.carrinho.processamentos;

import java.util.List;

import org.letscode.shoppingcart.domain.ItemCarrinho;

public interface ProcessarCarrinho {

  void processar(List<ItemCarrinho> carrinho);

}
