CREATE TABLE VEM_SER.PAIS(
    id_pais INT PRIMARY KEY NOT NULL,
    nome VARCHAR2(50) UNIQUE NOT NULL
);

CREATE TABLE VEM_SER.ESTADO(
    id_estado INT PRIMARY KEY NOT NULL,
    id_pais INT NOT NULL,
    nome VARCHAR2(50) UNIQUE NOT NULL,
    CONSTRAINT FK_ESTADO_ID_PAIS FOREIGN KEY ( id_pais ) REFERENCES VEM_SER.PAIS( id_pais )
);


CREATE TABLE VEM_SER.CIDADE(
	id_cidade INT NOT NULL,
	id_estado INT NOT NULL,
	nome VARCHAR2(50) NOT NULL,
	CONSTRAINT PK_CIDADE PRIMARY KEY(id_cidade, id_estado),
	CONSTRAINT FK_CIDADE_ID_ESTADO FOREIGN KEY (id_estado) REFERENCES VEM_SER.ESTADO (id_estado)
);

	
CREATE TABLE VEM_SER.BAIRRO(
    id_bairro INT NOT NULL,
    id_cidade INT NOT NULL,
    id_estado INT NOT NULL,
    nome VARCHAR2(50) NOT NULL,
    CONSTRAINT PK_BAIRRO PRIMARY KEY(id_bairro, id_cidade),
    CONSTRAINT FK_BAIRRO_ID_CIDADE FOREIGN KEY (id_cidade, id_estado) REFERENCES VEM_SER.CIDADE (id_cidade, id_estado)
);


CREATE TABLE VEM_SER.ENDERECO(
	id_endereco INT NOT NULL,
    id_bairro INT NOT NULL,
    id_cidade INT NOT NULL,
    logradouro VARCHAR2(255) NOT NULL,
    numero INT NOT NULL,
    complemento VARCHAR2(100),
    cep CHAR(9),
	CONSTRAINT PK_ENDERECO PRIMARY KEY(id_endereco),
    CONSTRAINT FK_ENDERECO_ID_BAIRRO FOREIGN KEY (id_bairro, id_cidade) REFERENCES VEM_SER.BAIRRO (id_bairro, id_cidade)
);


--PAISES
INSERT INTO VEM_SER.PAIS (id_pais, nome) VALUES (1, 'BRASIL');

INSERT INTO VEM_SER.PAIS (id_pais, nome) VALUES (2, 'ARGENTINA');

--ESTADOS
INSERT INTO VEM_SER.ESTADO (id_estado, id_pais, nome) VALUES (1, 1, 'Sao Paulo');
INSERT INTO VEM_SER.ESTADO (id_estado, id_pais, nome) VALUES (2, 1, 'Rio de Janeiro');

INSERT INTO VEM_SER.ESTADO (id_estado, id_pais, nome) VALUES (3, 2, 'Buenos Aires');
INSERT INTO VEM_SER.ESTADO (id_estado, id_pais, nome) VALUES (4, 2, 'Cordoba');

--CIDADES
INSERT INTO VEM_SER.CIDADE (id_cidade, id_estado, nome) VALUES (1, 1, 'Sao Paulo');
INSERT INTO VEM_SER.CIDADE (id_cidade, id_estado, nome) VALUES (2, 1, 'Campinas');

INSERT INTO VEM_SER.CIDADE (id_cidade, id_estado, nome) VALUES (3, 2, 'Rio de Janeiro');
INSERT INTO VEM_SER.CIDADE (id_cidade, id_estado, nome) VALUES (4, 2, 'Niteroi');

INSERT INTO VEM_SER.CIDADE (id_cidade, id_estado, nome) VALUES (5, 3, 'Buenos Aires');
INSERT INTO VEM_SER.CIDADE (id_cidade, id_estado, nome) VALUES (6, 3, 'La Plata');

INSERT INTO VEM_SER.CIDADE (id_cidade, id_estado, nome) VALUES (7, 4, 'Cordoba');
INSERT INTO VEM_SER.CIDADE (id_cidade, id_estado, nome) VALUES (8, 4, 'Rosario');

--BAIRROS
INSERT INTO VEM_SER.BAIRRO (id_bairro, id_cidade, id_estado, nome) VALUES (1, 1, 1, 'Bairro A');
INSERT INTO VEM_SER.BAIRRO (id_bairro, id_cidade, id_estado, nome) VALUES (2, 1, 1, 'Bairro B');

INSERT INTO VEM_SER.BAIRRO (id_bairro, id_cidade, id_estado, nome) VALUES (3, 2, 1, 'Bairro C');
INSERT INTO VEM_SER.BAIRRO (id_bairro, id_cidade, id_estado, nome) VALUES (4, 2, 1, 'Bairro D');

INSERT INTO VEM_SER.BAIRRO (id_bairro, id_cidade, id_estado, nome) VALUES (5, 3, 2, 'Bairro E');
INSERT INTO VEM_SER.BAIRRO (id_bairro, id_cidade, id_estado, nome) VALUES (6, 3, 2, 'Bairro F');

