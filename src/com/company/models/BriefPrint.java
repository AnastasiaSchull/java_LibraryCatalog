package com.company.models;

import com.company.interfaces.LibraryItem;
import com.company.interfaces.Printable;

public class BriefPrint implements Printable {
    @Override
    public void print(LibraryItem item) {
        String itemType = item.getClass().getSimpleName();
        System.out.println( itemType + ": " + item.getTitle());
    }
}