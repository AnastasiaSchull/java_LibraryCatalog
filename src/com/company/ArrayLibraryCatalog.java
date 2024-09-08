package com.company;

import com.company.factory.RandomLibraryItemFactory;
import com.company.interfaces.LibraryCatalog;
import com.company.interfaces.LibraryItem;
import java.util.Arrays;

public class ArrayLibraryCatalog implements LibraryCatalog {
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
    public LibraryItem  addRandomItem() {
        LibraryItem item = itemFactory.createRandomItem();
        addLibraryItem(item);
        return item;
    }

    @Override
    public void removeLibraryItem(String title) {
        boolean found = false;
        for (int i = 0; i < size; i++) {
            // используем isTitle вместо прямого доступа к getTitle и сравнения строк
            if (items[i].isTitle(title)) {
                System.arraycopy(items, i + 1, items, i, size - i - 1);
                items[--size] = null; // уменьшаем размер после удаления
                System.out.println("Item removed: " + title);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("No independent item found with that title.");
        }
    }

    @Override
    public LibraryItem findItemByTitle(String title) {
        for (LibraryItem item : items) {
            if (item != null && item.isTitle(title)) {
                return item;
            }
        }
        return null;
    }

    @Override
    public LibraryItem[] findItemsByAuthor(String author) {
        LibraryItem[] tempItems = new LibraryItem[size]; // временный массив для хранения найденных элементов
        int foundCount = 0; // счётчик найденных элементов

        for (LibraryItem item : items) {
            if (item != null && item.isAuthor(author)) {
                tempItems[foundCount++] = item;
            }
        }

        if (foundCount == 0) {
            return new LibraryItem[0]; // пустой массив, если ничего не найдено
        }

        //массив необходимой длины
        LibraryItem[] foundItems = new LibraryItem[foundCount];
        System.arraycopy(tempItems, 0, foundItems, 0, foundCount);
        return foundItems;
    }


    @Override
    public LibraryItem[] getAllItems() {
        return Arrays.copyOf(items, size); // возвращаем копию массива
    }
}