create table pagamento (
    id_pagamento int not null primary key auto_increment,
    data_pagamento date,
    valor float,
    metodo Varchar(50),
    id_pedido int,
    foreign key (id_pedido) references pedido(id_pedido)
);