package org.example;

import org.example.entity.Book;
import org.example.entity.BookItem;
import org.example.entity.User;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        Library library = Library.getInstance();
        BookItem copy1 = library.addBookItem("ISBN1", "Book 1",
                "Author 1", "DSA");
        BookItem copy2 = library.addBookItem("ISBN2", "Book 2",
                "Author 1", "DBMS");
       BookItem copy3 = library.addBookItem("ISBN3", "Book" +
               " 3", "Author 3", "OS");

       User user1 = library.addUser("User1");
       User user2 = library.addUser("User2");

       // borrow
        library.borrowBook(user1.getMemberId(), copy1.getBarcode(), 20);

        //return
        library.returnBook(user1.getMemberId(), copy1.getBarcode());

        //search
        List<Book> dsaBooks = library.searchByTopic("dsa");
        for(Book book:dsaBooks){
            System.out.println(book.toString());
        }
    }
}