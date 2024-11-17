package br.grupointegrado.book.controller;


import br.grupointegrado.book.DTO.PagamentoRequestDTO;
import br.grupointegrado.book.model.Pagamento;
import br.grupointegrado.book.repository.PagamentoRepository;
import br.grupointegrado.book.repository.PedidosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pagamento")
public class PagamentoController {

    @Autowired
    private PagamentoRepository repository;

    @GetMapping
    public ResponseEntity<List<Pagamento>> findAll() {
        List<Pagamento> pagamentos = this.repository.findAll();
        return ResponseEntity.ok(pagamentos);
    }

    @GetMapping("/{id}")
    public Pagamento findById(@PathVariable Integer id) {
        return this.repository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Pagamento não encontrado"));
    }

    @PostMapping
    public ResponseEntity<Pagamento> save(@RequestBody PagamentoRequestDTO dto) {
        if (dto.nome().isEmpty() || dto.nome() == null) {
            return ResponseEntity.status(428).build();
        }


        Pagamento pagamento = new Pagamento();
        pagamento.setMetodo(dto.nome());

        this.repository.save(pagamento);
        return ResponseEntity.ok(pagamento);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Pagamento id) {
        Pagamento pagamento = this.repository.findById(id.getId_pagamento())
                .orElseThrow(() ->
                        new IllegalArgumentException("Pagamento não encontrado"));

        this.repository.delete(pagamento);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pagamento> update(@PathVariable Integer id, @RequestBody PagamentoRequestDTO dto) {
        if (dto.nome().isEmpty()) {
            return ResponseEntity.status(428).build();
        }

        Pagamento pagamento = this.repository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("Filme não foi encontrado"));

        pagamento.setMetodo(dto.nome());

        this.repository.save(pagamento);
        return ResponseEntity.ok(pagamento);
    }

}
