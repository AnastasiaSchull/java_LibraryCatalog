package com.company.models;

import com.company.interfaces.LibraryItem;
import com.company.interfaces.Printable;

public class FullPrint implements Printable {
    @Override
    public void print(LibraryItem item) {
        item.info(); //`info` выводит детальную информацию
        System.out.println();
    }
}
