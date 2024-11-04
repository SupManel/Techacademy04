create table pedido (
    id_pedido int not null primary key auto_increment,
    data date,
    total float,
    status varchar(50),
    preco float,
    id_usuario int,
    foreign key (id_usuario) references usuario(id_usuario)
);