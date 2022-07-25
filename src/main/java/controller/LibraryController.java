package controller;

import book.Book;
import book.Genre;
import book.Status;
import repository.LibraryRepository;
import user.User;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.stream.Stream;

public class LibraryController {

    LibraryRepository libraryRepository = new LibraryRepository();

    public ArrayList<User> users = new ArrayList<>();
    public ArrayList<Book> books = new ArrayList<>();

    public LibraryController(){
    }

    public void addBook() { //VEIKIA
        try {
            Book book = this.collectBookInfo();
            libraryRepository.addBookToDB(book);
            System.out.println("Book was added successfully");
        } catch (Exception e) {
            System.out.println("Error");
            e.printStackTrace();
        }
    }

    private Book collectBookInfo() {
        Book book = new Book();
        book.setId(books.size());
        book.setBookAuthor(JOptionPane.showInputDialog("Please enter author of the book: "));
        book.setBookTitle(JOptionPane.showInputDialog("Please enter title of the book: "));
        String[] genreOptions = Stream.of(Genre.values())
                .map(Genre -> Genre.toString()).toArray(String[]::new);
        book.setBookGenre(Genre.valueOf(JOptionPane.showInputDialog(
                null,
                "Choose genre of the book:",
                "Genre of the book:",
                JOptionPane.QUESTION_MESSAGE,
                null,
                genreOptions,
                genreOptions[0]
        ).toString()));
        book.setStatus(Status.AVAILABLE);

        return book;
    }

    public void addUser() { //VEIKIA
        try {
            int userId = users.size();
            String username = JOptionPane.showInputDialog("Please enter username: ");
            String password = JOptionPane.showInputDialog("Please enter password: ");
            User user = new User(userId, username, password);

            libraryRepository.addUserToDB(user);
            System.out.println("User was added successfully");
        } catch (SQLException e) {
            System.out.println("Error");
            e.printStackTrace();
        }
    }

    public void removeBook() {
        int bookId = Integer.parseInt(JOptionPane.showInputDialog("Please enter ID of the book you want to remove: "));
        try{
            libraryRepository.deleteBook(bookId);
            System.out.println("Book deleted successfully");
        }catch (Exception e){
            System.out.println("Error");
            e.printStackTrace();
        }
    }

    public void viewAllBooks() { //VEIKIA
        try {
            ArrayList<Book> books = libraryRepository.getAllBooksFromDB();
            System.out.println("_______________________________________________________________________________________________________________________________");
            System.out.println("                                    === ALL THE BOOKS IN THE LIBRARY === ");
            System.out.println("_______________________________________________________________________________________________________________________________");
            books.forEach(System.out::println);
            System.out.println("_______________________________________________________________________________________________________________________________");
        } catch (SQLException exception) {
            System.out.println("Error");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public  void viewBooksByGenre(){
        try {
            String[] genreOptions = Stream.of(Genre.values())
                    .map(Genre -> Genre.toString()).toArray(String[]::new);
            String selectedGenre = String.valueOf(Genre.valueOf(JOptionPane.showInputDialog(
                    null,
                    "Choose genre of the book:",
                    "Genre of the book:",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    genreOptions,
                    genreOptions[0]
            ).toString()));

            Book books = libraryRepository.getBookByGenreFromDb(selectedGenre);
            System.out.println(books);
        }catch (Exception e){
            System.out.println("Error");
            e.printStackTrace();
        }

    }

}

