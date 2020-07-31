create table user (
	id int not null auto_increment primary key,
	name varchar(100),
	username varchar(50),
	password varchar(100),
	image varchar(100),
	role varchar(50)
);

create table category (
	id int not null auto_increment primary key,
	name varchar(100)
);

create table post (
	id int not null auto_increment primary key,
	content text,
	post_date varchar(100),
	liked int,
	unliked int,
	category_id int,
	user_id int,
	foreign key (category_id) references category(id),
	foreign key (user_id) references user(id)
);

create table comment (
	id int not null auto_increment primary key,
	content text,
	comment_date varchar(100),
	liked int,
	unliked int,
	post_id int,
	user_id int,
	foreign key (post_id) references post(id),
	foreign key (user_id) references user(id)
);

create table user_post (
	type varchar(10),
	user_id int,
	post_id int,
	foreign key (user_id) references user(id),
	foreign key (post_id) references post(id)
);

create table user_comment (
	type varchar(10),
	user_id int,
	comment_id int,
	foreign key (user_id) references user(id),
	foreign key (comment_id) references comment(id)
);
