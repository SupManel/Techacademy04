package br.grupointegrado.book.DTO;

import br.grupointegrado.book.model.Categoria;
import br.grupointegrado.book.model.Produto;

public record ItemCategoriaRequestDTO(Integer id_itemCategoria,
                                      Integer id_categoria,
                                      Integer id_produto) {
}
