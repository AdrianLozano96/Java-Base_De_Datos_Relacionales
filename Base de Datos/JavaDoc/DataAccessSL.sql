CREATE TABLE prueba( id INTEGER );
DROP TABLE departamento;
CREATE TABLE departamento
(
    idDepartamento       VARCHAR(36) PRIMARY KEY ON CONFLICT ROLLBACK
        NOT NULL
        UNIQUE,
    nombreDepartamento   VARCHAR(100) NOT NULL,
    presupuesto          DOUBLE       NOT NULL,
    historialJefes       TEXT,
    proyectosFinalizados TEXT
);
DROP TABLE proyecto;
CREATE TABLE proyecto
(
    idProyecto     VARCHAR(36) PRIMARY KEY ON CONFLICT ROLLBACK
        UNIQUE
        NOT NULL,
    nombreProyecto VARCHAR(100) NOT NULL,
    fechaAlta      DATETIME     NOT NULL,
    salario        DOUBLE       NOT NULL,
    tecnologias    TEXT         NOT NULL,
    fechaFin       DATETIME     NOT NULL
);
DROP TABLE programador;
CREATE TABLE programador
(
    idProgramador     VARCHAR(36) PRIMARY KEY ON CONFLICT ROLLBACK
        UNIQUE
        NOT NULL,
    nombreProgramador VARCHAR(100) NOT NULL,
    fechaAlta         DATETIME     NOT NULL,
    salario           DOUBLE       NOT NULL,
    tecnologias       TEXT         NOT NULL
);
DROP TABLE tdepproy;
CREATE TABLE tdepproy
(
    idDepartamento VARCHAR(36) REFERENCES departamento (idDepartamento) MATCH SIMPLE
                               NOT NULL,
    idProyecto     VARCHAR(36) NOT NULL
        REFERENCES proyecto (idProyecto) MATCH SIMPLE
);
DROP TABLE equipo;
CREATE TABLE equipo
(
    idDepartamento VARCHAR(36) REFERENCES departamento (idDepartamento) MATCH SIMPLE
        NOT NULL,
    idProyecto     VARCHAR(36) REFERENCES proyecto (idProyecto) MATCH SIMPLE
        NOT NULL,
    idProgramador  VARCHAR(36) REFERENCES programador (idProgramador) MATCH SIMPLE
        NOT NULL
);
DROP TABLE jefedepartamento;
CREATE TABLE jefedepartamento
(
    idDepartamento VARCHAR(36) REFERENCES departamento (idDepartamento) MATCH SIMPLE
        NOT NULL,
    idProgramador  VARCHAR(36) REFERENCES programador (idProgramador) MATCH SIMPLE
        NOT NULL
);
DROP TABLE jefeproyecto;
CREATE TABLE jefeproyecto
(
    idProyecto    VARCHAR(36) NOT NULL
        REFERENCES proyecto (idProyecto) MATCH SIMPLE,
    idProgramador VARCHAR(36) REFERENCES programador (idProgramador) MATCH SIMPLE
                              NOT NULL
);
DROP TABLE repositorio;
CREATE TABLE repositorio
(
    idRepositorio     VARCHAR(36)  NOT NULL
        PRIMARY KEY ON CONFLICT ROLLBACK
        UNIQUE,
    nombreRepositorio VARCHAR(100) NOT NULL,
    fechaCreacion     DATETIME     NOT NULL,
    idProyecto        VARCHAR(36) REFERENCES proyecto (idProyecto) MATCH SIMPLE
                                   NOT NULL
);
DROP TABLE issue;
CREATE TABLE issue
(
    idIssue       VARCHAR(36) PRIMARY KEY ON CONFLICT ROLLBACK
        UNIQUE
        NOT NULL,
    titulo        VARCHAR(100) NOT NULL,
    texto         TEXT         NOT NULL,
    fecha         DATETIME     NOT NULL,
    estado        BOOLEAN      NOT NULL,
    idRepositorio VARCHAR(36) REFERENCES repositorio (idRepositorio) MATCH SIMPLE
                               NOT NULL
);
DROP TABLE correo;
CREATE TABLE correo
(
    idProgramador VARCHAR(36) REFERENCES programador (idProgramador) MATCH SIMPLE
        NOT NULL,
    idIssue       VARCHAR(36) REFERENCES issue (idIssue) MATCH SIMPLE
        NOT NULL
);
DROP TABLE commits;
CREATE TABLE commits
(
    idCommit      VARCHAR(36) PRIMARY KEY ON CONFLICT ROLLBACK
        UNIQUE
        NOT NULL,
    titulo        VARCHAR(100) NOT NULL,
    texto         TEXT         NOT NULL,
    fecha         DATETIME     NOT NULL,
    idRepositorio VARCHAR(36) REFERENCES repositorio (idRepositorio) MATCH SIMPLE
                               NOT NULL,
    idIssue       VARCHAR(36) REFERENCES issue (idIssue) MATCH SIMPLE
                               NOT NULL,
    idProgramador VARCHAR(36) REFERENCES programador (idProgramador) MATCH SIMPLE
                               NOT NULL
);
INSERT INTO departamento (idDepartamento, nombreDepartamento, presupuesto, historialJefes, proyectosFinalizados)
VALUES ('87450331-42b6-4e07-94be-2f13e7e79a0d', 'test', 100000.0, null, null),
       ('abb8f224-b146-4d2f-8fec-fa7f1e30bd21', 'diseño', 200000.0, null, null),
       ('11c288db-01f4-48fe-8b2c-1192a2fd38a0', 'código', 150000.0, null, null);
