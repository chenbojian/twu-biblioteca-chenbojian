package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenbojian on 7/23/15.
 */
public class BibliotecaMenu {
    private List<MenuOption> options = new ArrayList<MenuOption>();

    public String show() {
        String mainMenuStr = "The main menu is:\n";

        for (MenuOption option : options) {
            mainMenuStr += option.getName() + ". " + option.getContent() + "\n";
        }
        mainMenuStr += "Type Quit to exit.\n";
        return mainMenuStr;
    }

    public List<MenuOption> getOptions() {
        return options;
    }

    public void addOption(MenuOption option) {
        options.add(option);
    }
    public boolean isValidOption(String select) {
        for (MenuOption option : options) {
            if (option.getName().equals(select)) {
                return true;
            }
        }
        return false;
    }
}
