drop schema public cascade;

drop table users if exists;

create table users(
	userId bigint IDENTITY PRIMARY KEY,
	firstName varchar(255),
	lastName varchar(255)
);

drop table followers if exists;

create table followers (
	userId bigint ,
	followerId bigint
);

drop table posts if exists;

create table posts (
	userId bigint,
	post varchar(255)
);