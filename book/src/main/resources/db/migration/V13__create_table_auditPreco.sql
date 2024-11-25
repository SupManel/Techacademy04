CREATE TABLE audit_preco_produto (
    id_audit int auto_increment primary key,
    preco_anterior decimal(10, 2) not null,
    preco_novo decimal(10, 2) not null,
    data_alteracao timestamp default current_timestamp,
    motivo varchar(255),
    id_produto int,
    id_usuario int,
    FOREIGN KEY (id_produto) REFERENCES produto(id_produto),
    FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario)
);

DELIMITER //

CREATE PROCEDURE atualizar_preco_produto(
    IN p_id_produto INT,
    IN p_novo_preco DECIMAL(10, 2),
    IN p_id_usuario INT,
    IN p_motivo VARCHAR(255)
)
BEGIN
    DECLARE v_preco_anterior DECIMAL(10, 2);
    DECLARE v_existente INT;

    -- isso verifica se o produto existe
SELECT COUNT(*) INTO v_existente
FROM produtos
WHERE id_produto = p_id_produto;

IF v_existente = 0 THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Produto não encontrado';
ELSE
        -- esse aqui pega o preço anterior
SELECT preco INTO v_preco_anterior
FROM produtos
WHERE id_produto = p_id_produto;

-- esse ve se o preço novo é diferente do anterior
IF v_preco_anterior <> p_novo_preco THEN
            -- dai aqui atualiza o preço do produto
UPDATE produtos
SET preco = p_novo_preco
WHERE id_produto = p_id_produto;

-- esse aqui insere no audit as mudança
INSERT INTO audit_preco_produto (preco_anterior, preco_novo, motivo, id_produto, id_usuario)
VALUES (v_preco_anterior, p_novo_preco, p_motivo, p_id_produto, p_id_usuario);
END IF;
END IF;
END //

DELIMITER ;