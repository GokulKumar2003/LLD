package org.example;
import lombok.Getter;
import lombok.Setter;
import org.example.entity.*;
import org.example.entity.Book;
import org.example.entity.Catalog;
import org.example.entity.Loan;
import org.example.entity.User;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Getter
@Setter
public class Library {

    private Map<String, User> users;
    private Map<String, Book> books; // isbn -> key
    private Map<String, Loan> loans;
    private Catalog catalog;

    private static Library instance;
    private static final int MAX_BOOKS_PER_MEMBER = 5;
    private static int FINE_PER_DAY = 10;

    private Library(){
        users = new HashMap<>();
        books= new ConcurrentHashMap<>();
        loans = new ConcurrentHashMap<>();
        catalog = new Catalog();
    }

    public static Library getInstance(){
        if(instance == null){
            synchronized (Library.class){
                if(instance == null){
                    instance = new Library();
                }
            }
        }
        return instance;
    }

    public BookItem addBookItem(String ISBN, String title, String author,
                                String topic){

        Book book = new Book(title, author, ISBN, topic);
        books.put(book.getISBN(), book);
        BookItem bookItem = new BookItem(book);
        catalog.addBookItem(bookItem);

        return bookItem;
    }

    public User addUser(String name){
        User user = new User(name);
        users.put(user.getMemberId(), user);
        return user;
    }

    public boolean borrowBook(String memberId, String barcode, long days){

        User user = users.get(memberId);
        BookItem bookItem = catalog.getBookItemByBarcode(barcode);

        if(user == null){
            System.out.println("Invalid User");
            return false;
        }
        if(bookItem == null){
            System.out.println("Invalid book. Please register the book before " +
                    "issuing.");
            return false;
        }

        if(user.getBorrowedCount() >= MAX_BOOKS_PER_MEMBER){
            System.out.println("Member has reached the max borrowing limit. " +
                    "Please return the old books to borrow new ones");
            return false;
        }

        bookItem.markBorrowed();
        Loan loan = new Loan(bookItem, user, days);
        user.addLoan(loan);
        loans.put(loan.getLoanId(), loan);

        System.out.printf("Successfully issued %s to %s.",
                bookItem.getBook().getTitle(), user.getName());
        return true;
    }

    /* Returns fine. returns 0, if no fine */
    public double returnBook(String memberId, String barcode){

        User user = users.get(memberId);
        BookItem bookItem = catalog.getBookItemByBarcode(barcode);

        if(user == null){
            System.out.println("Invalid User");
            return 0;
        }
        if(bookItem == null){
            System.out.println("Invalid book.");
            return 0;
        }

        Loan loan = user.getLoanList().stream()
                .filter(l -> l.getBookItem().getBarcode().equals(barcode))
                .findFirst()
                .orElse(null);

        LocalDate todayDate = LocalDate.now();

        double fine = 0;
        if(todayDate.isAfter(loan.getDueDate())){
            fine = 10 * ChronoUnit.DAYS.between(todayDate, loan.getDueDate());
            System.out.println("You need to pay fine of Amt " + fine + " Rs");
        }

        if(loan != null){
            bookItem.markAvailable();
            user.removeLoan(loan);
            System.out.println("Successfully returned");
            return fine;
        }

        return 0;

    }

    public List<Book> searchBookByTitle(String title){
        return catalog.getBooksByTitle(title);
    }

    public List<Book> searchByTopic(String topic){
        return catalog.getBooksByTopic(topic);
    }

}
