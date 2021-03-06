package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {

        Biblioteca biblioteca = new Biblioteca();
        biblioteca.welcomeCustomer();
        Scanner scanIn = new Scanner(System.in);
        while (true) {
            biblioteca.listOptionsInConsole();
            String option = scanIn.nextLine().trim();
            if (! biblioteca.processOption(option, scanIn)) {
                break;
            }
        }
        scanIn.close();
    }

}
