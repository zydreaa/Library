package controller;

import javax.swing.*;

public class LibraryMenu {

 LibraryController libraryController = new LibraryController();

 public void startMenu(){
        showAndHandleMenu();
 }


 public void showAndHandleMenu(){
    String menu = "";

        while (!menu.equals("0")) {

            menu = JOptionPane.showInputDialog(
                    "Please choose from menu options below:\n" +
                            "1. Add new book\n" +
                            "2. Add new user\n" +
                            "3. Remove book\n" +
                            "4. Borrow book\n" +
                            "5. Return book\n" +
                            "6. View all library books\n" +
                            "7. View books by genre\n" +
                            "8. View book by author\n" +
                            "9. View all available books\n" +
                            "10. Show all user\n" +
                            "11. Show borrowed books by User ID\n" + //su useriu, grazinimo data, pasiemimo data
                            "0. QUIT"
            );

            switch (menu) {
                case "1":
                    libraryController.addBook(); //VEIKIA
                    break;
                case "2":
                    libraryController.addUser(); //VEIKIA
                    break;
                case "3":
                    libraryController.removeBook(); //VEIKIA
                    break;
                case "4":
                    break;
                case "5":
                    break;
                case "6":
                    libraryController.viewAllBooks(); //VEIKIA
                    break;
                case "7":
                    libraryController.viewBooksByGenre(); //VEIKIA
                    break;
                case "8":
                    libraryController.viewBooksByAuthor(); //VEIKIA
                    break;
                case "9":
                    LibraryController.viewBooksByStatus(); //VEIKIA
                    break;
                case "10":
                    libraryController.viewAllUsers();// Nerodo useriu
                    break;
                case "11":
                    break;
                case "0":
                    System.exit(1);
                default:
                    JOptionPane.showMessageDialog(null, "Please choose valid option from menu!");
            }
        }
    }
}
