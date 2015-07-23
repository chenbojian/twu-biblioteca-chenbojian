package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

/**
 * Created by chenbojian on 7/23/15.
 */
public class BibliotecaTest {

    private Biblioteca biblioteca;
    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();
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
        assertEquals(biblioteca.getMainMenu().getOptions().get(0), "List Books");
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

}
