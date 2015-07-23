package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenbojian on 7/23/15.
 */
public class BibliotecaMenu {
    private List<String> options = new ArrayList<String>();

    public String show() {
        String mainMenuStr = "The main menu is:\n";

        for (String option : options) {
            mainMenuStr += "--->" + option + "\n";
        }
        mainMenuStr += "Type Quit to exit.\n";
        return mainMenuStr;
    }

    public List<String> getOptions() {
        return options;
    }

    public boolean isValidOption(String option) {
        return -1 != options.indexOf(option);
    }

    public void addOption(String option) {
        options.add(option);
    }
}
