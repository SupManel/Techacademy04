package br.grupointegrado.book.DTO;

import br.grupointegrado.book.model.Categoria;
import br.grupointegrado.book.model.Produto;

public record ItemCategoriaRequestDTO(
        Integer id_itemCategoria,
        Categoria id_categoria,
        Produto id_produto) {
}
