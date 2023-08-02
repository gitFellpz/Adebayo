DROP SEQUENCE itens_sequence;
DROP TRIGGER tr_insert_id_itens;
DROP TABLE itens;


CREATE TABLE itens (
  id integer PRIMARY KEY NOT NULL,
  nome varchar(45) NOT NULL,
  quantidade NUMBER(10, 3) NOT NULL,
  preco NUMBER(10, 2) NOT NULL,
);

CREATE SEQUENCE itens_sequence START WITH 1 INCREMENT BY 1;

CREATE OR REPLACE TRIGGER tr_insert_id_itens
BEFORE INSERT ON ITENS FOR EACH ROW       
BEGIN
 
SELECT itens_sequence.NEXTVAL
INTO :NEW.id
FROM DUAL;
END;
/

COMMIT;