package io.github.iwanmota.library.controllers;

import io.github.iwanmota.library.entities.Book;
import io.github.iwanmota.library.requests.BookRequest;
import io.github.iwanmota.library.services.LibraryService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
public class LibraryController {
    private final LibraryService libraryService;

    public LibraryController(LibraryService libraryService){
        this.libraryService = libraryService;
        initializeBooks();
    }

    public void initializeBooks() {
        libraryService.addBook(new Book("123456", "The Great Gatsby", "F. Scott Fitzgerald", "A classic American novel about the Jazz Age", "9780743273565", 180, 1925));
        libraryService.addBook(new Book("144324","To Kill a Mockingbird", "Harper Lee", "A gripping tale of racial injustice and childhood innocence", "9780061120084", 281, 1960));
        libraryService.addBook(new Book("234122","1984", "George Orwell", "A dystopian social science fiction novel", "9780451524935", 328, 1949));
        libraryService.addBook(new Book("873451","Pride and Prejudice", "Jane Austen", "A romantic novel of manners", "9780141439518", 432, 1813));
        libraryService.addBook(new Book("874562","The Catcher in the Rye", "J.D. Salinger", "A controversial coming-of-age story", "9780316769174", 277, 1951));
        libraryService.addBook(new Book("234664","Lord of the Flies", "William Golding", "A novel about British boys stranded on an island", "9780571056866", 224, 1954));
    }


    @GetMapping
    public List<Book> getAllBooks(@RequestParam(name="title", required = false) String title,
                                  @RequestParam(name="isbn", required = false) String isbn,
                                  @RequestParam(name="id", required = false) String id) {
        // This implementation prioritizes searching by isbn first
        if(id != null) {
            //TODO Clean this up due to isbn only returning a single book
            List<Book> books = new ArrayList<>();
            books.add(libraryService.lookUpBookById(id));
            return books;
        }else if(title != null) {
            return libraryService.lookUpBookByTitle(title);
        }else if(isbn != null) {
            return libraryService.lookUpBookByIsbn(isbn);
        }
        return libraryService.getAllBooks();
    }

    @PostMapping("/add")
    public void addBook(@RequestBody BookRequest newBook) {
        String id = libraryService.newId();
        libraryService.addBook(convertToBook(id, newBook));

    }

    @PutMapping("/update/{id}")
    public void updateBook(@PathVariable String id, @RequestBody BookRequest updatedBookRequest){
        libraryService.getAllBooks().stream()
                .filter(book -> book.getId().equalsIgnoreCase(id))
                .findFirst()
                .ifPresent(book -> libraryService.updateBook(libraryService.getAllBooks().indexOf(book), convertToBook(id, updatedBookRequest)));
    }

    @DeleteMapping("/delete/{id}")
    public void deleteBook(@PathVariable String id){
        libraryService.getAllBooks().stream()
                .filter(book -> book.getId().equalsIgnoreCase(id))
                .findFirst()
                .ifPresent(book -> libraryService.deleteBook(libraryService.getAllBooks().indexOf(book)));
    }

    private Book convertToBook(String id, BookRequest bookRequest) {
        return new Book(id,
                bookRequest.getTitle(),
                bookRequest.getAuthor(),
                bookRequest.getDescription(),
                bookRequest.getISBN(),
                bookRequest.getPages(),
                bookRequest.getYear());
    }

//    @GetMapping("/search")
//    public Book searchBooks(@RequestParam(name="title", required = false) String title,
//                            @RequestParam(name="isbn", required = false) String isbn,
//                            @RequestParam(name="id", required = false) String id){
//
//        // This implementation prioritizes searching by isbn first
//        if(isbn != null) {
//            return libraryService.lookUpBookByIsbn(isbn);
//        }else if(title != null) {
//            return libraryService.lookUpBookByTitle(title);
//        }else if(id != null) {
//            return libraryService.lookUpBookById(id);
//        }
//        //No valid parameter passed
//        return null;
//    }
}