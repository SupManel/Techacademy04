package br.grupointegrado.book.repository;

import br.grupointegrado.book.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
}
