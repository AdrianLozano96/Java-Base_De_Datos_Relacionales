CREATE DATABASE IF NOT EXISTS Data_Access_SL;
USE Data_Access_SL
CREATE TABLE IF NOT EXISTS Proyecto (
	id	INTEGER NOT NULL AUTO_INCREMENT,
	nombre	VARCHAR(30),
	idJefe	INTEGER,
	presupuesto	DOUBLE,
	fechaInicio	DATE,
	fechaFin	DATE,
	tecnologias	TEXT,
	idRepositorio	INTEGER,
	idEquipo	INTEGER,
	PRIMARY KEY(id),
	FOREIGN KEY (idJefe) REFERENCES Programador(id),
	FOREIGN KEY (idRepositorio) REFERENCES Repositorio(id),
	FOREIGN KEY (idEquipo) REFERENCES Equipo(id)
);
CREATE TABLE IF NOT EXISTS Equipo (
	id	INTEGER NOT NULL AUTO_INCREMENT,
	idDepartamento	INTEGER NOT NULL,
	idProyecto	INTEGER NOT NULL,
	idProgramador	INTEGER NOT NULL,
	PRIMARY KEY(id),
	FOREIGN KEY (idDepartamento) REFERENCES Departamento(id),
	FOREIGN KEY (idProyecto) REFERENCES Proyecto(id),
	FOREIGN KEY (idProgramador) REFERENCES Programador(id)
);
CREATE TABLE IF NOT EXISTS Departamento (
	id	INTEGER NOT NULL AUTO_INCREMENT,
	nombre	VARCHAR(30),
	presupuesto	DOUBLE,
	idJefe	INTEGER NOT NULL,
	ProyectosTerminados	TEXT,
	ProyectosDesarrollo	TEXT,
	historicoJefes	TEXT,
	presupuestoAnual	DOUBLE,
	idEquipo	INTEGER NOT NULL,
	PRIMARY KEY(id),
	FOREIGN KEY (idJefe) REFERENCES Programador(id),
	FOREIGN KEY (idEquipo) REFERENCES Equipo(id)
);
CREATE TABLE IF NOT EXISTS Programador (
	id	INTEGER NOT NULL AUTO_INCREMENT,
	nombre	VARCHAR(30),
	fechaAlta	DATE,
	salario	DOUBLE,
	idDepartamento	INTEGER NOT NULL,
	idEquipo	INTEGER NOT NULL,
	idCorreo	INTEGER NOT NULL,
	tecnologias	TEXT,
	issues	TEXT,
	commits	TEXT,
	PRIMARY KEY(id),
	FOREIGN KEY (idDepartamento) REFERENCES Departamento(id),
	FOREIGN KEY (idEquipo) REFERENCES Equipo(id),
	FOREIGN KEY (idCorreo) REFERENCES Correo(id)
);
CREATE TABLE IF NOT EXISTS Repositorio (
	id	INTEGER NOT NULL AUTO_INCREMENT,
	nombre	VARCHAR(30),
	fechaCreacion	DATE,
	idProyecto	INTEGER NOT NULL,
	issues	TEXT,
	commits	TEXT,
	PRIMARY KEY(id),
	FOREIGN KEY (idProyecto) REFERENCES Proyecto(id)
);
CREATE TABLE IF NOT EXISTS Correo (
	id	INTEGER NOT NULL AUTO_INCREMENT,
	idIssue	INTEGER,
	idProgramador	INTEGER,
	PRIMARY KEY(id),
	FOREIGN KEY (idIssue) REFERENCES Issue(id),
	FOREIGN KEY (idProgramador) REFERENCES Programador(id)
);
CREATE TABLE IF NOT EXISTS Issue (
	id	INTEGER NOT NULL AUTO_INCREMENT,
	titulo	VARCHAR(30),
	texto	TEXT,
	fecha	DATE,
	idCommit	INTEGER NOT NULL,
	idCorreo	INTEGER NOT NULL,
	idRepositorio	INTEGER NOT NULL,
	terminado	BOOLEAN,
	PRIMARY KEY(id),
	FOREIGN KEY (idCommit) REFERENCES Commits(id),
	FOREIGN KEY (idCorreo) REFERENCES Correo(id),
	FOREIGN KEY (idRepositorio) REFERENCES Repositorio(id)
);
CREATE TABLE IF NOT EXISTS Commits (
	id	INTEGER NOT NULL AUTO_INCREMENT,
	titulo	VARCHAR(30),
	texto	TEXT,
	fecha	DATE,
	idRepositorio	INTEGER NOT NULL,
	idProgramador	INTEGER NOT NULL,
	idIssue	INTEGER NOT NULL,
	PRIMARY KEY(id),
	FOREIGN KEY (idRepositorio) REFERENCES Repositorio(id),
	FOREIGN KEY (idProgramador) REFERENCES Programador(id),
	FOREIGN KEY (idIssue) REFERENCES Issue(id)
);