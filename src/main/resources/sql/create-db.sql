drop schema public cascade;
create sequence public.hibernate_sequence;

drop table users if exists;

create table users(
	userId bigint IDENTITY PRIMARY KEY,
	firstName varchar(255),
	lastName varchar(255)
);

drop table followers if exists;

create table followers (
	id bigint IDENTITY,
	userId bigint ,
	followerId bigint,
	PRIMARY KEY (userId, followerId)
);

drop table posts if exists;

create table posts (
	id bigint IDENTITY PRIMARY KEY,
	userId bigint,
	post varchar(255)
);