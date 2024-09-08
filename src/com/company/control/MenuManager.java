package com.company.control;
import com.company.interfaces.LibraryCatalog;
import com.company.interfaces.Printable;
import com.company.models.*;
import java.util.Scanner;

public class MenuManager {
    private Scanner scanner;
    private Printable currentPrinter;
    private Commands commandHandler;
    private UserInput userInputHandler;

    public MenuManager(LibraryCatalog catalog) {
        this.scanner = new Scanner(System.in);
        this.userInputHandler = new UserInput(this.scanner);
        this.commandHandler = new Commands(catalog, currentPrinter);
    }

    public void displayMenu() {
        while (true) {
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

            int choice = userInputHandler.getUserChoice();
            handleChoice(choice);
        }
    }

    private void handleChoice(int choice) {
        switch (choice) {
            case 1:
                commandHandler.handleAddRandomBook();
                break;
            case 2:
                commandHandler.handleAddRandomNewspaper();
                break;
            case 3:
                commandHandler.handleAddRandomAlmanac();
                break;
            case 4:
                commandHandler.handleAddRandomItem();
                break;
            case 5:
                printCatalogInfo(userInputHandler.getPrintOption());
                break;
            case 6:
                String titleToRemove = userInputHandler.getUserInput("Enter the title of the item to remove: ");
                commandHandler.handleRemoveItem(titleToRemove);
                break;
            case 7:
                commandHandler.handleFindItemByTitle(userInputHandler.getUserInput("Enter the title to search for: "));
                break;
            case 8:
                commandHandler.handleFindItemsByAuthor(userInputHandler.getUserInput("Enter the author's name: "));
                break;
            case 0:
                System.out.println("Exiting...");
                return;
            default:
                System.out.println("Invalid choice. Please enter a valid number.");
        }
    }

    private void printCatalogInfo(boolean isFull) {
        if (isFull) {
            currentPrinter = new FullPrint();
        } else {
            currentPrinter = new BriefPrint();
        }
        commandHandler.printCatalogInfo(isFull);
    }
}

