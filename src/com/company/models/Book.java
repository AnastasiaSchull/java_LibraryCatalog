package com.company.models;
import com.company.interfaces.LibraryItem;

public class Book implements LibraryItem {
    private String author;
    private String title;
    private int pages;

    @Override
    public void info(){
        System.out.println("Book: " + title + " by " + author + ", pages: " + pages);
    }

    @Override
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }
}
