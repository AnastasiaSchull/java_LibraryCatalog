package com.company;
import com.company.interfaces.LibraryCatalog;

public class Main {
    public static void main(String[] args) {
        LibraryCatalog catalog = new ArrayLibraryCatalog();
        MenuManager menuManager = new MenuManager(catalog);
        menuManager.displayMenu();
    }
}