CREATE TABLE VEM_SER.ESTUDANTE (
    id_estudante NUMBER NOT NULL,
    nome VARCHAR(200) NOT NULL,
    data_nascimento DATE NOT NULL,
    nr_matricula NUMBER(10) UNIQUE NOT NULL,
    ativo CHAR(1) NOT NULL CHECK (ativo IN ('S', 'N')),
    PRIMARY KEY (id_estudante)
);


CREATE SEQUENCE VEM_SER.SEQ_ESTUDANTE
START WITH 0
INCREMENT BY 1
NOCACHE 
NOCYCLE;


INSERT INTO VEM_SER.ESTUDANTE (id_estudante, nome, data_nascimento, nr_matricula, ativo)
VALUES
    (VEM_SER.SEQ_ESTUDANTE.NEXTVAL, 'Letícia Gonçalves', TO_DATE('06-10-1996', 'DD-MM-YYYY'), 1234567890, 'S');

INSERT INTO VEM_SER.ESTUDANTE (id_estudante, nome, data_nascimento, nr_matricula, ativo)
VALUES
    (VEM_SER.SEQ_ESTUDANTE.NEXTVAL, 'Vitor Colombo', TO_DATE('20-06-1996', 'DD-MM-YYYY'), 1231231231, 'S');

INSERT INTO VEM_SER.ESTUDANTE (id_estudante, nome, data_nascimento, nr_matricula, ativo)
VALUES
    (VEM_SER.SEQ_ESTUDANTE.NEXTVAL, 'Pedrique Santos', TO_DATE('10-06-2000', 'DD-MM-YYYY'), 1234234666, 'N');

INSERT INTO VEM_SER.ESTUDANTE (id_estudante, nome, data_nascimento, nr_matricula, ativo)
VALUES	
    (VEM_SER.SEQ_ESTUDANTE.NEXTVAL, 'Pedro Bell', TO_DATE('01-06-2000', 'DD-MM-YYYY'), 6545627890, 'S');

INSERT INTO VEM_SER.ESTUDANTE (id_estudante, nome, data_nascimento, nr_matricula, ativo)
VALUES
    (VEM_SER.SEQ_ESTUDANTE.NEXTVAL, 'Heloisa Nunes', TO_DATE('12-10-1980', 'DD-MM-YYYY'), 3567823234, 'S');

INSERT INTO VEM_SER.ESTUDANTE (id_estudante, nome, data_nascimento, nr_matricula, ativo)
VALUES
    (VEM_SER.SEQ_ESTUDANTE.NEXTVAL, 'Olinda Colombo', TO_DATE('01-12-1973', 'DD-MM-YYYY'), 7947467810, 'S');

INSERT INTO VEM_SER.ESTUDANTE (id_estudante, nome, data_nascimento, nr_matricula, ativo)
VALUES
    (VEM_SER.SEQ_ESTUDANTE.NEXTVAL, 'Melissa Nunes', TO_DATE('10-11-1989', 'DD-MM-YYYY'), 1074567840, 'N');

INSERT INTO VEM_SER.ESTUDANTE (id_estudante, nome, data_nascimento, nr_matricula, ativo)
VALUES
    (VEM_SER.SEQ_ESTUDANTE.NEXTVAL, 'Grego Roberto', TO_DATE('05-01-2019', 'DD-MM-YYYY'), 9939567866, 'N');

INSERT INTO VEM_SER.ESTUDANTE (id_estudante, nome, data_nascimento, nr_matricula, ativo)
VALUES
    (VEM_SER.SEQ_ESTUDANTE.NEXTVAL, 'Lorival Roberto Jr.', TO_DATE('03-02-1995', 'DD-MM-YYYY'), 9867567877, 'S');

INSERT INTO VEM_SER.ESTUDANTE (id_estudante, nome, data_nascimento, nr_matricula, ativo)
VALUES
    (VEM_SER.SEQ_ESTUDANTE.NEXTVAL, 'Josinelson Advincula', TO_DATE('10-09-1940', 'DD-MM-YYYY'), 1236547890, 'S');


SELECT * FROM VEM_SER.ESTUDANTE;


