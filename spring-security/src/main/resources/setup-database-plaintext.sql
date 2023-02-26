drop database if exists spring_security;
create database if not exists spring_security;
use spring_security;

drop table if exists users;

create table if not exists users(
                                    username varchar(50) primary key,
                                    password varchar(50) not null,
                                    enabled tinyint(1) not null
);

insert into users values
                      ('garry', '{noop}test123', 1),
                      ('semen', '{noop}test123', 1),
                      ('dic', '{noop}test123', 1);

drop table if exists authorities;

create table if not exists authorities(
                                          username varchar(50) not null,
                                          authority varchar(50) not null,
                                          unique key authorities_idx_1 (username, authority),
                                          constraint authorities_ibfk_1 foreign key (username) references users (username)
);

insert into authorities values
                            ('garry', 'ROLE_EMPLOYEE'),
                            ('garry', 'ROLE_ADMIN'),
                            ('semen', 'ROLE_EMPLOYEE'),
                            ('dic', 'ROLE_EMPLOYEE'),
                            ('dic', 'ROLE_MANAGER');
