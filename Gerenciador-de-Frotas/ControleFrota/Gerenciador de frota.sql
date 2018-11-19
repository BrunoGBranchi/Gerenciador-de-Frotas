create database Frotas;
use Frotas;

drop database frotas;

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
municipio varchar(100),
uf varchar(100),
cargo varchar(100),
salario double,
dtadmissao datetime,
cargahoraria varchar(100),
banco varchar(100),
agencia varchar(100),
conta varchar(100),
datacad datetime
);

drop table funcionarios;

insert into funcionarios (nome, CPF, RG, CTPS, DTNASC, endereco, bairro, cep, municipio, uf, cargo, salario, dtadmissao, cargahoraria, canco, agencia, conta, datacad) values (?,?,?,?,?,?,?,?,?);

insert into funcionarios (nome) values ('teste');
delete from funcionarios where codigo =1;
select * from funcionarios;
	
create table manutencao(
codigo bigint(20) not null auto_increment primary key,
descricao varchar(100),
valor double,
tipo varchar(100),
marca varchar(100),
aplicacao varchar(100),
datacad datetime,
cod_veiculo bigint(20),

foreign key (cod_veiculo) references veiculos(codigo)
);

select * from manutencao;

drop table manutencao;

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
insert into veiculos (renavam, marca, modelo, placa, motor, chassi, categoria,datacad) values(1,'Chevrolet','azul','12A1S3','280 cavalos','não sei','chata',now());

drop table usuarios;
create table usuarios(
codigo bigint(20) not null auto_increment primary key,
nome varchar(100),
senha varchar(100),
usuario varchar(100),
datacad datetime
);

create view view_manutencao_nome as
	select m.codigo as codigo, m.descricao as descricao, m.tipo as tipo, m.marca as marca, m.aplicacao as aplicacao, m.datacad as datacad, m.valor as valor, 
		v.modelo as nomeveiculo, m.cod_veiculo as codVeic
			from manutencao m join veiculos v on m.cod_veiculo = v.codigo;

drop view view_manutencao_nome;

select * from view_manutencao_nome;

create table movimentos(
codigo bigint(20) not null auto_increment primary key,
observacao varchar(100),
valor double,
cod_manutencao bigint(20),
numeronota bigint(20),
veickm bigint(20),
datamvto datetime,
datanota datetime,
cod_veiculo bigint,

foreign key (cod_veiculo) references veiculos(codigo),
foreign key (cod_manutencao) references manutencao(codigo)
);
drop table movimentos;

insert into movimentos (observacao, valor, cod_manutencao, numeronota, veickm, datamvto, datanota, cod_veiculo) values (?,?,?,?,?,?,?,?);
update movimentos set observacao=?, valor=?, cod_manutencao=?, numeronota=?, veickm=?, datamvto=?, datanota=?, cod_veiculo=? where codigo=?;

drop view view_movimento_nome;

create view view_movimento_nome as
	select m.codigo as codigo, m.observacao as observacao, m.valor as valor, m.cod_manutencao as CodManu, m.numeronota as NumNota, m.veickm as KM, m.datamvto as datamvto, 
		m.datanota as datanota, m.cod_veiculo as codVeic, m.quantidade as quantidade
			from movimentos m join veiculos v on m.cod_veiculo = v.codigo
				join manutencao man on m.cod_manutencao = man.codigo;
                
select * from view_movimento_nome;

delimiter $
create trigger cria_Movimento after insert on manutencao for each row
begin 
    
insert into movimentos(observacao,valor,cod_manutencao,numeronota,veickm,datamvto,datanota,cod_veiculo) 
values(new.descricao,new.valor,new.codigo,0,new.km,now(),now(),new.cod_veiculo);    
    


end$
delimiter ;

drop trigger cria_Movimento;

create table manutencao(
codigo bigint(20) not null auto_increment primary key,
descricao varchar(100),
valor double,
tipo varchar(100),
marca varchar(100),
aplicacao varchar(100),
datacad datetime,
cod_veiculo bigint(20),
km integer,
foreign key (cod_veiculo) references veiculos(codigo)
);

drop table movimentos;
drop table manutencao;
drop table veiculos;

select*from movimentos;

select*from manutencao;

insert into manutencao(descricao,valor,tipo,marca,aplicacao,datacad,cod_veiculo) values('XD',100.00,'cara','Chevrolet','rapida',now(),1);





	create view view_manutencao_nome as
	select m.codigo as codigo, m.descricao as descricao, m.tipo as tipo, m.marca as marca, m.aplicacao as aplicacao, m.datacad as datacad, m.valor as valor, 
		v.modelo as nomeveiculo, m.cod_veiculo as codVeic
			from manutencao m join veiculos v on m.cod_veiculo = v.codigo;
 
 
 
 select * from view_manutencao_nome;
 
 
 
 
update movimentos set observacao=?, valor=?, cod_manutencao=?, numeronota=?, veickm=?, datamvto=?, datanota=?, cod_veiculo=? where codigo=?;

 
 
 
 insert into usuarios (nome, senha, usuario, datacad) values ('Administrador', 'admin', 'admin', now());
 
 create view view_movimento_nome as select m.codigo as codigo, m.observacao as observacao, m.valor as valor, m.cod_manutencao as CodManu,
 m.numeronota as NumNota, m.veickm as KM, m.datamvto as datamvto,m.datanota as 
 datanota, m.cod_veiculo as codVeic from movimentos m join veiculos v 
 on m.cod_veiculo = v.codigo
 join manutencao man on m.cod_manutencao = man.codigo;
 
 
insert into movimentos (observacao, valor, cod_manutencao, numeronota, veickm, datamvto, datanota, cod_veiculo) values (?,?,?,?,?,?,?,?);
insert into usuarios (nome, senha, usuario, datacad) values('Bruno', 'bruno', '09021999', now());
insert into usuarios values('Administrador', 'admin', 'admin', now());			
update movimentos set observacao=?, valor=?, cod_manutencao=?, numeronota=?, veickm=?, datamvto=?, datanota=?, cod_veiculo=? where codigo=?;


select * from usuarios;				
select * from empresa ; 					
                
select * from view_movimento_nome; 

drop view view_movimento_nome;
drop view view_manutencao_nome;


    -- modifiquei a tabela movimento e manutenção com campo km e remoção do campo quantidade