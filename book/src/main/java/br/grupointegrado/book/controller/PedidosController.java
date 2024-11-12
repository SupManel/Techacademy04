package br.grupointegrado.book.controller;

import br.grupointegrado.book.DTO.PedidoRequestDTO;
import br.grupointegrado.book.model.Pedidos;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pedidos")
public class PedidosController {

    private static PedidosController repository;

    public static void setRepository(PedidosController repository) {
        PedidosController.repository = repository;
    }

    @GetMapping
    public ResponseEntity<List<Pedidos>> findAll() {
        List<Pedidos> pedidos = repository.findAll().getBody();
        return ResponseEntity.ok(pedidos);
    }

    @GetMapping("/{id}")
    public Pedidos findById(@PathVariable Integer id) {
        return Optional.ofNullable(repository.findById(id))
                .orElseThrow(() ->
                        new IllegalArgumentException("Pedido não encontrado"));
    }

    @PostMapping
    public ResponseEntity<Pedidos> save(@RequestBody PedidoRequestDTO dto) {
        if (dto.status().isEmpty() || dto.status() == null) {
                return ResponseEntity.status(400).build();
        }


        Pedidos pedidos = new Pedidos();
        pedidos.setStatus(dto.status());

        return this.repository.save(dto);
    }

}