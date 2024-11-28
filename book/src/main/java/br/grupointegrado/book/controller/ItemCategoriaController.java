package br.grupointegrado.book.controller;

import br.grupointegrado.book.DTO.ItemCategoriaRequestDTO;
import br.grupointegrado.book.model.ItemCategoria;
import br.grupointegrado.book.repository.ItemCategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/itemCategoria")
public class ItemCategoriaController {

    @Autowired
    private ItemCategoriaRepository repository;

    @GetMapping
    public ResponseEntity<List<ItemCategoria>> findAll() {
        List<ItemCategoria> itemcategoria = repository.findAll();
        return ResponseEntity.ok(itemcategoria);
    }

    @GetMapping("/{id}")
    public ItemCategoria findById(@PathVariable Integer id) {
        return repository.findById(id).
                orElseThrow(() ->
                        new IllegalArgumentException("Item-Categoria não encontrado"));
    }

    @PostMapping
    public ResponseEntity<ItemCategoria> save(@PathVariable ItemCategoriaRequestDTO dto ) {
        if (dto.id_itemCategoria().toString().isEmpty()) {
            return ResponseEntity.status(428).build();
        }

        ItemCategoria itemCategoria = new ItemCategoria();
        itemCategoria.setId_itemCategoria(Integer.valueOf(dto.id_itemCategoria()));

        this.repository.save(itemCategoria);
        return ResponseEntity.ok(itemCategoria);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable ItemCategoria id) {
        ItemCategoria itemCategoria = this.repository.findById(id.getId_itemCategoria())
                .orElseThrow(() ->
                        new IllegalArgumentException("Item-categoria não encontrado"));

        this.repository.delete(itemCategoria);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ItemCategoria> update(@PathVariable Integer id, @RequestBody ItemCategoriaRequestDTO dto) {
        if (dto.id_itemCategoria().toString().isEmpty()) {
            return ResponseEntity.status(428).build();
        }

        ItemCategoria itemCategoria = this.repository.findById(id).
                orElseThrow(() ->
                        new IllegalArgumentException("Item-categoria não foi encontrado"));

        itemCategoria.setId_itemCategoria(Integer.valueOf(dto.id_itemCategoria()));

        this.repository.save(itemCategoria);
        return ResponseEntity.ok(itemCategoria);
    }
}
