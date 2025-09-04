package io.github.iwanmota.library.controller;

import io.github.iwanmota.library.model.Book;
import io.github.iwanmota.library.service.LibraryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class LibraryController {
    private final LibraryService libraryService;

    public LibraryController(LibraryService libraryService){
        this.libraryService = libraryService;
    }

    @GetMapping("/books")
    public List<Book> getAllBooks(){
        return libraryService.getAllBooks();
    }

    @PostMapping("/books/add")
    public void addBook(@RequestParam String title,
                        @RequestParam String author,
                        @RequestParam String description,
                        @RequestParam String ISBN,
                        @RequestParam int pages,
                        @RequestParam int year
                            ){
        libraryService.addBook(new Book(title, author, description, ISBN, pages, year));
    }

    @GetMapping("/books/search")
    public List<Book> searchBooks(@RequestParam(name="title", required = false) String title,
                                  @RequestParam(name="isbn", required = false) String isbn){

        // This implementation prioritizes searching by isbn first
        if(isbn != null) {
            return libraryService.lookUpBookByIsbn(isbn);
        }else if(title != null) {
            return libraryService.lookUpBookByTitle(title);
        }
        //No valid parameter passed
        return List.of();
    }
}