package book;

import java.util.UUID;

public class Book {

    private UUID id;
    public String bookAuthor;
    public String bookTitle;
    public String bookGenre;

    public Book(UUID id, String bookAuthor, String bookTitle, String bookGenre) {
        this.id = UUID.fromString(); //pagalvoti
        this.bookAuthor = bookAuthor;
        this.bookTitle = bookTitle;
        this.bookGenre = bookGenre;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
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

    public String getBookGenre() {
        return bookGenre;
    }

    public void setBookGenre(String bookGenre) {
        this.bookGenre = bookGenre;
    }
}
