import controller.LibraryMenu;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        JOptionPane.showMessageDialog(null,"Welcome to library!");

        LibraryMenu libraryMenu = new LibraryMenu();
        libraryMenu.startMenu();
    }
}