INSERT INTO proyecto (idProyecto, nombreProyecto, fechaAlta, salario, tecnologias, fechaFin)
VALUES ('e4c972f7-3f60-44c0-921e-135359b592ca', 'diseño código', '2020-9-12 8:30:00', 175000.0, 'patrones_de_diseño',
        '2021-5-15 00:00:00'),
       ('b93746df-9350-4811-ba07-0dc72ce626bd', 'código fuente', '2020-10-20 8:05:10', 125000.0,
        'java kotlin python javascript', '2021-5-15 00:00:00'),
       ('a26d5377-69c3-4192-a7b0-59049d7624cd', 'junit testing', '2021-2-10 9:32:30', 100000.0, 'junit5 junit4',
        '2021-5-15 00:00:00'),
       ('ed6cbf91-027a-4a94-a401-2702228cbe7b', 'comprobación diseño', '2020-10-5 10:20:40', 25000.0,
        'patrones_de_diseño lenguajes_varios', '2021-5-15 00:00:00');
INSERT INTO tdepproy (idDepartamento, idProyecto)
VALUES ('abb8f224-b146-4d2f-8fec-fa7f1e30bd21', 'e4c972f7-3f60-44c0-921e-135359b592ca'),
       ('abb8f224-b146-4d2f-8fec-fa7f1e30bd21', 'ed6cbf91-027a-4a94-a401-2702228cbe7b'),
       ('11c288db-01f4-48fe-8b2c-1192a2fd38a0', 'b93746df-9350-4811-ba07-0dc72ce626bd'),
       ('87450331-42b6-4e07-94be-2f13e7e79a0d', 'a26d5377-69c3-4192-a7b0-59049d7624cd');
INSERT INTO programador (idProgramador, nombreProgramador, fechaAlta, salario, tecnologias)
VALUES ('df41a833-f174-43d8-913c-dfed9b8f6f43', 'Pepe', '2020-9-14 9:20:50', 20000.0, 'patron_diseño'),
       ('57f981e3-10f3-4bb8-a587-dcc49b5d69e5', 'Juan', '2020-10-6 11:30:10', 20000.0, 'patron_diseño'),
       ('12623d55-4d60-4250-a020-9ff4a86b6db1', 'Emilio', '2020-10-7 10:45:15', 75000.0,
        'java kotlin python javascript'),
       ('5f8d030e-a25b-44bb-9f18-f6af314cf599', 'Adri', '2021-2-10 9:32:30', 75000.0, 'junit5 junit4'),
       ('9457c5ba-5162-44c2-a95c-736ad8139007', 'Fran', '2020-10-22 10:45:20', 20000.0, 'kotlin python'),
       ('5974b34a-eada-4608-95aa-9c5a8d110146', 'Ivan', '2021-2-11 8:20:30', 20000.0, 'junit5'),
       ('ba22aa37-931c-461a-8cf0-18c5f0324284', 'Jordi', '2020-9-9 8:20:50', 75000.0, 'patrones_diseño'),
       ('253f6b98-9d48-41ee-906f-3ca0862dff00', 'Dani', '2020-10-1 13:20:30', 20000.0, 'patrones_diseño'),
       ('44506873-9853-475c-82af-c5acbd9c050a', 'Natalia', '2020-9-7 10:40:50', 75000.0, 'patrones_diseño'),
       ('c49db69e-79d6-46f8-afbd-684c0b853deb', 'Claudia', '2020-10-1 9:20:50', 75000.0, 'eficiencia_codigo'),
       ('8719684c-1ca7-4511-a11d-83ab4653ca4d', 'Lucia', '2021-2-5 12:15:20', 50000.0, 'patrones_testing');
