package com.company.interfaces;

public interface LibraryCatalog extends Printable{
    void addLibraryItem(LibraryItem item);
    void addRandomItem();
    void removeLibraryItem(String title);
    LibraryItem findItemByTitle(String title);
    LibraryItem[] findItemsByAuthor(String author);
    void printFullInfo();
    void printSummary();
}
