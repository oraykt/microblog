insert into user (userId, firstName, lastName) values (1, 'Neo', 'Matrix');
insert into user (userId, firstName, lastName) values (2, 'Trinity', 'Grey');
insert into user (userId, firstName, lastName) values (3, 'Switch', 'Happens');

insert into follower (userId, followerId) values (1, 2);
insert into follower (userId, followerId) values (1, 3);
insert into follower (userId, followerId) values (3, 1);

insert into post (userId, post) values (1, 'The financial arrangements soon proved inadequate.');
insert into post (userId, post) values (1, 'The crisis placed the BBC in a delicate position.');
insert into post (userId, post) values (2, 'The principal means of funding the BBC is through the television licence.');
