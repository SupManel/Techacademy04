package br.grupointegrado.book.DTO;

public record ProdutoRequestDTO(Integer id_produto,
                                String titulo,
                                String descricao,
                                String autor,
                                Float preco,
                                Integer estoque) {
}
