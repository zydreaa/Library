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
                            "2. Remove book\n" +
                            "3. Borrow book\n" +
                            "4. View all library books\n" +
                            "5. View books by genre\n" +
                            "6. View book by author\n" +
                            "7. View all available books\n" +
                            "8. Return books\n" +
                            "0. QUIT"
            );

            switch (menu) {
                case "1":
                    break;
                case "2":
                    break;
                case "3":
                    break;
                case "4":
                    break;
                case "5":
                    break;
                case "6":
                    break;
                case "7":
                    break;
                case "8":
                    break;
                case "0":
                    System.exit(1);
                default:
                    JOptionPane.showMessageDialog(null, "Please choose valid option from menu!");
            }
        }
    }
}
