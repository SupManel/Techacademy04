package br.grupointegrado.book.DTO;

import br.grupointegrado.book.model.Pedidos;
import br.grupointegrado.book.model.Produto;

public record ItemPedidoRequestDTO(Integer id_item,
                                   Integer quantidade_item,
                                   Float preco_unitario,
                                   Integer id_pedido,
                                   Integer id_produto) {
}
