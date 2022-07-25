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

    public ArrayList<Book> getAllBooksFromDB() throws Exception {
        java.util.ArrayList<Book> books = new ArrayList<>();
        String query = "SELECT * FROM books";
        PreparedStatement preparedStatement = connection.prepareStatement(query);

        ResultSet result = preparedStatement.executeQuery();

        while (result.next()) {
            books.add(this.createBook(result));
//            Book book = new Book(
//                    result.getInt("id"),
//                    result.getString("bookAuthor"),
//                    result.getString("bookTitle"),
//                    Genre.valueOf(result.getString("bookGenre")),
//                    Status.valueOf(result.getString("status"))
//            );
//            books.add(book);
        }
        return books;
    }

    public Book getBookByGenreFromDb(String selectedGenre) throws Exception {
        Book books =  null;
        String query = "SELECT * FROM books WHERE bookGenre = " + selectedGenre;
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            books = this.createBook(resultSet);
        }else {
            throw  new Exception("Book not found");
        }
        return books;
    }

    private Book createBook(ResultSet resultSet) throws Exception {
        return new Book(
                resultSet.getInt("id"),
                resultSet.getString("bookAuthor"),
                resultSet.getString("bookTitle"),
                Genre.valueOf(resultSet.getString("bookGenre")),
                Status.valueOf(resultSet.getString("status"))
        );
    }
}