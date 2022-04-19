package com.bai2.controller;

import com.bai2.dto.BookRequest;
import com.bai2.model.Book;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/book")
public class BookController {
    private ConcurrentHashMap<String, Book>books;

    public BookController() {
        books=new ConcurrentHashMap<>();
        books.put("OX-13", new Book("OX-13", "Gone with the wind", "Cuong", 1945));
        books.put("OX-14", new Book("OX-14", "Chi Dau", "Nam Cao", 1943));
    }
    @GetMapping
    public List<Book>all(){
        return books.values().stream().toList();
    }
    @PostMapping
    public Book create(@RequestBody BookRequest bookRequest){
        String uuid= UUID.randomUUID().toString();
        Book book=new Book(uuid,bookRequest.title(),bookRequest.author(),bookRequest.year());
        books.put(uuid,book);
        return book;
    }
}
