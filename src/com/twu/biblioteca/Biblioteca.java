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
    private List<Movie> movies = new ArrayList<Movie>();

    public Biblioteca() {
        books.add(new Book("book1", "author1", "1991"));
        books.add(new Book("book2", "author1", "1991"));
        books.add(new Book("book3", "author1", "1991"));
        books.add(new Book("book4", "author1", "1991"));
        books.add(new Book("book5", "author1", "1991"));
        books.add(new Book("book6", "author1", "1991"));
        movies.add(new Movie("movie1", "1991", "director1", 0));
        movies.add(new Movie("movie2", "1991", "director2", 9));
        mainMenu = new BibliotecaMenu();
        mainMenu.addOption("List Books", "List Books");
        mainMenu.addOption("Checkout Book", "Checkout Book");
        mainMenu.addOption("Return Book", "Return Book");
        mainMenu.addOption("List Movies", "List Movies");
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

    public void processOption(String option, Scanner scanIn) {

        String operation = mainMenu.getOptions().get(option);
        if (operation.equals("List Books")) {
            listBooksInConsole();
        } else if (operation.equals("Checkout Book")) {
            checkOutInConsole(scanIn);
        } else if (operation.equals("Return Book")) {
            returnBookInConsole(scanIn);
        } else if (operation.equals("List Movies")) {
            listMoviesInConsole();
        }

    }

    public void listBooksInConsole() {
        System.out.println("Books Info:");
        System.out.println("Name | Published Year | Author");
        System.out.println("------------------------------");
        for (Book book : getBooks()) {
            if (!book.isCheckedOut()) {
                System.out.println(book.getName() + " | " + book.getPublishedYear() + " | " + book.getAuthor());
            }
        }
    }

    public void listMoviesInConsole() {
        System.out.println("Movies Info:");
        System.out.println("Name | Year | Director | Rating");
        System.out.println("-------------------------------");
        for (Movie movie : getMovies()) {
            if (!movie.isChecketOut()) {
                System.out.println(movie.getName() + " | " + movie.getYear() + " | " +
                        movie.getDirector() + " | " + movie.getRating());
            }
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

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }
}
