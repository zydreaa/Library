**LIBRARY MANAGEMENT SYSTEM**

Library Management System is created that user would be able to use below provided [menu options:]()
* Add new book
* Add new user
* Remove book
* Borrow book
* Return book
* View all library books
* View books by genre
* View book by author
* View all available books
* Show all user
* Show borrowed books by User ID

[All the data is stored in SQL database. And in order to run this project you need to:]()
1. Execute code from dataBase.sql in your MySQL Workbench
2. Fill your information in resources/database.properties: 
 * database.username= 
 * database.password= 
 * database.host= 
 * database.port= 
 * database.dbName=

[Things to improve:]()
* Implement login/log out methods
* Split users into 2 types(admin and users)
* Separate admin and user menu
* At Book class have extra parameter (as quantity)