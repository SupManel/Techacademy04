package br.grupointegrado.book.controller;


import br.grupointegrado.book.DTO.PedidoRequestDTO;
import br.grupointegrado.book.model.Pedidos;
import br.grupointegrado.book.repository.PedidosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
public class PedidosController {

    @Autowired
    private PedidosController repository;

    @GetMapping
    public List<Pedidos> findAll() {
        return this.repository.findAll();
    }

    @GetMapping("/{id}")
    public Pedidos findById(@PathVariable Integer id) {
        return this.repository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("Filme não foi encontrado"));
    }

    @PostMapping
    public Pedidos save(@RequestBody PedidoRequestDTO dto) {
        Pedidos pedidos = new Pedidos();
        pedidos.setStatus(dto.status());

        return this.repository.save(dto);
    }

}