package book;

import java.sql.Timestamp;
import java.sql.Date;

public class Book {

    private int id;
    private String bookAuthor;
    private String bookTitle;
    private Genre bookGenre;
    private Status status;
    private String borrowedAt;
    private String returnDue;

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
    public Book(int id, String bookTitle, String bookAuthor, String borrowedAt, String returnDue) {
        this.id = id;
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this. borrowedAt = borrowedAt;
        this.returnDue = returnDue;
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
        if(borrowedAt!=null){
            return "Book ID:" + id +
                    "| Title: " + bookTitle +
                    "| Author: " +bookAuthor +
                    "| Borrowed at: " + borrowedAt +
                    "| Return due: " + returnDue;
        }
        else

        return "Book ID: " + id +
                " | Author: " + bookAuthor +
                " | Title: " + bookTitle +
                " | Genre: " + bookGenre +
                " | Status: " + status;

    }
}
