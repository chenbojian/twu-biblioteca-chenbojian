package com.twu.biblioteca;

/**
 * Created by chenbojian on 7/23/15.
 */
class MenuOption {
    private String name;
    private String content;

    public MenuOption(String name, String content) {
        this.name = name;
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
