package book;

import java.sql.Timestamp;
import java.sql.Date;

public class Book {

    private int id;
    private String bookAuthor;
    private String bookTitle;
    private Genre bookGenre;
    private Status status;
    private Timestamp borrowedAt;
    private Timestamp returnedAt;

    public Book() {
        this.id = id;
        this.bookAuthor = bookAuthor;
        this.bookTitle = bookTitle;
        this.bookGenre = bookGenre;
        this.status = status;
    }
    public Book(int id, String bookAuthor, String bookTitle, Genre bookGenre, Status status) {
        this.id = id;
        this.bookAuthor = bookAuthor;
        this.bookTitle = bookTitle;
        this.bookGenre = bookGenre;
        this.status = status;
    }
    public Book(int id, String bookAuthor, String bookTitle, Genre bookGenre, Status status, Timestamp borrowedAt, Timestamp returnedAt) {
        this.id = id;
        this.bookAuthor = bookAuthor;
        this.bookTitle = bookTitle;
        this.bookGenre = bookGenre;
        this.status = status;
        this. borrowedAt = borrowedAt;
        this.returnedAt = returnedAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public Genre getBookGenre() {
        return bookGenre;
    }

    public void setBookGenre(Genre bookGenre) {
        this.bookGenre = bookGenre;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Timestamp getBorrowedAt(Object o) {
        return borrowedAt;
    }

    public void setBorrowedAt(Timestamp borrowedAt) {
        this.borrowedAt = borrowedAt;
    }

    public Timestamp getReturnedAt() {
        return returnedAt;
    }

    public void setReturnedAt(Timestamp returnedAt) {
        this.returnedAt = returnedAt;
    }

    @Override
    public String toString() {
        return "Book ID: " + id +
                " | Author: " + bookAuthor +
                " | Title: " + bookTitle +
                " | Genre: " + bookGenre +
                " | Status: " + status +
                " | Borrowed at: " + borrowedAt +
//                "\n Must return at:  " + untilDate +
                " | Returned at: " + returnedAt;

    }
}
