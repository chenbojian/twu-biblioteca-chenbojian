package com.twu.biblioteca;

/**
 * Created by CBJ on 2015/8/2.
 */
public class User {
    private boolean login;
    private String libraryNumber;
    private String password;
    private String telephoneNumber;

    public User() {

    }

    public User(String libraryNumber, String password, String telephoneNumber) {
        this.libraryNumber = libraryNumber;
        this.password = password;
        this.telephoneNumber = telephoneNumber;
    }

    public boolean isLogin() {
        return login;
    }

    public void setLogin(boolean login) {
        this.login = login;
    }

    public String getLibraryNumber() {
        return libraryNumber;
    }

    public void setLibraryNumber(String libraryNumber) {
        this.libraryNumber = libraryNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }
}
