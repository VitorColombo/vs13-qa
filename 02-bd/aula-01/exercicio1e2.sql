--DDL
CREATE TABLE VEM_SER.PESSOA(
	id_pessoa NUMBER NOT NULL,
	nome VARCHAR2(255) NOT NULL,
	data_nascimento DATE NOT NULL,
	telefone VARCHAR2(14), 
	idade NUMBER(3) NOT NULL,
	altura DECIMAL(4,2) NOT NULL,
	cpf CHAR(11) UNIQUE NOT NULL,
	PRIMARY KEY(id_pessoa)
 );
 
--DML
--INSERT
INSERT INTO VEM_SER.PESSOA (id_pessoa, nome, data_nascimento, telefone, idade, altura, cpf)
VALUES 
	(1, 'Robinsei', TO_DATE('1990-01-15', 'YYYY-MM-DD'), '123456789', 32, 1.75, '12345678901');

INSERT INTO VEM_SER.PESSOA (id_pessoa, nome, data_nascimento, telefone, idade, altura, cpf)
VALUES 
	(2, 'Josneidei', TO_DATE('1985-05-20', 'YYYY-MM-DD'), '987654321', 37, 1.65, '98765432102');

INSERT INTO VEM_SER.PESSOA (id_pessoa, nome, data_nascimento, telefone, idade, altura, cpf)
VALUES  
	(3, 'Carlitos', TO_DATE('2000-08-10', 'YYYY-MM-DD'), '555555555', 22, 1.80, '55555555503');

INSERT INTO VEM_SER.PESSOA (id_pessoa, nome, data_nascimento, telefone, idade, altura, cpf)
VALUES   
	(4, 'Ana', TO_DATE('1998-03-05', 'YYYY-MM-DD'), '111111111', 24, 1.70, '11111111104');
 
 SELECT * FROM VEM_SER.PESSOA;

UPDATE VEM_SER.PESSOA p
SET p.idade = p.idade+1;

DELETE FROM VEM_SER.PESSOA p
WHERE p.id_pessoa = (SELECT MAX(id_pessoa)FROM VEM_SER.PESSOA);

SELECT * FROM VEM_SER.PESSOA;


