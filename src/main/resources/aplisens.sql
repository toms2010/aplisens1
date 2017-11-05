create database if not exists aplisens;

use aplisens;

drop table if exists produkty;
drop table if exists parametry_sg;
drop table if exists parametry_pc;
drop table if exists wykonania_SG;
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
insert into produkty (tag, nazwa, opis, cena, dok_opis) values ('PC' , 'PC29', 'Przetworniki ciśnienia', 960, 'Niskonapięciowy przetwornik ciśnienia');
insert into produkty (tag, nazwa, opis, cena, dok_opis) values ('PC' , 'AS', 'Przetworniki ciśnienia', 410, 'Budżetowy przetwornik ciśnienia');
insert into produkty (tag, nazwa, opis, cena, dok_opis) values ('PC' , 'PC50', 'Przetworniki ciśnienia', 1220, 'Standardowy przetwornik ciśnienia');
insert into produkty (tag, nazwa, opis, cena, dok_opis) values ('SG' , 'SG25', 'Hydrostatyczne sondy głębokości', 1180, 'Hydrostatyczna sonda głębokości');
insert into produkty (tag, nazwa, opis, cena, dok_opis) values ('SG' , 'SG16', 'Hydrostatyczne sondy głębokości', 1420, 'Hydrostatyczna sonda głębokości');
insert into produkty (tag, nazwa, opis, cena, dok_opis) values ('SG' , 'SG26S', 'Hydrostatyczne sondy głębokości', 1350, 'Hydrostatyczna sonda głębokości do pomiaru poziomu ścieków');
insert into produkty (tag, nazwa, opis, cena, dok_opis) values ('SG' , 'SG30.Smart', 'Hydrostatyczne sondy głębokości', 1650, 'Inteligentna sonda głębokości');
insert into produkty (tag, nazwa, opis, cena, dok_opis) values ('SG' , 'SG31S.Smart', 'Hydrostatyczne sondy głębokości', 1730, 'Inteligentna sonda głębokości');

create table parametry_SG
(
id_parametry int NOT NULL AUTO_INCREMENT,
nazwa varchar(100),
wartosc varchar(50),
wystepowanie varchar(100),
PRIMARY KEY (`id_parametry`)
);

insert into parametry_sg (nazwa,wartosc,wystepowanie) values ('Zasilanie:', '8..36V DC', 'SG25, SG16, SG26S');
insert into parametry_sg (nazwa,wartosc,wystepowanie) values ('Zasilanie:', '7,5..55V DC', 'SG30.Smart, SG31S.Smart');
insert into parametry_sg (nazwa,wartosc,wystepowanie) values ('Błąd podstawowy:', '0,5%', 'SG26S');
insert into parametry_sg (nazwa,wartosc,wystepowanie) values ('Błąd podstawowy:', '0,2%', 'SG25, SG16');
insert into parametry_sg (nazwa,wartosc,wystepowanie) values ('Błąd podstawowy:', '0,1%', 'SG30.Smart, SG31S.Smart');
insert into parametry_sg (nazwa,wartosc,wystepowanie) values ('Sygnał wyjściowy:', '4÷20mA lub 0÷10V', 'SG25, SG16, SG31S');
insert into parametry_sg (nazwa,wartosc,wystepowanie) values ('Sygnał wyjściowy:', '0..20mA +HART', 'SG30.Smart, SG31S.Smart');
insert into parametry_sg (nazwa,wartosc,wystepowanie) values ('Materiał obudowy:', 'stal 1.4404(316L)' , 'SG25, SG16, SG30.Smart, SG31S.Smart, SG26S');
insert into parametry_sg (nazwa,wartosc,wystepowanie) values ('Materiał membrany:', 'Hastelloy C275' , 'SG25, SG30.Smart');
insert into parametry_sg (nazwa,wartosc,wystepowanie) values ('Materiał membrany:', 'stal 1.4404(316L)' , 'SG16, SG31S.Smart, SG26S');
insert into parametry_sg (nazwa,wartosc,wystepowanie) values ('Stopień ochrony obudowy:', 'IP68', 'SG25, SG16, SG30.Smart, SG31S.Smart, SG26S');

create table parametry_PC
(
id_parametry int NOT NULL AUTO_INCREMENT,
nazwa varchar(100),
wartosc varchar(50),
wystepowanie varchar(100),
PRIMARY KEY (`id_parametry`)
);

