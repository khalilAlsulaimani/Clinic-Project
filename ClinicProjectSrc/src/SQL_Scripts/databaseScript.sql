/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  alsul
 * Created: Nov 8, 2021
 */

create table mannger(
id int not null ,
fullName varchar(20),
receptionistID int unique,
username varchar(20) unique,
password varchar(20),
primary key (id)
);

ALTER TABLE mannger
add foreign key (receptionistID) references receptionist(ID);


create table receptionist(
id int not null,
fullName varchar(20),
manngerID int unique,
username varchar(20) unique,
password varchar(20),
primary key (id),
foreign key (manngerID) references mannger(ID)
);


create table owner(
id int not null,
fullName varchar(20),
manngerID int unique,
username varchar(20) unique,
password varchar(20),
primary key (id)
);

create table doctor(
id int not null,
fullName varchar(20),
paitiantID int unique,
field varchar(40),
primary key (id)
);

ALTER TABLE doctor
add foreign key (paitiantID) references paitiant(ID);

create table paitiant(
id int not null,
fullName varchar(20),
doctorID int unique,
age int not null,
primary key (id),
foreign key (doctorID) references doctor(ID)
);


