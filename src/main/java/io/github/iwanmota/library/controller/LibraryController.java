package io.github.iwanmota.library.controller;

import io.github.iwanmota.library.model.Book;
import io.github.iwanmota.library.service.LibraryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LibraryController {
    private final LibraryService libraryService;

    public LibraryController(){
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

    @PostMapping("/api/books/add")
    public void addBook(@RequestParam String title,
                        @RequestParam String author,
                        @RequestParam String description,
                        @RequestParam String ISBN,
                        @RequestParam int pages,
                        @RequestParam int year
                            ){
        libraryService.addBook(new Book(title, author, description, ISBN, pages, year));
        //libraryService.addBook(book);
    }

    @GetMapping("/api/books/search")
    public List<Book> searchBook(@RequestParam String title){
        return libraryService.lookUpBookByTitle(title);
    }

}
