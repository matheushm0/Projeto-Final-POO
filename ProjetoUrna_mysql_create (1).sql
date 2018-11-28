CREATE TABLE `Usuário` (
	`idUsuário` INT NOT NULL,
	`user` varchar(30) NOT NULL,
	`password` varchar(30) NOT NULL,
	PRIMARY KEY (`idUsuário`)
);

CREATE TABLE `Partido` (
	`idPartido` INT NOT NULL,
	`nome` varchar(150) NOT NULL,
	PRIMARY KEY (`idPartido`)
);

CREATE TABLE `Candidato` (
	`idCandidato` INT NOT NULL,
	`nome` varchar(150) NOT NULL,
	`num` int(6) NOT NULL,
	`votos` int,
	`idPartido` INT,
	PRIMARY KEY (`idCandidato`)
);

CREATE TABLE `Eleitor` (
	`idEleitor` INT NOT NULL,
	`nome` varchar(150) NOT NULL,
	`cpf` varchar(14) NOT NULL,
	`cep` varchar(8) NOT NULL,
	`Rua` varchar(100) NOT NULL,
	`Bairro` varchar(100) NOT NULL,
	`Número` varchar(100) NOT NULL,
	PRIMARY KEY (`idEleitor`)
);

ALTER TABLE `Candidato` ADD CONSTRAINT `Candidato_fk0` FOREIGN KEY (`idPartido`) REFERENCES `Partido`(`idPartido`);

