package br.grupointegrado.book.controller;


import br.grupointegrado.book.DTO.ItemPedidoRequestDTO;
import br.grupointegrado.book.model.ItemPedido;
import br.grupointegrado.book.repository.ItemPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/item-pedido")
public class ItemPedidoController {

    @Autowired
    private ItemPedidoRepository repository;

    @GetMapping
    public ResponseEntity<List<ItemPedido>> findAll() {
        List<ItemPedido> itemPedidos = repository.findAll();
        return ResponseEntity.ok(itemPedidos);
    }

    @GetMapping("/{id}")
    public ItemPedido findById(@PathVariable Integer id) {
        return repository.findById(id).
                orElseThrow(() ->
                        new IllegalArgumentException("Item-Pedido não encontrado"));
    }

    @PostMapping
    public ResponseEntity<ItemPedido> save(@PathVariable ItemPedidoRequestDTO dto ) {
        if (dto.id_item().isEmpty()) {
            return ResponseEntity.status(428).build();
        }

        ItemPedido itemPedido = new ItemPedido();
        itemPedido.setId_item(Integer.valueOf(dto.id_item()));

        this.repository.save(itemPedido);
        return ResponseEntity.ok(itemPedido);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable ItemPedido id) {
        ItemPedido itemPedido = this.repository.findById(id.getId_item())
                .orElseThrow(() ->
                        new IllegalArgumentException("Item-pedido não encontrado"));

        this.repository.delete(itemPedido);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ItemPedido> update(@PathVariable Integer id, @RequestBody ItemPedidoRequestDTO dto) {
        if (dto.id_item().isEmpty()) {
            return ResponseEntity.status(428).build();
        }

        ItemPedido itemPedido = this.repository.findById(id).
                orElseThrow(() ->
                        new IllegalArgumentException("Item-Pedido não foi encontrado"));

        itemPedido.setId_item(Integer.valueOf(dto.id_item()));

        this.repository.save(itemPedido);
        return ResponseEntity.ok(itemPedido);
    }
}
