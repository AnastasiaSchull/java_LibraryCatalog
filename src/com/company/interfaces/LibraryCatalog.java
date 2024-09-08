package com.company.interfaces;

public interface LibraryCatalog {
    void addLibraryItem(LibraryItem item);
    LibraryItem addRandomItem();
    void removeLibraryItem(String title);
    LibraryItem findItemByTitle(String title);
    LibraryItem[] findItemsByAuthor(String author);
    LibraryItem[] getAllItems();
}
