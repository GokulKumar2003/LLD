package org.example.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
public class Loan {

    private String loanId;
    private BookItem bookItem;
    private User user;
    private LocalDate borrowDate;
    private LocalDate dueDate;
    private Boolean isActive = true;

    public Loan(BookItem bookItem, User user, long days){
        this.loanId = UUID.randomUUID().toString();
        this.bookItem = bookItem;
        this.user = user;
        this.borrowDate = LocalDate.now();
        this.dueDate = borrowDate.plusDays(days);
    }

    public void closeLoan(){
        bookItem.markAvailable();
    }
}
