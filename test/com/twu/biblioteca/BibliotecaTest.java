package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by chenbojian on 7/23/15.
 */
public class BibliotecaTest {

    @Test
    public void should_get_welcome_message() {
        Biblioteca biblioteca = new Biblioteca();
        assertEquals(biblioteca.welcomeCustomer(), "Welcome to Biblioteca!");
    }



}