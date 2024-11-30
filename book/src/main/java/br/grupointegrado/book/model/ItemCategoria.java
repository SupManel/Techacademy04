package br.grupointegrado.book.model;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table (name = "itemcategoria")
public class ItemCategoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_itemCategoria;

    @ManyToOne
    @JoinColumn(name = "id_categoria", referencedColumnName = "id_categoria")
    private Categoria id_categoria;

    @ManyToOne
    @JoinColumn(name = "id_produto", referencedColumnName = "id_produto")
    private Produto id_produto;

    public Integer getId_itemCategoria() {
        return id_itemCategoria;
    }

    public void setId_itemCategoria(Integer id_itemCategoria) {
        this.id_itemCategoria = id_itemCategoria;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemCategoria that = (ItemCategoria) o;
        return Objects.equals(id_itemCategoria, that.id_itemCategoria);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id_itemCategoria);
    }
}
