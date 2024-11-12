package br.grupointegrado.book.model;


import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.Date;
import java.util.Objects;

@Entity
@Table (name = "pagamento")
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_pagamento;

    @Column
    private Date data_pagamento;

    @Column
    private Float valor;

    @Column
    private String metodo;

    @ManyToOne
    @JoinColumn(name = "id_pedido", referencedColumnName = "id_pedido")
    private Pedidos id_pedido;

    public Integer getId_pagamento() {
        return id_pagamento;
    }

    public void setId_pagamento(Integer id_pagamento) {
        this.id_pagamento = id_pagamento;
    }

    public Date getData_pagamento() {
        return data_pagamento;
    }

    public void setData_pagamento(Date data_pagamento) {
        this.data_pagamento = data_pagamento;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public String getMetodo() {
        return metodo;
    }

    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }

    public Pedidos getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(Pedidos id_pedido) {
        this.id_pedido = id_pedido;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pagamento pagamento = (Pagamento) o;
        return Objects.equals(id_pagamento, pagamento.id_pagamento);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id_pagamento);
    }
}

