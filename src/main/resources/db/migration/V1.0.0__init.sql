create sequence hibernate_sequence start with 1 increment by 1;
create table person (id bigint not null, age integer not null, first_name varchar(255), last_name varchar(255), primary key (id));
