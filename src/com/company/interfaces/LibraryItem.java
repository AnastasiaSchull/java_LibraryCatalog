package com.company.interfaces;

public interface LibraryItem {
   void info();
   String getTitle();
   boolean isTitle(String title);
   default boolean isAuthor(String author) {
      return false; // по умолчанию элемент не имеет автора
   }
  // void print();
}
