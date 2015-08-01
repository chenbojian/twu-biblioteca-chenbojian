package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by chenbojian on 7/23/15.
 */
public class BibliotecaTest {

    private Biblioteca biblioteca;
    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();//have \r\n in windows
    private ByteArrayOutputStream errContent = new ByteArrayOutputStream();


    @Before
    public void setUp() throws Exception {
        biblioteca = new Biblioteca();
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void complete() {
        System.setOut(null);
        System.setErr(null);
    }

    @Test
    public void should_get_welcome_message() {
        assertEquals(biblioteca.welcomeCustomer(), "Welcome to Biblioteca!");
    }

    @Test
    public void should_have_a_list_of_book() {
        assertTrue(biblioteca.getBooks().size() > 0);

    }

    @Test
    public void should_have_name_year_author_in_book() {
        for (Book book : biblioteca.getBooks()) {
            assertNotNull(book.getName());
            assertNotNull(book.getAuthor());
            assertNotNull(book.getPublishedYear());
        }
    }

    @Test
    public void should_have_main_menu() {
        assertNotNull(biblioteca.getMainMenu());
    }

    @Test
    public void should_show_main_menu_as_string_in_console() {
        assertTrue(biblioteca.getMainMenu().show().length() > 0);
    }

    @Test
    public void should_have_option_with_content_as_main_menu() {
        assertNotNull(biblioteca.getMainMenu().getOptions());
        assertEquals(biblioteca.getMainMenu().getOptions().get("List Books"), "List Books");
    }

    @Test
    public void should_valid_option_correctly() {
        assertTrue(biblioteca.getMainMenu().isValidOption("List Books"));
        assertFalse(biblioteca.getMainMenu().isValidOption("xxxxx"));
    }

    @Test
    public void should_list_option() {
        biblioteca.listBooksInConsole();
        assertTrue(outContent.toString().split("\n").length > 0);
    }

    @Test
    public void should_checkout_book_correctly() {
        String bookName = biblioteca.getBooks().get(0).getName();

        biblioteca.checkOutBook(bookName);
        assertTrue(outContent.toString().contains("Thank you! Enjoy the book"));
        outContent.reset();

        biblioteca.checkOutBook("not a book");
        assertTrue(outContent.toString().contains("That book is not available."));

    }

    @Test
    public void should_return_book_correctly() {
        Book book = biblioteca.getBooks().get(0);
        book.setCheckedOut(true);
        String bookName = book.getName();
        biblioteca.returnBook(bookName);
        assertTrue(outContent.toString().contains("Thank you for returning the book."));
        outContent.reset();

        biblioteca.returnBook(bookName);
        assertTrue(outContent.toString().contains("That is not a valid book to return."));
        outContent.reset();

        biblioteca.returnBook("not a book");
        assertTrue(outContent.toString().contains("That is not a valid book to return."));
    }

    @Test
    public void how_map_work() {
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("1", 1);
        map.put("2", 2);
        map.put("3", 3);
        map.put("4", 4);

        assertEquals(map.get("1").intValue(), 1);
    }

    @Test
    public void should_list_movies_successful() {
        List<Movie> movies = biblioteca.getMovies();
        assertNotNull(movies);
        Movie movie = movies.get(0);
        assertEquals(movie.getClass(), Movie.class);
        assertNotNull(movie.getName());
        assertNotNull(movie.getYear());
        assertNotNull(movie.getDirector());
        assertNotNull(movie.getRating());
    }
}
