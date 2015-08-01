package com.twu.biblioteca;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by chenbojian on 7/23/15.
 */
public class BibliotecaMenu {
    private Map<String, String> options = new HashMap<String, String>();

    public String show() {
        String mainMenuStr = "The main menu is:\n";

        for (String option : options.keySet()) {
            mainMenuStr += "--->" + option + "\n";
        }
        mainMenuStr += "Type Quit to exit.\n";
        return mainMenuStr;
    }

    public Map<String, String> getOptions() {
        return options;
    }

    public boolean isValidOption(String option) {
        return options.containsKey(option);
    }

    public void addOption(String option, String value) {
        options.put(option, value);
    }
}
