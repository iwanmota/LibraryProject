package io.github.iwanmota.library.controller;

import io.github.iwanmota.library.model.Book;
import io.github.iwanmota.library.service.LibraryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {
    private final LibraryService libraryService;

    public BookController(){
        this.libraryService = new LibraryService();
    }

//    @GetMapping("/")
//    public String home(){
//        return "Hello World";
//    }

    @GetMapping("/api/books")
    public List<Book> getAllBooks(){
        return libraryService.getAllBooks();
    }
}
