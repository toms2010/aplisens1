create database if not exists aplisens;

use aplisens;

drop table if exists produkty;
drop table if exists parametry_sg;
drop table if exists parametry_pc;
drop table if exists wykonania_PC;

create table produkty
(
id_pr int NOT NULL AUTO_INCREMENT,
tag varchar(5),
nazwa varchar(50),
opis varchar(100),
dok_opis varchar(200),
cena decimal(10,2),
PRIMARY KEY (`id_pr`)
);

insert into produkty (tag, nazwa, opis, cena, dok_opis) values ('PC' , 'PC28', 'Przetworniki ciśnienia', 860, 'Standardowy przetwornik ciśnienia');
insert into produkty (tag, nazwa, opis, cena, dok_opis) values ('PC' , 'PC50', 'Przetworniki ciśnienia', 1200, 'Standardowy przetwornik ciśnienia');
insert into produkty (tag, nazwa, opis, cena, dok_opis) values ('SG' , 'SG25', 'Hydrostatyczne sondy głębokości', 1300, 'Standardowy przetwornik ciśnienia');
insert into produkty (tag, nazwa, opis, cena, dok_opis) values ('SG' , 'SG25', 'Hydrostatyczne sondy głębokości', 1500, 'Standardowy przetwornik ciśnienia');


create table parametry_SG
(
id_parametry int NOT NULL AUTO_INCREMENT,
nazwa varchar(100),
wartosc varchar(50),
wystepowanie varchar(100),
PRIMARY KEY (`id_parametry`)
);

insert into parametry_sg (nazwa,wartosc,wystepowanie) values ('Zasilanie:', '8..36V DC', 'SG25, SG16');
insert into parametry_sg (nazwa,wartosc,wystepowanie) values ('Sygnał wyjściowy:', '0..20mA', 'SG25, SG16');
insert into parametry_sg (nazwa,wartosc,wystepowanie) values ('Zakres standardowy:', '0..2;4;10;20;50', 'SG25');
insert into parametry_sg (nazwa,wartosc,wystepowanie) values ('Zakres standardowy:', '0..2;;10;100', 'SG16');

create table parametry_PC
(
id_parametry int NOT NULL AUTO_INCREMENT,
nazwa varchar(100),
wartosc varchar(50),
wystepowanie varchar(100),
PRIMARY KEY (`id_parametry`)
);

insert into parametry_pc (nazwa,wartosc,wystepowanie) values ('Zasilanie:', '8..36V DC', 'PC28');
insert into parametry_pc (nazwa,wartosc,wystepowanie) values ('Zasilanie:', '0..4V DC', 'PC50');
insert into parametry_pc (nazwa,wartosc,wystepowanie) values ('Sygnał wyjściowy:', '0..20mA', 'PC28, PC50');

create table wykonania_PC
(
id_parametry int NOT NULL AUTO_INCREMENT,
nazwa varchar(100),
wystepowanie varchar(100),
cena decimal(10,2),
opis varchar(50),
PRIMARY KEY (`id_parametry`)
);

insert into wykonania_pc (nazwa,wystepowanie,cena,opis) values ('Typ PZ', 'PC28,PC50', 230, 'Wykonanie ze stali kwasoodpornej IP66');
insert into wykonania_pc (nazwa,wystepowanie,cena,opis) values ('Typ SG', 'PC28', 130, 'Wykonanie do mocowania pod wodą IP67');
insert into wykonania_pc (nazwa,wystepowanie,cena,opis) values ('Zakres -250 do 250 PA', 'PC50', 560, 'Wykonanie ze stali kwasoodpornej IP66');

select nazwa, cena, opis FROM wykonania_PC WHERE wystepowanie LIKE '%PC28%'

