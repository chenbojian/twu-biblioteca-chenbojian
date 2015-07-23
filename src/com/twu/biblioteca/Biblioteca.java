package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenbojian on 7/23/15.
 */
public class Biblioteca {
    private List<Book> books = new ArrayList<Book>();

    public Biblioteca() {
        books.add(new Book("book1","author1","1991"));
        books.add(new Book("book2","author1","1991"));
        books.add(new Book("book3","author1","1991"));
        books.add(new Book("book4","author1","1991"));
        books.add(new Book("book5","author1","1991"));
        books.add(new Book("book6","author1","1991"));
    }

    public String welcomeCustomer() {
        return "Welcome to Biblioteca!";
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