INSERT INTO VEM_SER.BAIRRO (id_bairro, id_cidade, id_estado, nome) VALUES (7, 4, 2, 'Bairro G');
INSERT INTO VEM_SER.BAIRRO (id_bairro, id_cidade, id_estado, nome) VALUES (8, 4, 2, 'Bairro H');

INSERT INTO VEM_SER.BAIRRO (id_bairro, id_cidade, id_estado, nome) VALUES (9, 5, 3, 'Bairro I');
INSERT INTO VEM_SER.BAIRRO (id_bairro, id_cidade, id_estado, nome) VALUES (10, 5, 3, 'Bairro J');

INSERT INTO VEM_SER.BAIRRO (id_bairro, id_cidade, id_estado, nome) VALUES (11, 6, 3, 'Bairro K');
INSERT INTO VEM_SER.BAIRRO (id_bairro, id_cidade, id_estado, nome) VALUES (12, 6, 3, 'Bairro L');

INSERT INTO VEM_SER.BAIRRO (id_bairro, id_cidade, id_estado, nome) VALUES (13, 7, 4, 'Bairro M');
INSERT INTO VEM_SER.BAIRRO (id_bairro, id_cidade, id_estado, nome) VALUES (14, 7, 4, 'Bairro N');

INSERT INTO VEM_SER.BAIRRO (id_bairro, id_cidade, id_estado, nome) VALUES (15, 8, 4, 'Bairro O');
INSERT INTO VEM_SER.BAIRRO (id_bairro, id_cidade, id_estado, nome) VALUES (16, 8, 4, 'Bairro P');

--ENDERECOS
INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep) VALUES (1, 1, 1, 'Rua A', 10, 'apartamento 1', '12345-678');
INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep) VALUES (2, 1, 1, 'Rua B', 20, 'casa 2', '98765-432');

INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep) VALUES (3, 2, 1, 'Avenida X', 303, 'casa 3', '54321-987');
INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep) VALUES (4, 2, 1, 'Rua Y', 100, '4 piso', '87654-321');

INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep) VALUES (5, 3, 2, 'Avenida Z', 505, 'apto 5', '13579-246');
INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep) VALUES (6, 3, 2, 'Rua W', 606, NULL, '98712-345');

INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep) VALUES (7, 4, 2, 'Calle P', 707, 'Loft 7', '56789-012');
INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep) VALUES (8, 4, 2, 'Avenida Q', 808, 'casa 8', '10987-654');

INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep) VALUES (9, 5, 3, 'Calle R', 909, 'apartamento 9', '76543-210');
INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep) VALUES (10, 5, 3, 'Avenida S', 1010, NULL, '23456-789');

INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep) VALUES (11, 6, 3, 'Calle T', 1111, 'apto 11', '87654-321');
INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep) VALUES (12, 6, 3, 'Avenida U', 1212, NULL, '54321-098');

INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep) VALUES (13, 7, 4, 'Calle V', 1313, 'Bloco B', '56789-012');
INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep) VALUES (14, 7, 4, 'Avenida X', 1414, 'sala 14', '21098-765');

INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep) VALUES (15, 8, 4, 'Calle Y', 1515, '15 andar', '54321-098');
INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep) VALUES (16, 8, 4, 'Avenida Z', 1616, 'apto 16', '87654-321');

INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep) VALUES (17, 9, 5, 'Calle A', 1717, NULL, '54321-098');
INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep) VALUES (18, 9, 5, 'Avenida B', 1818, 'sala 18', '21098-765');

INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep) VALUES (19, 10, 5, 'Calle C', 1919, 'casa 19', '54321-098');
INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep) VALUES (20, 10, 5, 'Avenida D', 2020, 'apt 20', '87654-321');

INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep) VALUES (21, 11, 6, 'Calle E', 2121, 'cobertura', '54321-098');
INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep) VALUES (22, 11, 6, 'Avenida F', 2222, '12 piso', '21098-765');

INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep) VALUES (23, 12, 6, 'calle G', 2323, 'residencial camelias', '54321-098');
INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep) VALUES (24, 12, 6, 'avenida H', 2424, 'sala 4', '21098-765');

INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep) VALUES (25, 13, 7, 'Calle I', 2525, 'Bloco C', '54321-098');
INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep) VALUES (26, 13, 7, 'Avenida J', 2626, 'Bloco a', '21098-765');

INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep) VALUES (27, 14, 7, 'Calle K', 2727, 'casa 9', '54321-098');
INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep) VALUES (28, 14, 7, 'Avenida L', 2828, 'apto 28', '21098-765');

INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep) VALUES (29, 15, 8, 'Calle M', 2929, 'Penthouse 29', '54321-098');
INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep) VALUES (30, 15, 8, 'Avenida N', 3030, 'Floor 30', '21098-765');

INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep) VALUES (31, 16, 8, 'Calle O', 3131, 'Residencial Brito', '54321-098');
INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep) VALUES (32, 16, 8, 'Avenida P', 3232, 'sala 32', '21098-765');


SELECT * FROM VEM_SER.ENDERECO


