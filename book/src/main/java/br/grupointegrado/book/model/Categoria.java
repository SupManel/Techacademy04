package br.grupointegrado.book.model;


import jakarta.persistence.*;

@Entity
@Table (name = "categoria")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_categoria;

    @Column
    private String nome;
}
