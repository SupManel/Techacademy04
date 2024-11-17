alter table itemPedido add constraint FK_itemPedido_produto
foreign key (id_produto) references produto(id_produto);