package com.company;

import com.company.factory.RandomLibraryItemFactory;
import com.company.interfaces.LibraryCatalog;
import com.company.interfaces.LibraryItem;
import com.company.interfaces.Printable;
import com.company.models.Almanac;
import com.company.models.Book;
import com.company.models.Newspaper;

import java.util.Arrays;

public class ArrayLibraryCatalog implements LibraryCatalog, Printable {
    private static final int DEFAULT_CAPACITY = 100;
    private LibraryItem[] items;
    private int size;
    private RandomLibraryItemFactory itemFactory = new RandomLibraryItemFactory();

    public ArrayLibraryCatalog() {
        items = new LibraryItem[DEFAULT_CAPACITY];
        size = 0;//нет элементов пока в массиве
    }

    @Override
    public void addLibraryItem(LibraryItem item) {
        if (size == items.length) {
            // расширение массива
            items = Arrays.copyOf(items, size + 1);
        }
        items[size++] = item;
    }

    @Override
    public void addRandomItem() {
        LibraryItem item = itemFactory.createRandomItem();
        addLibraryItem(item);
        item.info();
    }

    @Override
    public void removeLibraryItem(String title) {
        for (int i = 0; i < size; i++) {
            if (items[i].getTitle().equals(title)) {
                System.arraycopy(items, i + 1, items, i, size - i - 1);
                items[--size] = null;
                break;
            }
        }
    }

    @Override
    public LibraryItem findItemByTitle(String title) {
        for (LibraryItem item : items) {
            if (item != null && item.getTitle().equals(title)) {
                return item;
            }
        }
        return null;
    }

    @Override
    public LibraryItem[] findItemsByAuthor(String author) {
        LibraryItem[] tempItems = new LibraryItem[size]; // временный массив для хранения найденных эл-в
        int foundCount = 0; // счётчик найденных эл-в

        for (LibraryItem item : items) {
            if (item instanceof Book && ((Book) item).getAuthor().equals(author)) {
                tempItems[foundCount++] = item;
            } else if (item instanceof Almanac) {
                // проверяем каждую книгу в альманахе
                Book[] books = ((Almanac) item).getBooks();
                for (Book book : books) {
                    if (book.getAuthor().equals(author)) {
                        tempItems[foundCount++] = item;
                        break; // прекращаем поиск в этом альманахе после первого совпадения
                    }
                }
            }
        }
        if (foundCount == 0) {
            return new LibraryItem[0];
        }

        // создаем массив нужной длины
        LibraryItem[] foundItems = new LibraryItem[foundCount];
        System.arraycopy(tempItems, 0, foundItems, 0, foundCount);
        return foundItems;
    }

    @Override
    public void printFullInfo() {
        System.out.println("Full Catalog Info:");
        for (int i = 0; i < size; i++) {
            if (items[i] != null) {
                items[i].info();
            }
            System.out.println();
        }
    }

    @Override
    public void printSummary() {
        int totalBooks = 0;
        int totalNewspapers = 0;
        int totalAlmanacs = 0;

        for (LibraryItem item : items) {
            if (item instanceof Book) {
                totalBooks++;
            } else if (item instanceof Newspaper) {
                totalNewspapers++;
            } else if (item instanceof Almanac) {
                totalAlmanacs++;
            }
        }

        System.out.println("Catalog Summary:");
        System.out.println("Total books: " + totalBooks);
        System.out.println("Total newspapers: " + totalNewspapers);
        System.out.println("Total almanacs: " + totalAlmanacs);
    }
}
