create database if not exists vehicles;

use vehicles;

drop table if exists vehicles;

create table vehicles(
id int(10) not null auto_increment,
brand varchar(10) not null,
model varchar(10) not null,
primary key (id)
);
