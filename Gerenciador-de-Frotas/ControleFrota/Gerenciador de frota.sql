create database Frotas;
use Frotas;

drop table empresa;

create table empresa(
codigo bigint(20) not null auto_increment primary key,
razaoSocial varchar(100),
nomeFantasia varchar(100),
CNPJ varchar(100),
endereco varchar(100),
numero varchar(100),
bairro varchar(100),
cep varchar(100),
muni_codigo varchar(100),
muni_uf varchar(100)
);



create table funcionarios(
codigo bigint(20) not null auto_increment primary key,
nome varchar(100),
CPF varchar(100),
RG varchar(100),
CTPS varchar(100),
DTNASC varchar(100),
endereco varchar(100),
endnumero varchar(100),
bairro varchar(100),
cep varchar(100),
muni_codigo varchar(100),
muni_uf varchar(100),
cargo varchar(100),
salario double,
dtadmissao datetime,
cargahoraria varchar(100),
banco varchar(100),
agencia varchar(100),
conta varchar(100),
datacad datetime
);

	
create table manutencao(
codigo bigint(20) not null auto_increment primary key,
descricao varchar(100),
tipo varchar(100),
marca varchar(100),
aplicacao varchar(100),
datacad datetime  
);

	
create table veiculos(
codigo bigint(20) not null auto_increment primary key,
renavam bigint(20),
marca varchar(100),
modelo varchar(100),
placa varchar(100),
motor varchar(100),
chassi varchar(100),
categoria varchar(100)
);
    
    drop table usuarios;
create table usuarios(
codigo bigint(20) not null auto_increment primary key,
nome varchar(100),
senha varchar(100),
usuario varchar(100),
datacad datetime
);   
use frotas;
insert into usuarios (nome, senha, usuario, datacad) values ('Administrador', 'admin', 'admin', now());
insert into usuarios (nome, senha, usuario, datacad) values('Bruno', 'bruno', '09021999', now());
insert into usuarios values('Administrador', 'admin', 'admin', now());
<<<<<<< HEAD
select * from usuarios;
=======
select * from usuarios;
>>>>>>> branch 'master' of https://github.com/BrunoGBranchi/Gerenciador-de-Frotas
