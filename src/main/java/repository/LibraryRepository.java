package repository;

import book.Book;
import book.Genre;
import book.Status;
import user.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class LibraryRepository {

    Connection connection = new DbConnection().getConnection();

    public void addBookToDB(Book book) throws SQLException {

        String query = "INSERT INTO books (id, bookAuthor, bookTitle, bookGenre, status)" +
                " VALUES(?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);

        preparedStatement.setInt(1, book.getId());
        preparedStatement.setString(2, book.getBookAuthor());
        preparedStatement.setString(3, book.getBookTitle());
        preparedStatement.setString(4, book.getBookGenre().toString());
        preparedStatement.setString(5, book.getStatus().toString());

        preparedStatement.execute();
    }

    public void addUserToDB(User user) throws SQLException {
        String query = "INSERT INTO users (id, username, password)" +
                " VALUES(?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);

        preparedStatement.setInt(1, user.getUserId());
        preparedStatement.setString(2, user.getUsername());
        preparedStatement.setString(3, user.getPassword());

        preparedStatement.execute();
    }

    public void deleteBook(int bookId) throws Exception {
        String query = "DELETE FROM books WHERE id = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, bookId);

        if (preparedStatement.executeUpdate() == 0) {
            throw new SQLException("Could not delete book with id " + bookId + "item not found");
        }
    }

    public void borrowBookFromDB(int selectedBookId, int userId) throws Exception {
        if (this.getBookById(selectedBookId).getStatus().toString() == "AVAILABLE") {
            getUserById(userId);
            getBookById(selectedBookId);
            //changeBookStatusToBorrowed(selectedBookId); NEVEIKIA
            addBookInBorrowedBookList(userId, getUserById(userId).getUsername(),
                    selectedBookId, getBookById(selectedBookId).getBookTitle(),
                    getBookById(selectedBookId).getBookAuthor());
            System.out.println("You have successfully borrowed book");
        } else {
                System.out.println("Book is already taken");
        }
    }

        public void changeBookStatusToBorrowed (int selectedBookId) throws Exception { //NEVEIKIA

            String query = "UPDATE books SET status = ? WHERE id = ?" + selectedBookId;
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            getBookById(selectedBookId).setStatus(Status.BORROWED);
            int result = preparedStatement.executeUpdate();

            if (result == 1) {
                System.out.println("Book status was updated");
            } else {
                System.out.println("Problem updating status");
            }
        }

        public void addBookInBorrowedBookList (int userId, String username,int bookId, String bookTitle, String
        bookAuthor){
            try {
                String query = "INSERT INTO borrowedBookList (userId, username, bookId, bookTitle, bookAuthor)" +
                        "VALUES (?, ?, ?, ?, ?)";
                PreparedStatement preparedStatement = connection.prepareStatement(query);

                preparedStatement.setInt(1, userId);
                preparedStatement.setString(2, username);
                preparedStatement.setInt(3, bookId);
                preparedStatement.setString(4, bookTitle);
                preparedStatement.setString(5, bookAuthor);

                preparedStatement.execute();
            } catch (SQLException e) {
                System.out.println("Error occurred");
                e.printStackTrace();
            }
        }

//        public void returnBookToDB ( int selectedBookId, int userId) throws Exception {
//            if (this.getUserById(userId);
//                    String query = "SELECT * FROM books WHERE status = 'BORROWED' AND id = ?" + selectedBookId;
//            PreparedStatement preparedStatement = connection.prepareStatement(query);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            if (resultSet.next()) {
//                System.out.println("You have successfully returned book");
//                //changeBookStatusToAvailable(selectedBookId);
//            } else {
//                System.out.println("Book is already returned");
//            }
//        }

    public boolean removeBookFromBorrowedBookList(int selectedBookId, int userId) {
        try {
            String query = "DELETE FROM borrowedBookList WHERE bookId = " + selectedBookId + " and userId = " + userId;
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Error occurred");
            e.printStackTrace();
        }
        return false;
    }

//        public void changeBookStatusToAvailable ( int selectedBookId) throws SQLException {
//            String query = "UPDATE books SET status = 'AVAILABLE' WHERE id = ?" + selectedBookId;
//            PreparedStatement preparedStatement = connection.prepareStatement(query);
//            ResultSet resultSet = preparedStatement.executeQuery();
//
//            if (resultSet.next()) {
//                System.out.println("Book status was updated");
//            } else {
//                System.out.println("Problem updating status");
//            }
//        }

        public Book getBookById (int selectedBookId) throws Exception {
            Book book = null;
            String query = "SELECT * FROM books WHERE id = " + selectedBookId;
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                book = this.createBook(resultSet);
            } else {
                throw new Exception("Selected book is not found");
            }
            return book;
        }

        public User getUserById ( int userId) throws Exception {
            User user = null;
            String query = "SELECT * FROM users WHERE id = " + userId;
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                user = this.createUser(resultSet);
            } else {
                throw new Exception("Selected user is not found");
            }
            return user;
        }

        public ArrayList<Book> getAllBooksFromDB () throws Exception {
            ArrayList<Book> books = new ArrayList<>();
            String query = "SELECT * FROM books";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            ResultSet result = preparedStatement.executeQuery();

            while (result.next()) {
                books.add(this.createBook(result));
            }
            return books;
        }

        public ArrayList<Book> getBookByGenreFromDb (String selectedGenre){
            try {
                ArrayList<Book> books = new ArrayList<>();
                String query = "SELECT * FROM books WHERE bookGenre = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, selectedGenre);
                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    books.add(this.createBook(resultSet));
                }
                return books;
            } catch (Exception e) {
                System.out.println("Book not found");
                e.printStackTrace();
                return null;
            }
        }

        public ArrayList<Book> getBookByAuthorFromDb (String selectedAuthor){
            try {
                ArrayList<Book> books = new ArrayList<>();
                String query = "SELECT * FROM books WHERE bookAuthor = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, selectedAuthor);
                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    books.add(this.createBook(resultSet));
                }
                return books;
            } catch (Exception e) {
                System.out.println("Book not found");
                e.printStackTrace();
                return null;
            }
        }

        private Book createBook (ResultSet resultSet) throws Exception {
            return new Book(
                    resultSet.getInt("id"),
                    resultSet.getString("bookAuthor"),
                    resultSet.getString("bookTitle"),
                    Genre.valueOf(resultSet.getString("bookGenre")),
                    Status.valueOf(resultSet.getString("status"))
            );
        }

        public ArrayList<Book> getBookByStatusFromDb () {
            try {
                ArrayList<Book> books = new ArrayList<>();
                String query = "SELECT * FROM books WHERE status LIKE 'AVAILABLE'";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    books.add(this.createBook(resultSet));
                }
                return books;
            } catch (Exception e) {
                System.out.println("Book not found");
                e.printStackTrace();
                return null;
            }
        }

        public ArrayList<User> getAllUsersFromDB () throws Exception {
            ArrayList<User> users = new ArrayList<>();
            String query = "SELECT * FROM users";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet result = preparedStatement.executeQuery();

            while (result.next()) {
                users.add(this.createUser(result));
            }
            return users;
        }

        private User createUser (ResultSet result) throws Exception {
            return new User(
                    result.getInt("id"),
                    result.getString("username"),
                    result.getString("password")
            );
        }
    }