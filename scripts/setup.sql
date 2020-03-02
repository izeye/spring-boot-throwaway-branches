CREATE DATABASE test;

CREATE USER 'user'@'localhost' IDENTIFIED BY 'password';
GRANT ALL ON test.* TO 'user'@'localhost';

USE test;
CREATE TABLE person(
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL
);
INSERT INTO person VALUES ("Johnny", "Lim");
