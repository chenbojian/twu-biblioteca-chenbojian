package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by chenbojian on 7/23/15.
 */
public class BibliotecaAppTest{

    @Test
    public void should_get_welcome_message() {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        assertEquals(bibliotecaApp.welcomeCustomer(), "Welcome to Biblioteca!");
    }

}