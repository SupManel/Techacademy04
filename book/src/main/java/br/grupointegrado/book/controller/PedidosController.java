package br.grupointegrado.book.controller;


import br.grupointegrado.book.model.Pedidos;
import br.grupointegrado.book.repository.PedidosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/Pedidos")
public class PedidosController {

    @Autowired
    private PedidosController repository;

    @GetMapping
    public List<Pedidos> findAll() {
        return this.repository.findAll();
    }

}
