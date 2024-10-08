package com.company.models;
import com.company.interfaces.LibraryItem;

public class Newspaper implements LibraryItem {
    private String name;
    private String dateIssue;
    private String[] headlines;

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

    @Override
    public boolean isTitle(String title) {
        return this.name.equalsIgnoreCase(title);
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
