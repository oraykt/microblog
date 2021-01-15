insert into users (firstName, lastName) values ('Neo', 'Matrix');
insert into users (firstName, lastName) values ('Trinity', 'Grey');
insert into users (firstName, lastName) values ('Switch', 'Happens');

insert into followers (userId, followerId) values (0, 1);
insert into followers (userId, followerId) values (0, 2);
insert into followers (userId, followerId) values (2, 0);

insert into posts (userId, post) values (0, 'The financial arrangements soon proved inadequate.');
insert into posts (userId, post) values (0, 'The crisis placed the BBC in a delicate position.');
insert into posts (userId, post) values (1, 'The principal means of funding the BBC is through the television licence.');
