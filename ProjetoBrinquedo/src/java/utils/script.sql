create database projeto_brinquedo;

-- Brinquedo = {codigoBrinquedo, nomeBrinquedo, codigomarca}
create table Brinquedo(
    codigoBrinquedo serial not null primary key,
    nomeBrinquedo varchar not null,
    codigomarca int not null references marca(codigomarca)    
);

create table Marca(
    codigoMarca serial not null primary key,
    nomeMarca varchar not null
);

create table usuario(
	codigoUsuario serial not null primary key,
	nomeUsuario varchar not null,
	senhaUsuario varchar not null,
	perfilUsuario varchar,
        statusUsuario boolean not null
);

insert into usuario(nomeUsuario, senhaUsuario, perfilUsuario, statusUsuario)
values('Germano', '123', '01', true);