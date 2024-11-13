package br.grupointegrado.book.controller;

import br.grupointegrado.book.model.Pedidos;

import br.grupointegrado.book.repository.PedidosRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pedidos")
public class PedidosController {

    private PedidosRepository repository;


    @GetMapping
    public ResponseEntity<List<Pedidos>> findAll() {
        List<Pedidos> pedidos = repository.findAll();
        return ResponseEntity.ok(pedidos);
    }

    @GetMapping("/{id}")
    public Pedidos findById(@PathVariable Integer id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("Pedido não encontrado"));
    }

    @PostMapping
    public ResponseEntity<Pedidos> save(@RequestBody Pedidos dto) {
        if (dto.status().isEmpty() || dto.status() == null) {
                return ResponseEntity.status(428).build();
        }


        Pedidos pedidos = new Pedidos();
        pedidos.setStatus(dto.status());

        this.repository.save(dto);
        return ResponseEntity.ok(pedidos);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Pedidos id) {
        Pedidos pedido = this.repository.findById(id.getId_pedidos())
                .orElseThrow(() ->
                        new IllegalArgumentException("Pedido não encontrado"));

        this.repository.delete(pedido);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pedidos> update(@PathVariable Pedidos id) {
        Pedidos pedidos = this.repository.findById(id.getId_pedidos())
                .orElseThrow(() ->
                        new IllegalArgumentException("Pedido não encontrado"));

        pedidos.setStatus(id.getStatus());

        repository.save(pedidos);
        return ResponseEntity.ok(pedidos);
    }
}