package br.grupointegrado.book.controller;


import br.grupointegrado.book.DTO.CategoriaRequestDTO;
import br.grupointegrado.book.model.Categoria;
import br.grupointegrado.book.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaRepository repository;

    @GetMapping
    public ResponseEntity<List<Categoria>> findAll() {
        List<Categoria> categorias = this.repository.findAll();
        return ResponseEntity.ok(categorias);
    }

    @GetMapping("/{id}")
    public Categoria findById(@PathVariable Integer id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("Categoria não encontrado"));
    }

    @PostMapping
    public ResponseEntity<Categoria> save(@RequestBody CategoriaRequestDTO dto) {
        Categoria categoria = new Categoria();

        categoria.setNome(dto.nome());
        categoria.setId_categoria(dto.id_categoria());


        this.repository.save(categoria);
        return ResponseEntity.ok(categoria);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        Categoria categoria = this.repository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("Categoria não encontrado"));

        this.repository.delete(categoria);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Categoria> update(@PathVariable Categoria id) {
        Categoria categoria = this.repository.findById(id.getId_categoria())
                .orElseThrow(() ->
                        new IllegalArgumentException("Categoria não encontrado"));

        categoria.setId_categoria(id.getId_categoria());
        categoria.setNome(id.getNome());

        repository.save(categoria);
        return ResponseEntity.ok(categoria);
    }
}
