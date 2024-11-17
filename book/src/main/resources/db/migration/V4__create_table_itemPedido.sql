create table itemPedido (
    id_item int not null primary key auto_increment,
    quantidade_item int,
    preco_unitario float,
    id_pedido int,
    id_produto int,
    foreign key (id_pedido) references pedido(id_pedido)
);
