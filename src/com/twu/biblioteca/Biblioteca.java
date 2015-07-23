package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by chenbojian on 7/23/15.
 */
public class Biblioteca {
    private List<Book> books = new ArrayList<Book>();
    private BibliotecaMenu mainMenu;

    public Biblioteca() {
        books.add(new Book("book1", "author1", "1991"));
        books.add(new Book("book2", "author1", "1991"));
        books.add(new Book("book3", "author1", "1991"));
        books.add(new Book("book4", "author1", "1991"));
        books.add(new Book("book5", "author1", "1991"));
        books.add(new Book("book6", "author1", "1991"));
        mainMenu = new BibliotecaMenu();
        mainMenu.addOption("List Books");
        mainMenu.addOption("Checkout Book");
        mainMenu.addOption("Return Book");
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

    public BibliotecaMenu getMainMenu() {
        return mainMenu;
    }

    public void setMainMenu(BibliotecaMenu mainMenu) {
        this.mainMenu = mainMenu;
    }

    public void listBooksInConsole() {
        for (Book book : getBooks()) {
            if (!book.isCheckedOut()) {
                System.out.println(book.getName());
            }
        }
    }

    public void processOption(String option, Scanner scanIn) {
        if (mainMenu.getOptions().get(0).equals(option)) {
            listBooksInConsole();
        } else if (mainMenu.getOptions().get(1).equals(option)) {
            checkOutInConsole(scanIn);
        } else if (mainMenu.getOptions().get(2).equals(option)) {
            returnBookInConsole(scanIn);
        }
    }

    public void returnBookInConsole(Scanner scanIn) {
        System.out.println("Input book name:");
        String bookName = scanIn.nextLine().trim();
        returnBook(bookName);
    }

    public void checkOutInConsole(Scanner scanIn) {
        System.out.println("Input book name:");
        String bookName = scanIn.nextLine().trim();
        checkOutBook(bookName);

    }

    public void checkOutBook(String bookName) {
        for (Book book : getBooks()) {
            if (book.getName().equals(bookName)) {
                System.out.println("Thank you! Enjoy the book");
                book.setCheckedOut(true);
                return;
            }
        }
        System.out.println("That book is not available.");
    }

    public void returnBook(String bookName) {
        for (Book book : getBooks()) {
            if (book.getName().equals(bookName) && book.isCheckedOut()) {
                System.out.println("Thank you for returning the book.");
                book.setCheckedOut(false);
                return;
            }
        }
        System.out.println("That is not a valid book to return.");

    }
}
