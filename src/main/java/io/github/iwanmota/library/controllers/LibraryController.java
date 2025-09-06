package io.github.iwanmota.library.controllers;

import io.github.iwanmota.library.entities.Book;
import io.github.iwanmota.library.services.LibraryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class LibraryController {
    private final LibraryService libraryService;

    public LibraryController(LibraryService libraryService){
        this.libraryService = libraryService;
        initializeBooks();
    }

    public void initializeBooks() {
        libraryService.addBook(new Book("The Great Gatsby", "F. Scott Fitzgerald", "A classic American novel about the Jazz Age", "9780743273565", 180, 1925));
        libraryService.addBook(new Book("To Kill a Mockingbird", "Harper Lee", "A gripping tale of racial injustice and childhood innocence", "9780061120084", 281, 1960));
        libraryService.addBook(new Book("1984", "George Orwell", "A dystopian social science fiction novel", "9780451524935", 328, 1949));
        libraryService.addBook(new Book("Pride and Prejudice", "Jane Austen", "A romantic novel of manners", "9780141439518", 432, 1813));
        libraryService.addBook(new Book("The Catcher in the Rye", "J.D. Salinger", "A controversial coming-of-age story", "9780316769174", 277, 1951));
        libraryService.addBook(new Book("Lord of the Flies", "William Golding", "A novel about British boys stranded on an island", "9780571056866", 224, 1954));
    }


        @GetMapping("/books")
    public List<Book> getAllBooks(){
        return libraryService.getAllBooks();
    }

    @PostMapping("/books/add")
    public void addBook(@RequestBody Book newBook) {
        boolean isNotPresent = libraryService.getAllBooks().stream()
                .noneMatch(book -> book.getTitle().equals(newBook.getTitle()));
        if (isNotPresent) {
            libraryService.addBook(newBook);
        } else {
            throw new IllegalArgumentException("Book already exists");
        }
    }

    @GetMapping("/books/search")
    public Book searchBooks(@RequestParam(name="title", required = false) String title,
                                  @RequestParam(name="isbn", required = false) String isbn){

        // This implementation prioritizes searching by isbn first
        if(isbn != null) {
            return libraryService.lookUpBookByIsbn(isbn);
        }else if(title != null) {
            return libraryService.lookUpBookByTitle(title);
        }
        //No valid parameter passed
        return null;
    }
}