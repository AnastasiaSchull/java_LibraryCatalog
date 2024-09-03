package com.company;

import com.company.initialisers.AlmanacArrayInit;
import com.company.initialisers.BookArrayInit;
import com.company.initialisers.NewspaperArrayInit;
import com.company.interfaces.LibraryCatalog;
import com.company.interfaces.LibraryItem;
import com.company.models.Almanac;
import com.company.models.Book;
import com.company.models.Newspaper;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuManager {
    private LibraryCatalog catalog;
    private Scanner scanner;

    public MenuManager(LibraryCatalog catalog) {
        this.catalog = catalog;
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        while (true) {
            try {
            System.out.println("\nLibrary Catalog Management System:");
            System.out.println("1. Add a random book");
            System.out.println("2. Add a random newspaper");
            System.out.println("3. Add a random almanac");
            System.out.println("4. Add a random library item");
            System.out.println("5. Display all items");
            System.out.println("6. Remove an item");
            System.out.println("7. Find item by title");
            System.out.println("8. Find items by author");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    handleAddRandomBook();
                    break;
                case 2:
                    handleAddRandomNewspaper();
                    break;
                case 3:
                    handleAddRandomAlmanac();
                    break;
                case 4:
                    handleAddRandomItem();
                    break;
                case 5:
                    System.out.println("Select an option:");
                    System.out.println("1. Display full catalog information");
                    System.out.println("2. Display catalog summary");
                    int subChoice = scanner.nextInt();
                    scanner.nextLine();
                    if (subChoice == 1) {
                        catalog.printFullInfo();
                    } else if (subChoice == 2) {
                        catalog.printSummary();
                    } else {
                        System.out.println("Invalid choice.");
                    }
                    break;
                case 6:
                    handleRemoveItem();
                    break;
                case 7:
                    handleFindItemByTitle();
                    break;
                case 8:
                    handleFindItemsByAuthor();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a valid number.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.nextLine();  // очищаем буфер сканера чтоб избежат зацикливания
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
        }
    }

    private void handleAddRandomItem() {
        catalog.addRandomItem();
        System.out.println("Random item added successfully.");
    }

    private void handleRemoveItem() {
        System.out.print("Enter the title of the item to remove: ");
        String title = scanner.nextLine();
        catalog.removeLibraryItem(title);
        catalog.printFullInfo();
    }

    private void handleFindItemByTitle() {
        System.out.print("Enter the title to search for: ");
        String title = scanner.nextLine();
        LibraryItem item = catalog.findItemByTitle(title);
        if (item != null) {
            item.info();
        } else {
            System.out.println("No item found with that title.");
        }
    }

    private void handleFindItemsByAuthor() {
        System.out.print("Enter the author's name: ");
        String author = scanner.nextLine();
        LibraryItem[] items = catalog.findItemsByAuthor(author);
        if (items.length > 0) {
            System.out.println("Found items by author '" + author + "':");
            for (LibraryItem item : items) {
                item.info();  // вызов info каждого элемента
            }
        } else {
            System.out.println("No items found by that author.");
        }
    }

    private void handleAddRandomBook() {
        Book book = new Book();
        new BookArrayInit().initialise(book);
        catalog.addLibraryItem(book);
        System.out.println("Random book added successfully.");
        book.info();
    }

    private void handleAddRandomNewspaper() {
        Newspaper newspaper = new Newspaper();
        new NewspaperArrayInit().initialise(newspaper);
        catalog.addLibraryItem(newspaper);
        System.out.println("Random newspaper added successfully.");
        newspaper.info();
    }

    private void handleAddRandomAlmanac() {
        Almanac almanac = new Almanac();
        new AlmanacArrayInit().initialise(almanac);
        catalog.addLibraryItem(almanac);
        System.out.println("Random almanac added successfully.");
        almanac.info();
    }
}
