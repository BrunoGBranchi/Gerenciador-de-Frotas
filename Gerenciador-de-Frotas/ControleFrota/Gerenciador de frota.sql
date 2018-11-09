create database Frotas;
use Frotas;

drop table empresa;

insert into empresa (razaoSocial, nomeFantasia, CNPJ, endereco, numero, bairro, cep, municipio, uf) values
('MGBTurismo', 'Topsul Viagens','12300','Rua Amazonas','253','Dos Esportes','89820000','Xanxere', 'SC');

create table empresa(
codigo bigint(20) not null auto_increment primary key,
razaoSocial varchar(100),
nomeFantasia varchar(100),
CNPJ varchar(100),
endereco varchar(100),
numero varchar(100),
bairro varchar(100),
cep varchar(100),
municipio varchar(100),
uf varchar(100)
);

update  empresa set razaoSocial = 'MGB',nomeFantasia = 'TPV',cnpj = '561465', endereco = 'AMz', numero = '253', bairro = 'esp',cep = '89',municipio = 'xxe',uf = 'SC' where codigo = 5;

select * from empresa;

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

	drop table veiculos;
create table veiculos(
codigo bigint(20) not null auto_increment primary key,
renavam bigint(20),
marca varchar(100),
modelo varchar(100),
placa varchar(100),
motor varchar(100),
chassi varchar(100),
categoria varchar(100),
datacad datetime
);

select * from veiculos;
delete from veiculos where codigo = 3;
insert into veiculos (renavam, marca, modelo, placa, motor, chassi, categoria) values(?,?,?,?,?,?,?);

drop table usuarios;
create table usuarios(
codigo bigint(20) not null auto_increment primary key,
nome varchar(100),
senha varchar(100),
usuario varchar(100),
datacad datetime
);   

insert into usuarios (nome, senha, usuario, datacad) values ('Administrador', 'admin', 'admin', now());
insert into usuarios (nome, senha, usuario, datacad) values('Bruno', 'bruno', '09021999', now());
insert into usuarios values('Administrador', 'admin', 'admin', now());
select * from usuarios;
select * from empresa ;