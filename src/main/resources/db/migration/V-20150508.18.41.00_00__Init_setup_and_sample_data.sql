CREATE TABLE USER (
	id BIGINT AUTO_INCREMENT PRIMARY KEY,
	username varchar(255) not null,
	password varchar(255) not null,
	first_name varchar(255) not null,
	last_name varchar(255) not null,
	email varchar(255) not null,
	roles varchar(255) not null
);

CREATE TABLE SETTINGS (
	id BIGINT AUTO_INCREMENT PRIMARY KEY,
	code varchar(255) not null,
	title varchar(255) not null,
	title_header varchar(255) not null,
	administrator_email varchar(255) not null,
	footer varchar(255) not null
);

insert into USER (username, password, first_name, last_name, email, roles) values ('admin', 'admin', 'Anibal', 'Gomez', 'anibalgomez@icloud.com', 'ADMIN');
insert into USER (username, password, first_name, last_name, email, roles) values ('user', 'user', 'Jon', 'Doe', 'noreply@balerocms.com', 'USER');

insert into SETTINGS (code, title, title_header, administrator_email, footer) values ('en_US', 'Balerocms v2', '<h1>Welcome</h1><h3>Example Portal</h3><hr class="intro-divider" /><p>Congratulations! Installation success!</p>', 'admin@localhost', '(c) 2015. Your company.');