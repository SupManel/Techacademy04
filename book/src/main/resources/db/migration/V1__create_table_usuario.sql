create table usuario (
    id_usuario int not null primary key auto_increment,
    nome varchar(100),
    gmail varchar(100),
    senha varchar(30),
    cep varchar(8)
);