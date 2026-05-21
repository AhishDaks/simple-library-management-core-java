package org.ahish;

public class Admin extends User{


    public Admin(int userId, String name) {
        super(userId, name);
    }

    @Override
    public void showMenu() {
        System.out.println("1. Add Book\n2. View Books");;
    }
}
