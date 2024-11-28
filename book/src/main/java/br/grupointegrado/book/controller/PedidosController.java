package br.grupointegrado.book.controller;

import br.grupointegrado.book.DTO.PedidoRequestDTO;
import br.grupointegrado.book.model.Pedidos;

import br.grupointegrado.book.repository.PedidosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
public class PedidosController {

    @Autowired
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
    public ResponseEntity<Pedidos> save(@RequestBody PedidoRequestDTO dto) {
        Pedidos pedidos = new Pedidos();

        pedidos.setId_pedido(dto.id_pedido());
        pedidos.setPreco(dto.preco());
        pedidos.setTotal(dto.total());
        pedidos.setData(dto.data());
        pedidos.setStatus(dto.status());;
        pedidos.setId_usuario(dto.id_usuario());

        this.repository.save(pedidos);
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