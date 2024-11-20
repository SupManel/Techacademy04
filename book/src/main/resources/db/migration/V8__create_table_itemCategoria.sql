create table itemCategoria (
    id_categoria int,
    id_produto int,
    foreign key (id_produto) references produto(id_produto)
);
