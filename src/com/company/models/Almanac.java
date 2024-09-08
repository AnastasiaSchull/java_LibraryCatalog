package com.company.models;
import com.company.interfaces.LibraryItem;

public class Almanac implements LibraryItem {
    private String title;
    private int year;
    private Book[] books;

    @Override
    public void info() {
        System.out.println("Almanac Title: " + title);
        System.out.println("Year of Publication: " + year);
        System.out.println("Contains " + (books != null ? books.length : 0) + " books:");
        if (books != null) {
            for (Book book : books) {
                book.info();
            }
        }
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public boolean isTitle(String title) {
        return this.title.equalsIgnoreCase(title);
    }

    @Override
    public boolean isAuthor(String author) {
        if (books != null) {
            for (Book book : books) {
                if (book.isAuthor(author))
                    return true;
            }
        }
        return false;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setBooks(Book[] books) {
        this.books = books;
    }

}
