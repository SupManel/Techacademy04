package br.grupointegrado.book.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table (name = "itemCategoria")
public class ItemCategoria {

    @OneToMany (mappedBy = "id_categoria")
    @JsonIgnoreProperties("id_categoria")
    private Categoria id_categoria;

    @OneToMany(mappedBy = "id_produto")
    @JsonIgnoreProperties("id_produto")
    private Produto id_produto;

    public Categoria getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(Categoria id_categoria) {
        this.id_categoria = id_categoria;
    }

    public Produto getId_produto() {
        return id_produto;
    }

    public void setId_produto(Produto id_produto) {
        this.id_produto = id_produto;
    }
}
