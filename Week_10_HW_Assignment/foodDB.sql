create database if not exists food;
use food;

drop table if exists food;

create table food(
	id int(10) not null auto_increment,
	name varchar(50) not null,
	primary key(id)
);