package br.grupointegrado.book.controller;

import br.grupointegrado.book.DTO.ItemCategoriaRequestDTO;
import br.grupointegrado.book.model.ItemCategoria;
import br.grupointegrado.book.repository.ItemCategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/item-categoria")
public class ItemCategoriaController {

    @Autowired
    private ItemCategoriaRepository repository;

    @GetMapping
    public ResponseEntity<List<ItemCategoria>> findAll() {
        List<ItemCategoria> itemcategoria = this.repository.findAll();
        return ResponseEntity.ok(itemcategoria);
    }

    @GetMapping("/{id}")
    public ItemCategoria findById(@PathVariable Integer id) {
        return this.repository.findById(id).
                orElseThrow(() ->
                        new IllegalArgumentException("ItemCategoria não encontrado"));
    }

    @PostMapping
    public ResponseEntity<ItemCategoria> save(@RequestBody ItemCategoriaRequestDTO dto ) {
        ItemCategoria itemCategoria = new ItemCategoria();

        itemCategoria.setId_itemCategoria(dto.id_itemCategoria());
        itemCategoria.setId_categoria(dto.id_categoria());
        itemCategoria.setId_produto(dto.id_produto());

        this.repository.save(itemCategoria);
        return ResponseEntity.ok(itemCategoria);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable ItemCategoria id) {
        ItemCategoria itemCategoria = this.repository.findById(id.getId_itemCategoria())
                .orElseThrow(() ->
                        new IllegalArgumentException("ItemCategoria não encontrado"));

        this.repository.delete(itemCategoria);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ItemCategoria> update(@PathVariable ItemCategoria id, @RequestBody ItemCategoriaRequestDTO dto) {
        ItemCategoria itemCategoria = this.repository.findById(id.getId_itemCategoria()).
                orElseThrow(() ->
                        new IllegalArgumentException("ItemCategoria não foi encontrado"));

        itemCategoria.setId_itemCategoria(dto.id_itemCategoria());
        itemCategoria.setId_produto(dto.id_produto());
        itemCategoria.setId_categoria(dto.id_categoria());

        this.repository.save(itemCategoria);
        return ResponseEntity.ok(itemCategoria);
    }
}
