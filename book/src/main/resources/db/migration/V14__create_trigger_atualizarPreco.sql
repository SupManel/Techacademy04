DELIMITER //

CREATE TRIGGER mudança_de_preco_automatica
    AFTER INSERT ON audit_preco_produto
    FOR EACH ROW
BEGIN
    UPDATE produto
    SET preco = NEW.preco_novo
    WHERE id_produto = NEW.id_produto;
END;

//

DELIMITER ;