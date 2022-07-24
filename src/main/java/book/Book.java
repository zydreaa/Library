package book;

import java.util.UUID;

public class Book {

    private int id;
    public String bookAuthor;
    public String bookTitle;
    public Genre bookGenre;

    public Status status;

    public Book(int id, String bookAuthor, String bookTitle, Genre bookGenre,Status status) {
        this.id = id;
        this.bookAuthor = bookAuthor;
        this.bookTitle = bookTitle;
        this.bookGenre = bookGenre;
        this.status = status;
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

    @Override
    public String toString() {
        return "Book ID: " + id +
                "\n Author: " + bookAuthor +
                "\n Title: " + bookTitle +
                "\n Genre: " + bookGenre +
                "\n Status: " + status;
    }
}
