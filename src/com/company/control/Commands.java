package com.company.control;

import com.company.initialisers.AlmanacArrayInit;
import com.company.initialisers.BookArrayInit;
import com.company.initialisers.NewspaperArrayInit;
import com.company.interfaces.LibraryCatalog;
import com.company.interfaces.LibraryItem;
import com.company.interfaces.Printable;
import com.company.models.*;


public class Commands {
    private LibraryCatalog catalog;
    private Printable currentPrinter;

    public Commands(LibraryCatalog catalog, Printable printer) {
        this.catalog = catalog;
        this.currentPrinter = printer;
    }

    public void handleAddRandomItem() {
        LibraryItem item = catalog.addRandomItem();
        System.out.println("Random item added successfully.");
        item.info();
    }

    public void handleRemoveItem(String title) {
        catalog.removeLibraryItem(title);
    }

    public void handleFindItemByTitle(String title) {
        LibraryItem item = catalog.findItemByTitle(title);
        if (item != null) {
            item.info();
        } else {
            System.out.println("No item found with that title.");
        }
    }

    public void handleFindItemsByAuthor(String author) {
        LibraryItem[] items = catalog.findItemsByAuthor(author);
        if (items.length > 0) {
            System.out.println("Found items by author '" + author + "':");
            for (LibraryItem item : items) {
                item.info();
            }
        } else {
            System.out.println("No items found by that author.");
        }
    }

    public void setPrinter(Printable printer) {
        this.currentPrinter = printer;
    }

    public void printCatalogInfo(boolean isFull) {
        if (isFull) {
            this.setPrinter(new FullPrint());
        } else {
            this.setPrinter(new BriefPrint());
        }
        for (LibraryItem item : catalog.getAllItems()) {
            currentPrinter.print(item);
        }
    }

    public void handleAddRandomBook() {
        Book book = new Book();
        new BookArrayInit().initialise(book);
        catalog.addLibraryItem(book);
        System.out.println("Random book added successfully.");
        book.info();
    }

    public void handleAddRandomNewspaper() {
        Newspaper newspaper = new Newspaper();
        new NewspaperArrayInit().initialise(newspaper);
        catalog.addLibraryItem(newspaper);
        System.out.println("Random newspaper added successfully.");
        newspaper.info();
    }

    public void handleAddRandomAlmanac() {
        Almanac almanac = new Almanac();
        new AlmanacArrayInit().initialise(almanac);
        catalog.addLibraryItem(almanac);
        System.out.println("Random almanac added successfully.");
        almanac.info();
    }
}
