package com.company.models;
import com.company.interfaces.LibraryItem;

public class Newspaper implements LibraryItem {
    private String name;
    private String dateIssue;
    private String[] headlines;

    public Newspaper(){
        this.headlines = new String[0];
    }

    @Override
    public void info() {
        System.out.println("Newspaper: " + name + ", Date: " + dateIssue);
        if (headlines != null && headlines.length > 0) {
            System.out.println("Headlines:");
            for (String headline : headlines) {
                System.out.println("- " + headline);
            }
        }
    }

    @Override
    public String getTitle() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setDateIssue(String dateIssue) {
        this.dateIssue = dateIssue;
    }
    public void setHeadlines(String[] headlines) {
        this.headlines = headlines;
    }

}
