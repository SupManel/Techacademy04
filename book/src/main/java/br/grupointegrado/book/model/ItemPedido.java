package br.grupointegrado.book.model;


import jakarta.persistence.*;


import java.util.Objects;

@Entity
@Table (name = "itemPdido")
public class ItemPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_item;

    @Column
    private Integer quantidade_item;

    @Column
    private Float preco_unitario;

    @ManyToOne
    @JoinColumn(name = "id_pedido", referencedColumnName = "id_pedido")
    private Pedidos id_pedido;

    @ManyToOne
    @JoinColumn(name = "id_produto", referencedColumnName = "id_produto")
    private Produto id_produto;

    public Integer getId_item() {
        return id_item;
    }

    public void setId_item(Integer id_item) {
        this.id_item = id_item;
    }

    public Integer getQuantidade_item() {
        return quantidade_item;
    }

    public void setQuantidade_item(Integer quantidade_item) {
        this.quantidade_item = quantidade_item;
    }

    public Float getPreco_unitario() {
        return preco_unitario;
    }

    public void setPreco_unitario(Float preco_unitario) {
        this.preco_unitario = preco_unitario;
    }

    public Pedidos getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(Pedidos id_pedido) {
        this.id_pedido = id_pedido;
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
        ItemPedido that = (ItemPedido) o;
        return Objects.equals(id_item, that.id_item);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id_item);
    }
}
