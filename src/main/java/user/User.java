package user;

import book.Book;

import java.util.ArrayList;

public class User {

    private int userId;
    private String username;
    private String password;
    private ArrayList<Book> bookList;

    public User(int userId, String username, String password, ArrayList<Book> bookList) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.bookList = bookList;
    }

    public User(int userId, String username, String password) {
        this.userId = userId;
        this.username = username;
        this.password = password;
    }

    public void setUserIdId(int userId) {
        this.userId = userId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public ArrayList<Book> getBookList() {
        return bookList;
    }

    public void setBookList(ArrayList<Book> bookList) {
        this.bookList = bookList;
    }

    @Override
    public String toString() {
        if (bookList != null) {
            return "User ID: " + userId +
                    "| Username: " + username +
                    "| Borrowed books: " + bookList;
        }else {
            return "User ID: " + userId +
                    "| Username: " + username +
                    "| Password: " + password;
        }
    }
}
