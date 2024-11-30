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
        List<Pedidos> pedido = repository.findAll();
        return ResponseEntity.ok(pedido);
    }

    @GetMapping("/{id}")
    public Pedidos findById(@PathVariable Integer id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("Pedido não encontrado"));
    }

    @PostMapping
    public ResponseEntity<Pedidos> save(@RequestBody PedidoRequestDTO dto) {
        Pedidos pedido = new Pedidos();

        pedido.setId_pedido(dto.id_pedido());
        pedido.setPreco(dto.preco());
        pedido.setTotal(dto.total());
        pedido.setData(dto.data());
        pedido.setStatus(dto.status());;
        pedido.setId_usuario(dto.id_usuario());

        this.repository.save(pedido);
        return ResponseEntity.ok(pedido);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Pedidos id) {
        Pedidos pedido = this.repository.findById(id.getId_pedido())
                .orElseThrow(() ->
                        new IllegalArgumentException("Pedido não encontrado"));

        this.repository.delete(pedido);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pedidos> update(@PathVariable Pedidos id, @RequestBody PedidoRequestDTO dto) {
        Pedidos pedido = this.repository.findById(id.getId_pedido())
                .orElseThrow(() ->
                        new IllegalArgumentException("Pedido não encontrado"));

        pedido.setData(dto.data());
        pedido.setPreco(dto.preco());
        pedido.setTotal(dto.total());
        pedido.setPagamento(dto.pagamento());
        pedido.setStatus(dto.status());
        pedido.setId_pedido(dto.id_pedido());
        pedido.setId_usuario(dto.id_usuario());

        repository.save(pedido);
        return ResponseEntity.ok(pedido);
    }
}