package br.grupointegrado.book.DTO;

import br.grupointegrado.book.model.Pagamento;
import br.grupointegrado.book.model.Usuario;

import java.time.LocalDate;
import java.util.List;

public record PedidoRequestDTO(Integer id_pedido,
                               Float preco,
                               Float total,
                               LocalDate data,
                               String status,
                               Usuario id_usuario,
                               List<Pagamento> pagamento
                               ) {
}
