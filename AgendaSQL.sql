CREATE DATABASE agenda;
USE agenda;

CREATE TABLE contato (
id INTEGER PRIMARY KEY auto_increment,
nome VARCHAR(50),
telefone VARCHAR(15),
email VARCHAR(60)
);

select * from contato;