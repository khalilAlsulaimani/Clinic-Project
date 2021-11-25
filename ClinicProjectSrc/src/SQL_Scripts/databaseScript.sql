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
receptionistID int ,
username varchar(20) unique,
password varchar(20),
primary key (id)
);




create table receptionist(
id int not null,
fullName varchar(20),
manngerID int ,
username varchar(20) unique,
password varchar(20),
primary key (id),
foreign key (manngerID) references mannger(ID) on delete cascade
);

ALTER TABLE mannger
add foreign key (receptionistID) references receptionist(ID) on delete cascade;


create table owner(
id int not null,
fullName varchar(20),
username varchar(20) unique,
password varchar(20),
primary key (id)
);

create table doctor(
id int not null,
fullName varchar(20),
paitiantID int,
field varchar(40),
primary key (id)
);


create table patiant(
id int not null,
fullName varchar(20),
doctorID int ,
age int not null,
number int unique,
primary key (id),
foreign key (doctorID) references doctor(ID) on delete cascade
);

ALTER TABLE doctor
add foreign key (paitiantID) references paitiant(ID) on delete cascade;


insert into owner values(1,'Khalid Mjrashi','OWN100','a12345');
insert into mannger values(1,'Mike King',null,'MAN100','a12345');
insert into receptionist values(1,'Eren Yager',1,'REP100','a12345');

update mannger set receptionistID=1 where id=1;

insert into receptionist values(2,'Historya Reiss',1,'REP200','a12345');

alter table mannger
add column isFirstLogin int default 1;

alter table owner
add column isFirstLogin int default 1;

alter table receptionist
add column isFirstLogin int default 1;

create table appoitment (
id int not null AUTO_INCREMENT,
time int,
date Date,
patiantID int,
patiantName VARCHAR(30),
doctorID int,
doctorName varchar(30),
PRIMARY KEY(id),
FOREIGN KEY (patiantID) references patiant(id),
FOREIGN KEY (doctorID) references doctor(id)
);

insert into appoitment (time,date,patiantID,patiantName,doctorID,doctorName) values(8,'2021-3-4',23,'ada wong',2,'Tylor Jackson');