package br.grupointegrado.book.controller;


import br.grupointegrado.book.DTO.PagamentoRequestDTO;
import br.grupointegrado.book.model.Pagamento;
import br.grupointegrado.book.repository.PagamentoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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
        Pagamento pagamento = new Pagamento();

        pagamento.setId_pagamento(dto.id_pagamento());
        pagamento.setValor(dto.valor());
        pagamento.setData_pagamento(dto.date_pagamento());
        pagamento.setMetodo(dto.metodo());
        pagamento.setId_pedido(dto.id_pedido());

        this.repository.save(pagamento);
        return ResponseEntity.ok(pagamento);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        Pagamento pagamento = this.repository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("Pagamento não encontrado"));

        this.repository.delete(pagamento);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pagamento> update(@PathVariable Integer id, @RequestBody PagamentoRequestDTO dto) {
        Pagamento pagamento = this.repository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("Pagamento não foi encontrado"));

        pagamento.setId_pagamento(dto.id_pagamento());
        pagamento.setValor(dto.valor());
        pagamento.setData_pagamento(dto.date_pagamento());
        pagamento.setMetodo(dto.metodo());
        pagamento.setId_pedido(dto.id_pedido());

        this.repository.save(pagamento);
        return ResponseEntity.ok(pagamento);
    }

}
