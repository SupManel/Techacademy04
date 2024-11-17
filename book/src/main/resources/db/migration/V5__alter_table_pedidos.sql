alter table pedido add id_item int;

alter table pedido add constraint Fk_pedido_itemPedido
foreign key (id_item) references itemPedido(id_item);