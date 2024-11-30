package br.grupointegrado.book.controller;


import br.grupointegrado.book.DTO.ProdutoRequestDTO;
import br.grupointegrado.book.model.Produto;
import br.grupointegrado.book.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/produto")
public class ProdutoController {

    @Autowired
    private ProdutoRepository repository;

    @GetMapping
    public ResponseEntity<List<Produto>> findAll() {
        List<Produto> produtos = repository.findAll();
        return ResponseEntity.ok(produtos);
    }

    @GetMapping("/{id}")
    public Produto findById(@PathVariable Integer id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("Produto não encontrado"));
    }

    @PostMapping
    public ResponseEntity<Produto> save(@RequestBody ProdutoRequestDTO dto) {
       Produto produtos = new Produto();

       produtos.setId_produto(dto.id_produto());
       produtos.setTitulo(dto.titulo());
       produtos.setAutor(dto.autor());
       produtos.setDescricao(dto.descricao());
       produtos.setPreco(dto.preco());
       produtos.setEstoque(dto.estoque());


        this.repository.save(produtos);
        return ResponseEntity.ok(produtos);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Produto id) {
        Produto produto = this.repository.findById(id.getId_produto())
                .orElseThrow(() ->
                        new IllegalArgumentException("Produto não encontrado"));

        this.repository.delete(produto);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> update(@PathVariable Produto id, @RequestBody ProdutoRequestDTO dto) {
        Produto produto = this.repository.findById(id.getId_produto())
                .orElseThrow(() ->
                        new IllegalArgumentException("Produto não encontrado"));

        produto.setId_produto(dto.id_produto());
        produto.setTitulo(dto.titulo());
        produto.setAutor(dto.autor());
        produto.setDescricao(dto.descricao());
        produto.setPreco(dto.preco());
        produto.setEstoque(dto.estoque());

        repository.save(produto);
        return ResponseEntity.ok(produto);
    }
}
