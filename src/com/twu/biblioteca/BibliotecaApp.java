package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {

        Biblioteca biblioteca = new Biblioteca();
        System.out.println(biblioteca.welcomeCustomer());
        Scanner scanIn = new Scanner(System.in);
        while (true) {
            System.out.println(biblioteca.getMainMenu().show());
            String option = scanIn.nextLine().trim();
            if (biblioteca.getMainMenu().isValidOption(option)) {
                biblioteca.processOption(option);
            } else {
                if (!option.equals("Quit")) {
                    System.out.println("Select a valid option!");
                } else {
                    break;
                }
            }
        }
        scanIn.close();
    }

}