INSERT INTO equipo (idDepartamento, idProyecto, idProgramador)
VALUES ('abb8f224-b146-4d2f-8fec-fa7f1e30bd21', 'e4c972f7-3f60-44c0-921e-135359b592ca',
        'df41a833-f174-43d8-913c-dfed9b8f6f43'),
       ('abb8f224-b146-4d2f-8fec-fa7f1e30bd21', 'ed6cbf91-027a-4a94-a401-2702228cbe7b',
        '57f981e3-10f3-4bb8-a587-dcc49b5d69e5'),
       ('11c288db-01f4-48fe-8b2c-1192a2fd38a0', 'b93746df-9350-4811-ba07-0dc72ce626bd',
        '9457c5ba-5162-44c2-a95c-736ad8139007'),
       ('87450331-42b6-4e07-94be-2f13e7e79a0d', 'a26d5377-69c3-4192-a7b0-59049d7624cd',
        '5974b34a-eada-4608-95aa-9c5a8d110146');
INSERT INTO jefedepartamento (idDepartamento, idProgramador)
VALUES ('abb8f224-b146-4d2f-8fec-fa7f1e30bd21', '44506873-9853-475c-82af-c5acbd9c050a'),
       ('11c288db-01f4-48fe-8b2c-1192a2fd38a0', 'c49db69e-79d6-46f8-afbd-684c0b853deb'),
       ('87450331-42b6-4e07-94be-2f13e7e79a0d', '8719684c-1ca7-4511-a11d-83ab4653ca4d');
INSERT INTO jefeproyecto (idProyecto, idProgramador)
VALUES ('e4c972f7-3f60-44c0-921e-135359b592ca', 'ba22aa37-931c-461a-8cf0-18c5f0324284'),
       ('b93746df-9350-4811-ba07-0dc72ce626bd', '12623d55-4d60-4250-a020-9ff4a86b6db1'),
       ('a26d5377-69c3-4192-a7b0-59049d7624cd', '5f8d030e-a25b-44bb-9f18-f6af314cf599'),
       ('ed6cbf91-027a-4a94-a401-2702228cbe7b', '253f6b98-9d48-41ee-906f-3ca0862dff00');
INSERT INTO repositorio (idRepositorio, nombreRepositorio, fechaCreacion, idProyecto)
VALUES ('98076dba-86b5-4b70-add8-22f3dd0b8cf6', 'Repositorio Diseño Código', '2020-9-12 10:20:00',
        'e4c972f7-3f60-44c0-921e-135359b592ca'),
       ('4fc07fa3-9a00-49f9-a68a-ed6971f50337', 'Repositorio Código Fuente', '2020-10-20 9:25:10',
        'b93746df-9350-4811-ba07-0dc72ce626bd'),
       ('022d0ce6-7b97-485d-8e7d-9e99b4bc38ef', 'Repositorio Testing', '2021-2-10 11:40:30',
        'a26d5377-69c3-4192-a7b0-59049d7624cd'),
       ('812cbf8f-7dca-4292-b705-3ecca7172e37', 'Repositorio Comprobación Diseño', '2020-10-5 13:10:50',
        'ed6cbf91-027a-4a94-a401-2702228cbe7b');