insert into parametry_pc (nazwa,wartosc,wystepowanie) values ('Zasilanie:', '8..36V DC', 'PC28, PC50 , AS');
insert into parametry_pc (nazwa,wartosc,wystepowanie) values ('Zasilanie:', '3,3..5,6V DC', 'PC29');
insert into parametry_pc (nazwa,wartosc,wystepowanie) values ('Błąd podstawowy:', '0,5%', 'PC50');
insert into parametry_pc (nazwa,wartosc,wystepowanie) values ('Błąd podstawowy:', '0,2%', 'AS');
insert into parametry_pc (nazwa,wartosc,wystepowanie) values ('Błąd podstawowy:', '0,1%', 'PC28, PC29');
insert into parametry_pc (nazwa,wartosc,wystepowanie) values ('Sygnał wyjściowy:', '4÷20mA', 'PC28,PC50, AS');
insert into parametry_pc (nazwa,wartosc,wystepowanie) values ('Sygnał wyjściowy:', '0..10V', 'PC29');
insert into parametry_pc (nazwa,wartosc,wystepowanie) values ('Materiał obudowy:', 'stal 1.4301(304)' , 'PC28, PC50, AS, PC29');
insert into parametry_pc (nazwa,wartosc,wystepowanie) values ('Materiał membrany:', 'stal 1.4404(316L)' , 'PC28, PC50, AS, PC29');


create table wykonania_SG
(
id_parametry int NOT NULL AUTO_INCREMENT,
nazwa varchar(100),
wystepowanie varchar(100),
cena decimal(10,2),
opis varchar(50),
PRIMARY KEY (`id_parametry`)
);

insert into wykonania_sg (nazwa,wystepowanie,cena,opis) values ('Wykonanie EX', 'SG25', 230, 'wykonanie iskrobezpieczne ATEX');
insert into wykonania_sg (nazwa,wystepowanie,cena,opis) values ('MR', 'SG25, SG16, SG30.Smart, SG31S.Smart, SG26S', 200, 'Wykonanie do zastosowań morskich');
insert into wykonania_sg (nazwa,wystepowanie,cena,opis) values ('NN', 'SG25, SG16, SG30.Smart, SG31S.Smart, SG26S', 100, 'Zasilanie 3,3..5,6V DC');
insert into wykonania_sg (nazwa,wystepowanie,cena,opis) values ('SN', 'SG25, SG16, SG30.Smart, SG31S.Smart, SG26S', 100, 'Zasilanie 8..14,1V DC');
insert into wykonania_sg (nazwa,wystepowanie,cena,opis) values ('Pt100', 'SG16, SG30.Smart, SG31S.Smart, SG26S', 130, 'Wykonanie z czujnikiem temperatury');
insert into wykonania_sg (nazwa,wystepowanie,cena,opis) values ('-10..70stC', 'SG25, SG16, SG30.Smart, SG31S.Smart, SG26S', 60, 'Rozszerzony zakres kompensacji');


create table wykonania_PC
(
id_parametry int NOT NULL AUTO_INCREMENT,
nazwa varchar(100),
wystepowanie varchar(100),
cena decimal(10,2),
opis varchar(50),
PRIMARY KEY (`id_parametry`)
);

insert into wykonania_pc (nazwa,wystepowanie,cena,opis) values ('Wykonanie EX', 'PC28, PC50 , PC29, AS', 230, 'wykonanie iskrobezpieczne ATEX');
insert into wykonania_pc (nazwa,wystepowanie,cena,opis) values ('PZH', 'PC28, PC50 , PC29, AS', 200, 'Atest Państwowego Zakładu Higieny');
insert into wykonania_pc (nazwa,wystepowanie,cena,opis) values ('H', 'PC28, PC50', 150, 'Wersja o podwyższonej przeciążalności');
insert into wykonania_pc (nazwa,wystepowanie,cena,opis) values ('Hastelloy', 'PC28, PC50 , PC29, AS', 130, 'Wykonanie głowicy ze stopu Hastelloy C 276');
insert into wykonania_pc (nazwa,wystepowanie,cena,opis) values ('PED', 'PC28, PC50 , PC29, AS', 260, 'Wykonanie zgodne z dyrektywą PED');
insert into wykonania_pc (nazwa,wystepowanie,cena,opis) values ('Tlen', 'PC29, AS', 360, 'Przystosowany do pomiaru tlenu');

select nazwa, cena, opis FROM wykonania_PC WHERE wystepowanie LIKE '%PC28%'

