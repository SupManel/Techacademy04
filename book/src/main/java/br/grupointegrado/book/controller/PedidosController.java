package br.grupointegrado.book.controller;

import br.grupointegrado.book.DTO.PedidoRequestDTO;
import br.grupointegrado.book.model.Pedidos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pedidos")
public class PedidosController {

    @Autowired
    private static PedidosController repository;

    @GetMapping
    public ResponseEntity<List<Pedidos>> findAll() {
        List<Pedidos> pedidos = this.repository.findAll().getBody();
        return ResponseEntity.ok(pedidos);
    }

    @GetMapping("/{id}")
    public Pedidos findById(@PathVariable Integer id) {
        return Optional.ofNullable(this.repository.findById(id))
                .orElseThrow(() ->
                        new IllegalArgumentException("Pedido não encontrado"));
    }

    @PostMapping
    public Pedidos save(@RequestBody PedidoRequestDTO dto) {
        Pedidos pedidos = new Pedidos();
        pedidos.setStatus(dto.status());

        return this.repository.save(dto);
    }

}