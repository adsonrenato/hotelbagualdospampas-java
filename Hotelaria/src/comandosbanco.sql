#criado por Cássio B. & Luis F. B.; create database hotelaria;

#use hotelaria;

create table Cliente(
	nome varchar(100) NOT NULL,
	cpf varchar(50) NOT NULL,
    email varchar(50) NOT NULL,
    telefone varchar(50) NOT NULL,
	endereco varchar(100) NOT NULL,
    cidade varchar(50) NOT NULL,
	primary key (cpf)
)default charset=latin1;

create table Quarto(
	numero varchar(100) NOT NULL,
    tipoQuarto varchar(100) NOT NULL,
    tipoCama varchar(100) NOT NULL,
    estadoAtual varchar(100) NOT NULL,
    descQuarto varchar(100) NOT NULL,
    preco real,
	primary key(numero)
)default charset=latin1;

create table ReservaQuarto(
	numero varchar(100) NOT NULL,
    dias int(10),
    preco real,
    nome varchar(100) NOT NULL,
    tipoQuarto varchar(100) NOT NULL,
    tipoCama varchar(100) NOT NULL,
	primary key(numero)
)default charset=latin1;
