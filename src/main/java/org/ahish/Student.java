package org.ahish;

public class Student extends User{

    public Student(int userId, String name) {
        super(userId, name);
    }

    @Override
    public void showMenu() {
        System.out.println("1. View Books\n2. Borrow Book\n3. Return Book");
    }
}
