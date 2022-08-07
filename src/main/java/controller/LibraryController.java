package controller;

import book.Book;
import book.Genre;
import repository.LibraryRepository;
import user.User;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Stream;

import static book.Status.AVAILABLE;

public class LibraryController {
    Scanner scanner = new Scanner(System.in);
    static LibraryRepository libraryRepository = new LibraryRepository();

    public ArrayList<User> users = new ArrayList<>();
    public ArrayList<Book> books = new ArrayList<>();

    public LibraryController(){
    }

    public void addBook() {
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
        book.setStatus(AVAILABLE);

        return book;
    }

    public void addUser() {
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

    public void borrowBook() {
        try {
            int selectedBookId = Integer.parseInt(JOptionPane.showInputDialog("Please enter ID of the book you want to borrow: "));
            int userId = Integer.parseInt(JOptionPane.showInputDialog("Please enter your user ID: "));
            libraryRepository.borrowBookFromDB(selectedBookId, userId);
        }catch (Exception exception){
            System.out.println("Error");
            exception.printStackTrace();
        }
    }

    public void returnBook() {
        try {
            int selectedBookId = Integer.parseInt(JOptionPane.showInputDialog("Please enter ID of the book you want to return: "));
            int userId = Integer.parseInt(JOptionPane.showInputDialog("Please enter your user ID: "));
            libraryRepository.returnBookToDB(selectedBookId, userId);
        }catch (Exception exception){
            System.out.println("Error");
            exception.printStackTrace();
        }
    }

    public void viewAllBooks() {
        try {
            ArrayList<Book> books = libraryRepository.getAllBooksFromDB();
            System.out.println("_______________________________________________________________________________________________________________________________");
            System.out.println("                                    === ALL THE BOOKS IN THE LIBRARY === ");
            System.out.println("_______________________________________________________________________________________________________________________________");
            books.forEach(System.out::println);
            System.out.println("_______________________________________________________________________________________________________________________________");
        } catch (Exception exception) {
            System.out.println("Error");
            exception.printStackTrace();
        }
    }

    public  void viewBooksByGenre(){
        try {
            String[] genreOptions = Stream.of(Genre.values())
                    .map(Genre -> Genre.toString()).toArray(String[]::new);
            String selectedGenre = String.valueOf(Genre.valueOf(JOptionPane.showInputDialog(
                    null,
                    "Choose genre of the book:",
                    "Genres of the books:",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    genreOptions,
                    genreOptions[0]
            ).toString()));

            ArrayList<Book> books = libraryRepository.getBookByGenreFromDb(selectedGenre);
            System.out.println("_______________________________________________________________________________________________________________________________");
            System.out.println("                                    === ALL BOOKS BY GENRE " + selectedGenre.toUpperCase() + " === ");
            System.out.println("_______________________________________________________________________________________________________________________________");
            books.forEach(System.out::println);
            System.out.println("_______________________________________________________________________________________________________________________________");
        }catch (Exception e){
            System.out.println("Error");
            e.printStackTrace();
        }
    }

    public  void viewBooksByAuthor(){
        try {
            String selectedAuthor = JOptionPane.showInputDialog("Enter the author of the book you are searching: ");

            ArrayList<Book> books = libraryRepository.getBookByAuthorFromDb(selectedAuthor);
            System.out.println("_______________________________________________________________________________________________________________________________");
            System.out.println("                                    === ALL AUTHOR " + selectedAuthor.toUpperCase() + " BOOKS IN THE LIBRARY === ");
            System.out.println("_______________________________________________________________________________________________________________________________");
            books.forEach(System.out::println);
            System.out.println("_______________________________________________________________________________________________________________________________");
        }catch (Exception e){
            System.out.println("Error");
            e.printStackTrace();
        }
    }

    public static void viewBooksByStatus(){
        try {
            ArrayList<Book> books = libraryRepository.getBookByStatusFromDb();
            System.out.println("_______________________________________________________________________________________________________________________________");
            System.out.println("                                    === ALL AVAILABLE BOOKS IN THE LIBRARY === ");
            System.out.println("_______________________________________________________________________________________________________________________________");
            books.forEach(System.out::println);
            System.out.println("_______________________________________________________________________________________________________________________________");
        } catch (Exception e) {
            System.out.println("Error");
            e.printStackTrace();
        }
    }

    public void viewAllUsers() {
        try {
            ArrayList<User> users = libraryRepository.getAllUsersFromDB();
            System.out.println("_______________________________________________________________________________________________________________________________");
            System.out.println("                                    === LIBRARY USER LIST === ");
            System.out.println("_______________________________________________________________________________________________________________________________");
            users.forEach(System.out::println);
            System.out.println("_______________________________________________________________________________________________________________________________");
        } catch (Exception exception) {
            System.out.println("Error");
            exception.printStackTrace();
        }
    }

    public void borrowedBookByUserId(){
        try {
            int userId = Integer.parseInt(JOptionPane.showInputDialog("Please enter your user ID: "));
            ArrayList<Book> borrowedBooks = libraryRepository.borrowedBooksByUserId(userId);
            System.out.println("_______________________________________________________________________________________________________________________________");
            System.out.println("                                    === YOUR BORROWED BOOK LIST === ");
            System.out.println("_______________________________________________________________________________________________________________________________");
            borrowedBooks.forEach(System.out::println);
            System.out.println("_______________________________________________________________________________________________________________________________");
        } catch (Exception exception) {
            System.out.println("Error");
            exception.printStackTrace();
        }
    }
}

