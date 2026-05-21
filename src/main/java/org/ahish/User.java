package org.ahish;

public abstract class User {

    private int userId;

    private String name;

    public User(int userId, String name) {
        this.userId = userId;
        this.name = name;
    }


    public abstract void showMenu();
}
