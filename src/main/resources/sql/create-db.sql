drop schema public cascade;

drop table user if exists;

create table user(
	userId int,
	firstName varchar(255),
	lastName varchar(255)
);

drop table follower if exists;

create table follower (
	userId int,
	followerId int
);

drop table post if exists;

create table post (
	userId int,
	post varchar(255)
);