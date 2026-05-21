package org.ahish;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Utility {


    private static int id = (int) ( Math.floor( Math.random() * 100 ) + 1 );

    public static int generateId(int userSize){
        return id+1;
    }

    public static List<Book> createLoaderBooks(){
        List<Book> books = new ArrayList<>();

        books.add(new Book(1, "Java Basics", 5));
        books.add(new Book(2, "Spring Boot Guide", 3));
        books.add(new Book(3, "Data Structures", 0));
        books.add(new Book(4, "Algorithms Made Easy", 2));
        books.add(new Book(5, "Microservices Architecture", 4));
        books.add(new Book(6, "Hibernate in Action", 1));
        books.add(new Book(7, "Clean Code", 6));
        books.add(new Book(8, "Design Patterns", 2));
        books.add(new Book(9, "Effective Java", 7));
        books.add(new Book(10, "System Design Basics", 3));

        return books;
    }

    public static void handleStudent(int userId , String userName , Library library){
        Scanner s = new Scanner(System.in);
        User user = new Student(userId , userName);
        boolean adminAccess = true;
        while(adminAccess) {
            user.showMenu();
            System.out.print("Select one option above : ");
            int toDo = s.nextInt();
            if (toDo == 1) {
                library.showAvailableBooks();
            } else if (toDo == 2) {
                System.out.print("Enter bookId which you want to borrow : ");
                int bookId = s.nextInt();
                try {
                    library.borrowBook(userId, bookId);
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }
            } else if(toDo == 3){
                System.out.print("Enter bookId which you want to return : ");
                int bookId = s.nextInt();
                try {
                    library.returnBook(userId , bookId);
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }
            }
            s.nextLine();
            System.out.print("Do you want to see the menu again YES/NO : ");
            String adminLoopChecker = s.nextLine();
            adminAccess = adminLoopChecker.equalsIgnoreCase("YES");
        }
    }

    public static void handleAdmin(int userId , String userName , Library library) throws Exception {
        Scanner s = new Scanner(System.in);
        User user = new Admin(userId , userName);
        boolean adminAccess = true;
        while(adminAccess) {
            user.showMenu();
            System.out.print("Select one option above : ");
            int toDo = s.nextInt();
            s.nextLine();
            if (toDo == 1) {
                System.out.print("Enter Book name : ");
                String newBookName = s.nextLine();
                library.addBook(newBookName);
            } else if (toDo == 2) {
                library.showAvailableBooks();
            }
            System.out.print("Do you want to see the menu again YES/NO : ");
            String adminLoopChecker = s.nextLine();
            adminAccess = adminLoopChecker.equalsIgnoreCase("YES");
        }
    }
}
