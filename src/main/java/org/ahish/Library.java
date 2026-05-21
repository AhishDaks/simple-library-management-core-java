package org.ahish;

import java.util.*;


public class Library {

   private List<Book> books;
   private Map<Integer, Set<Integer>> issuedBooks = new HashMap<>();

   public Library(List<Book> books) {
      this.books = books;
   }

   public void addBook(String name) throws Exception {
      boolean check = books.stream().anyMatch(a -> a.getName().equals(name));
      if(check){
         books.stream().filter(a -> a.getName().equals(name)).forEach(a -> {
            a.setAvailability(a.getAvailability()+1);
         });
      }
      else{
         Book book = new Book(Utility.generateId(name.length()) , name , 1);
         books.add(book);
      }
   }

   public void showAvailableBooks(){
      books.forEach(System.out::println);
   }

   public void borrowBook(int userId , int bookId) throws Exception {
     Book borrowableBook = searchBook(bookId);
     int check = borrowableBook.getAvailability();
     if(check>0){
         Set<Integer> bookIds;
         if(issuedBooks.containsKey(userId))
         {
            bookIds = issuedBooks.get(userId);
            if(bookIds.add(bookId)){
                borrowableBook.setAvailability(check - 1);
            }
            else{
                throw new IllegalArgumentException("Book already borrowed");
            }
         }
        else {
             bookIds = new HashSet<>();
             bookIds.add(bookId);
             issuedBooks.put(userId, bookIds);
             borrowableBook.setAvailability(check - 1);
         }
        System.out.println("Book borrowed still now  " + issuedBooks.entrySet());
     }
     else{
        throw new Exception("No book is left to borrow");
     }
   }

   public void returnBook(int userId ,int bookId) {

      Set<Integer> issuedBookIds = issuedBooks.get(userId);

          if (issuedBookIds != null && issuedBookIds.contains(bookId)) {
              Book borrowableBook = searchBook(bookId);
              int check = borrowableBook.getAvailability();
              borrowableBook.setAvailability(check + 1);
              issuedBookIds.remove(Integer.valueOf(bookId));
              if(issuedBookIds.isEmpty()){
                  issuedBooks.remove(userId);
              }
              System.out.println(borrowableBook.getName()+" book returned successfully ");
          } else {
              throw new NoSuchElementException("No books are issued to return");
          }
      }


   public Book searchBook(int bookId){
      return books.stream().filter(a -> a.getId()==bookId).findFirst().orElseThrow(()-> new NoSuchElementException("No Book Found "));
   }
}
