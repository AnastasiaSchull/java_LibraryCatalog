package com.company.initialisers;
import com.company.interfaces.BookInitialiser;
import com.company.models.Book;
import java.util.Random;

public class BookArrayInit implements BookInitialiser {
    private static final String[] authors = {
            "Neil Gaiman", "Haruki Murakami", "J.K. Rowling",
            "Stephen King", "Agatha Christie", "George R.R. Martin"
    };
    private static final String[] titles = {
            "Eternal Night", "Whispering Shadows", "Dreams of Steel",
            "Silent Waters", "Echoes of the Past", "Twilight of Hope",
            "Voices in the Mist", "Garden of Secrets", "Maze of Illusions"
    };
    private static final Random random = new Random();

    @Override
    public void initialise(Book book) {
        String author = authors[random.nextInt(authors.length)];
        String title = titles[random.nextInt(titles.length)];
        int pages = 100 + random.nextInt(901);
        book.setAuthor(author);
        book.setTitle(title);
        book.setPages(pages);
    }
}
