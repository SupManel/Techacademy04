package br.grupointegrado.book.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;


import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "pedido")
public class Pedidos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPedido;

    @Column
    private Float preco;

    @Column
    private Float total;

    @Column
    private LocalDate data;

    @Column
    private String status;

    @OneToMany(mappedBy = "id_pagamento")
    @JsonIgnoreProperties("id_pagamento")
    private List<Pagamento> Pagamento;

    @ManyToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    private Usuario id_usuario;

    public List<Pagamento> getPagamentos() {
        return Pagamento;
    }

    public void setPagamento(List<Pagamento> pagamento) {
        Pagamento = pagamento;
    }

    public Integer getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public Float getPreco() {
        return preco;
    }

    public void setPreco(Float preco) {
        this.preco = preco;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Usuario getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Usuario id_usuario) {
        this.id_usuario = id_usuario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pedidos pedidos = (Pedidos) o;
        return Objects.equals(idPedido, pedidos.idPedido);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(idPedido);
    }

    public void orElseThrow(Object pedidoNãoEncontrado) {

    }

    public Integer getId_pedidos() {

        return 0;
    }

    public String status() {

        return status;
    }
}
