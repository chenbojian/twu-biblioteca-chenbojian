package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by chenbojian on 7/23/15.
 */
public class BibliotecaTest {

    private Biblioteca biblioteca;

    @Before
    public void setUp() throws Exception {
        biblioteca = new Biblioteca();
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
    }

    @Test
    public void should_valid_option_correctly() {
        assertTrue(biblioteca.getMainMenu().isValidOption("1"));
        assertFalse(biblioteca.getMainMenu().isValidOption("xxxxx"));
    }

}
