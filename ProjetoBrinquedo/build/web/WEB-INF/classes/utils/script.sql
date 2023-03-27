create database projeto_brinquedo;

-- Brinquedo = {codigoBrinquedo, nomeBrinquedo}
create table Brinquedo(
    codigoBrinquedo serial not null primary key,
    nomeBrinquedo varchar not null
);