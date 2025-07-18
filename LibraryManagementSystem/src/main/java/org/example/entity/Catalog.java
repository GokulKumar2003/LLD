package org.example.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class Catalog {

    private Map<String, List<BookItem>> byTitle = new ConcurrentHashMap<>();
    private Map<String, List<BookItem>> byTopic =
            new ConcurrentHashMap<>();
    private Map<String, BookItem> byBarcode = new ConcurrentHashMap<>();

    public void addBookItem(BookItem bookItem){
        Book book = bookItem.getBook();
        byTitle.computeIfAbsent(book.getTitle().toLowerCase(), k -> new ArrayList<>()).add(bookItem);
        byTopic.computeIfAbsent(book.getTopic().toLowerCase(),
                k -> new ArrayList<>()).add(bookItem);
        byBarcode.put(bookItem.getBarcode(), bookItem);
    }

    public List<Book> getBooksByTopic(String topic){

        return byTopic.getOrDefault(topic.toLowerCase(), List.of()).stream()
                .map(BookItem::getBook)
                .distinct()
                .toList();
    }

    public List<Book> getBooksByTitle(String title){

        return byTitle.getOrDefault(title.toLowerCase(), List.of()).stream()
                .map(BookItem::getBook)
                .distinct()
                .toList();
    }

    public BookItem getBookItemByBarcode(String barcode){

        return byBarcode.get(barcode);
    }

    public List<BookItem> getBookItemByTitle(String title){
        return byTitle.getOrDefault(title.toLowerCase(), List.of());
    }

    public List<BookItem> getBookItemByTopic(String topic){
        return byTopic.getOrDefault(topic.toLowerCase(), List.of());
    }

}
