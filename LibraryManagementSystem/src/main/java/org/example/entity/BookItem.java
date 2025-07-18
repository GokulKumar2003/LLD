package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class BookItem {

    private String barcode;
    private Book book;
    private BookStatus bookStatus;

    public BookItem(Book book){
        this.book = book;
        this.barcode = UUID.randomUUID().toString();
        this.bookStatus = BookStatus.AVAILABLE;
    }

    public Boolean isAvailable(){
        return this.bookStatus == BookStatus.AVAILABLE;
    }

    public void markAvailable(){
        this.bookStatus = BookStatus.AVAILABLE;
    }

    public void markBorrowed(){
        this.bookStatus = BookStatus.BORROWED;
    }
}
