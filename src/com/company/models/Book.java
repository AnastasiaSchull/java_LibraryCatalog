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
    @Override
    public boolean isTitle(String title) {
        return this.title.equalsIgnoreCase(title);
    }
    @Override
    public boolean isAuthor(String author) {
        return this.author.equalsIgnoreCase(author);
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

}
