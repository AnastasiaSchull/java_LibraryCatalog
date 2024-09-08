package com.company.factory;
import com.company.initialisers.AlmanacArrayInit;
import com.company.initialisers.BookArrayInit;
import com.company.initialisers.NewspaperArrayInit;
import com.company.interfaces.LibraryItem;
import com.company.models.Almanac;
import com.company.models.Book;
import com.company.models.Newspaper;
import java.util.Random;

//класс, который по рандому создает обьект либо книги, либо газеты, либо альманаха
public class RandomLibraryItemFactory {
    private static final Random random = new Random();

    public LibraryItem createRandomItem() {
        int itemType = random.nextInt(3);
        switch (itemType) {
            case 0:
                Book book = new Book();
                new BookArrayInit().initialise(book);
                return book;
            case 1:
                Newspaper newspaper = new Newspaper();
                new NewspaperArrayInit().initialise(newspaper);
                return newspaper;
            case 2:
                Almanac almanac = new Almanac();
                new AlmanacArrayInit().initialise(almanac);
                return almanac;
            default:
                throw new IllegalStateException("Unexpected value: " + itemType);
        }
    }
}
