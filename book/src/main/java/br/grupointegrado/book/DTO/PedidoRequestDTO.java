package br.grupointegrado.book.DTO;

import br.grupointegrado.book.model.Usuario;

import java.time.LocalDate;

public record PedidoRequestDTO(Integer id_pedido,
                               Float preco,
                               Float total,
                               LocalDate data,
                               String status,
                               Usuario id_usuario) {
}
