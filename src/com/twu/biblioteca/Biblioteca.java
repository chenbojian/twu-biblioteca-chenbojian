package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenbojian on 7/23/15.
 */
public class Biblioteca {
    private List<Book> books = new ArrayList<Book>();

    public Biblioteca() {
        books.add(new Book());
        books.add(new Book());
        books.add(new Book());
        books.add(new Book());
        books.add(new Book());
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
