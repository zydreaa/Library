package repository;

import book.Book;
import user.User;

import javax.jws.soap.SOAPBinding;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LibraryRepository {

    Connection connection = new DbConnection().getConnection();

    public void addBookToDB(Book book) throws SQLException {

        String query = "INSERT INTO books (id, bookAuthor, bookTitle, bookGenre)" +
                " VALUES(?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);

        preparedStatement.setInt(1, book.getId()); //pagalvoti
        preparedStatement.setString(2, book.getBookAuthor());
        preparedStatement.setString(3, book.getBookTitle());
        preparedStatement.setString(4, book.getBookGenre());

        preparedStatement.execute();
    }

    public void addUserToDB(User user) throws SQLException{
        String query = "INSERT INTO users (id, username, password)" +
                " VALUES(?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);

        preparedStatement.setInt(1, user.getId()); //pagalvoti
        preparedStatement.setString(2, user.getUsername());
        preparedStatement.setString(3, user.getPassword());

        preparedStatement.execute();
    }
}
