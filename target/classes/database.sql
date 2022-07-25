CREATE DATABASE IF NOT EXISTS JAVA_27_28_library_app;

USE JAVA_27_28_library_app;

CREATE TABLE IF NOT EXISTS books (
    id int not null auto_increment,
    bookAuthor text not null,
    bookTitle text not null,
    bookGenre varchar(10),
    status varchar(10),
    borrowedAt timestamp default current_timestamp,
    untilDate date,
    returnedAt timestamp default current_timestamp on update current_timestamp,
    primary key (id)
    );
   
CREATE TABLE IF NOT EXISTS users (
    id int not null auto_increment,
    username text not null,
    password text not null,
    primary key (id)
    );
