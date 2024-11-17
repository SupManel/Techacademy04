create table produto (
    id_produto int not null primary key auto_increment,
    titulo varchar(100),
    descricao varchar(1000),
    autor varchar(50),
    preco float,
    estoque int,
    id_categoria int
);
