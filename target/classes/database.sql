CREATE DATABASE IF NOT EXISTS JAVA_27_28_library_app;

USE JAVA_27_28_library_app;

CREATE TABLE IF NOT EXISTS books (
    id int not null auto_increment,
    bookAuthor text not null,
    bookTitle text not null,
    bookGenre varchar(10),
    status varchar(10),
    primary key (id)
    );
   
CREATE TABLE IF NOT EXISTS users (
    id int not null auto_increment,
    username text not null,
    password text not null,
    primary key (id)
    );

CREATE TABLE IF NOT EXISTS borrowedBookList (
    id int not null auto_increment,
    userId int not null ,
    username text not null,
    bookId int not null,
    bookTitle text not null,
    bookAuthor text not null,
    borrowedAt timestamp default current_timestamp,
    returnDue timestamp default (timestampadd(month,1,current_timestamp())),
    primary key(id),
    FOREIGN KEY(bookId) REFERENCES books(id)
     );


