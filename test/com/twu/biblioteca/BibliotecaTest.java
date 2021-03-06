package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

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

    private void loginForTest(User user) {
        String input = user.getLibraryNumber() + "\n" + user.getPassword();
        Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes()));
        biblioteca.loginInConsole(scanner);
        scanner.close();
    }

    @Test
    public void should_get_welcome_message() {
        biblioteca.welcomeCustomer();
        assertTrue(outContent.toString().contains("Welcome to Biblioteca!"));

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
        biblioteca.listOptionsInConsole();
        assertTrue(outContent.toString().split("\n").length > 0);
        assertTrue(outContent.toString().contains("Login"));
    }

    @Test
    public void should_checkout_book_correctly() {
        loginForTest(biblioteca.getUsers().get(0));

        checkoutBookForTest(biblioteca.getBooks().get(0).getName());
        Scanner scanner;
        assertTrue(outContent.toString().contains("Thank you! Enjoy the book"));
        outContent.reset();

        scanner = new Scanner(new ByteArrayInputStream("not a book".getBytes()));
        biblioteca.checkOutBookInConsole(scanner);
        assertTrue(outContent.toString().contains("That book is not available."));

    }

    private void checkoutBookForTest(String bookName) {
        Scanner scanner = new Scanner(new ByteArrayInputStream(bookName.getBytes()));
        biblioteca.checkOutBookInConsole(scanner);
        scanner.close();
    }

    @Test
    public void should_return_book_correctly() {
        loginForTest(biblioteca.getUsers().get(0));

        Book book = biblioteca.getBooks().get(0);

        checkoutBookForTest(book.getName());

        returnBookForTest(book.getName());
        assertTrue(outContent.toString().contains("Thank you for returning the book."));
        outContent.reset();

        returnBookForTest(book.getName());
        assertTrue(outContent.toString().contains("That is not a valid book to return."));
        outContent.reset();

        returnBookForTest("not a book");
        assertTrue(outContent.toString().contains("That is not a valid book to return."));
    }

    private void returnBookForTest(String bookName) {
        Scanner scanner = new Scanner(new ByteArrayInputStream(bookName.getBytes()));
        biblioteca.returnBookInConsole(scanner);
        scanner.close();
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

    @Test
    public void should_checkout_movie_successful() {
        List<Movie> movies = biblioteca.getMovies();
        Scanner scanner = new Scanner(new ByteArrayInputStream(movies.get(0).getName().getBytes()));
        biblioteca.checkOutMovieInConsole(scanner);
        scanner.close();
        assertTrue(movies.get(0).isCheckedOut());
    }

    @Test
    public void should_have_a_user_list() {
        assertNotNull(biblioteca.getUsers());
    }

    @Test
    public void should_login_before_check_out_books() {
        checkoutBookForTest(biblioteca.getBooks().get(0).getName());
        assertTrue(outContent.toString().contains("Please login!"));
    }

    @Test
    public void should_change_current_user_when_login_success() {
        loginForTest(biblioteca.getUsers().get(0));
        assertTrue(biblioteca.getCurrentUser().isLogin());
    }

    @Test
    public void should_add_user_library_number_when_check_out_book() {
        User user = biblioteca.getUsers().get(0);
        loginForTest(user);

        Book book = biblioteca.getBooks().get(0);
        checkoutBookForTest(book.getName());

        assertTrue(book.getBorrower().equals(user));

    }

    @Test
    public void should_remove_borrower_when_return_book() {
        loginForTest(biblioteca.getUsers().get(0));

        Book book = biblioteca.getBooks().get(0);
        checkoutBookForTest(book.getName());

        returnBookForTest(book.getName());

        assertNull(book.getBorrower());
    }

    @Test
    public void should_have_telephone_number_in_user() {
        try {
            User.class.getMethod("getTelephoneNumber");
        } catch (NoSuchMethodException e) {
            throw new AssertionError("Do not have field telephoneNumber");
        }
    }

    @Test
    public void can_not_show_user_info_if_not_login() {
        biblioteca.showUserInfoInConsole();
        assertTrue(outContent.toString().contains("Not available!"));
    }

    @Test
    public void can_show_user_info_if_login() {
        User user = biblioteca.getUsers().get(0);
        loginForTest(user);
        biblioteca.showUserInfoInConsole();
        assertTrue(outContent.toString().contains(user.getLibraryNumber()));
        assertTrue(outContent.toString().contains(user.getTelephoneNumber()));
    }

    @Test
    public void should_add_user_info_into_book_if_checkout() {
        loginForTest(biblioteca.getUsers().get(0));
        checkoutBookForTest(biblioteca.getBooks().get(0).getName());

        assertTrue(biblioteca.getBooks().get(0).getBorrower().getLibraryNumber().equals(
                biblioteca.getUsers().get(0).getLibraryNumber()
        ));

    }

    @Test
    public void should_error_if_the_user_who_return_book_is_not_borrower() {
        loginForTest(biblioteca.getUsers().get(0));
        checkoutBookForTest(biblioteca.getBooks().get(0).getName());

        loginForTest(biblioteca.getUsers().get(1));
        returnBookForTest(biblioteca.getBooks().get(0).getName());

        assertFalse(outContent.toString().contains("That's not a valid book to return"));
    }

    @Test
    public void should_not_have_option_to_show_user_info_before_login() {
        assertFalse(biblioteca.getMainMenu().show().contains("Show User Info"));
    }

    @Test
    public void should_have_option_to_show_user_after_login() {
        loginForTest(biblioteca.getUsers().get(0));
        assertTrue(biblioteca.getMainMenu().show().contains("Show User Info"));
    }

    @Test
    public void should_show_user_info_in_console() {
        loginForTest(biblioteca.getUsers().get(0));
        biblioteca.showUserInfoInConsole();
        assertTrue(outContent.toString().contains("111-1111"));
    }

}
