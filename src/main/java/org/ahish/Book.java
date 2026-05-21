package org.ahish;

public class Book {

    private int id;

    private String name;

    private int availability;

    public Book(int id , String name , int availability){
        this.id = id;
        this.name = name;
        this.availability = availability;
    }

    public int getId() {
        return id;
    }

    public int getAvailability() {
        return availability;
    }

    public void setAvailability(int availability) {
        this.availability = availability;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", availability=" + availability +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
