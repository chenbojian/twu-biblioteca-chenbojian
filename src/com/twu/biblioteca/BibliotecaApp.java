package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {

        Biblioteca biblioteca = new Biblioteca();
        System.out.println(biblioteca.welcomeCustomer());
        System.out.println(biblioteca.getMainMenu().show());
        Scanner scanIn=new Scanner(System.in);
        String selection = scanIn.nextLine().trim();
        if (biblioteca.getMainMenu().isValidOption(selection)) {
        } else {
            System.out.println("Sorry! You input error selection!");
        }
        scanIn.close();
    }


}
