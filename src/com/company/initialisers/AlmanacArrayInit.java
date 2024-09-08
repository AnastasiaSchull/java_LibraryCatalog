package com.company.initialisers;
import com.company.interfaces.AlmanacInitialiser;
import com.company.models.Almanac;
import com.company.models.Book;
import java.util.Random;

    public class AlmanacArrayInit implements AlmanacInitialiser {
        private static final String[] almanacTitles = {"Yearly Science Digest", "Literature Collection", "Annual Art Review"};
        private static final Random random = new Random();

        @Override
        public void initialise(Almanac almanac) {
            String title = almanacTitles[random.nextInt(almanacTitles.length)];
            int year = 1950 + random.nextInt(23);
            Book[] books = new Book[3]; // например, каждый альманах имеет по 3 книги

            for (int i = 0; i < books.length; i++) {
                books[i] = new Book();
                new BookArrayInit().initialise(books[i]);
            }

            almanac.setTitle(title);
            almanac.setYear(year);
            almanac.setBooks(books);
        }
    }

