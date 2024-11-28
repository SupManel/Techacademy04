package br.grupointegrado.book.DTO;

import br.grupointegrado.book.model.Pedidos;

import java.time.LocalDate;

public record PagamentoRequestDTO(Integer id_pagamento,
                                  LocalDate date_pagamento,
                                  Float valor,
                                  String metodo,
                                  Pedidos id_pedido) {
}
