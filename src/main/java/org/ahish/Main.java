package org.ahish;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

           Library library = new Library(Utility.createLoaderBooks());
           System.out.print("Are you a Student / Admin : ");
           Scanner s = new Scanner(System.in);
           try {
               String role = s.next();
               if(role.equalsIgnoreCase("Admin")||role.equalsIgnoreCase("Student")){
                   System.out.print("Enter name : ");
                   String userName = s.next();
                   int userId = Utility.generateId(userName.length());
                   if(role.equalsIgnoreCase("Student")){
                     Utility.handleStudent(userId , userName , library);
                   }
                   else{
                    Utility.handleAdmin(userId , userName , library);
                   }
               }
               else{
                   throw new IllegalArgumentException("Illegal role to access library , please try again ");
               }
           } catch (Exception e) {
               System.out.println(e.getMessage());
           }
           finally {
               System.out.println("Thanks for the visit !");
           }
    }
    }
