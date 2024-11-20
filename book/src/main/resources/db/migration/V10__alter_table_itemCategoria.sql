alter table itemCategoria add constraint Fk_itemCategoria_categoria
foreign key (id_categoria) references categoria(id_categoria);