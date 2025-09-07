package io.github.iwanmota.library.controllers;

import io.github.iwanmota.library.entities.Book;
import io.github.iwanmota.library.exceptions.BookNotFoundException;
import io.github.iwanmota.library.requests.BookRequest;
import io.github.iwanmota.library.services.LibraryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Tag(name="Library REST API Endpoints", description = "Operations related to books in this Library Service")
@RestController
@RequestMapping("/api/v1/books")
public class LibraryController {
    private final LibraryService libraryService;

    public LibraryController(LibraryService libraryService){
        this.libraryService = libraryService;
        initializeBooks();
    }

    public void initializeBooks() {
        libraryService.addBook(new Book("12345678", "The Great Gatsby", "F. Scott Fitzgerald", "A classic American novel about the Jazz Age", "978-0-321-56384-2", 180, 1925));
        libraryService.addBook(new Book("14432467","To Kill a Mockingbird", "Harper Lee", "A gripping tale of racial injustice and childhood innocence", "978-1-484-23147-5", 281, 1960));
        libraryService.addBook(new Book("23412243","1984", "George Orwell", "A dystopian social science fiction novel", "978-0-596-52068-7", 328, 1949));
        libraryService.addBook(new Book("87345123","Pride and Prejudice", "Jane Austen", "A romantic novel of manners", "0-13-149505-0", 432, 1813));
        libraryService.addBook(new Book("87456242","The Catcher in the Rye", "J.D. Salinger", "A controversial coming-of-age story", "0-201-89683-4", 277, 1951));
        libraryService.addBook(new Book("23466423","Lord of the Flies", "William Golding", "A novel about British boys stranded on an island", "0-735-61993-X", 224, 1954));
    }


    @Operation(summary = "Get all books, or filter by parameter", description = "Retrieves a list of all books in the library, or filters by optional request parameters")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<Book> getAllBooks(@Parameter(description = "Filter by title")
                                  @RequestParam(name="title", required = false) String title,
                                  @Parameter(description = "Filter by ISBN")
                                  @Pattern(regexp=BookRequest.ISBN_FORMAT_EXPRESSION)
                                  @RequestParam(name="isbn", required = false) String isbn,
                                  @Parameter(description = "Filter by ID")
                                  @Pattern(regexp=Book.ID_FORMAT_EXPRESSION)
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

    @Operation(summary = "Get a book by ID", description = "Retrieves a book by its ID")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public Book getBookById(@Parameter(description="Id of the book you want to retrieve", example="12345678")
                                @PathVariable @Pattern(regexp=Book.ID_FORMAT_EXPRESSION) String id) {
        return libraryService.lookUpBookById(id);
    }

    @Operation(summary = "Add a new book", description = "Adds a new book to the library")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping()
    public void addBook(@Valid @RequestBody BookRequest newBook) {
        String id = libraryService.newId();
        libraryService.addBook(convertToBook(id, newBook));

    }
    @Operation(summary = "Update a book", description = "Updates an existing book in the library")
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public Book updateBook(@Parameter(description = "ID of the book you want to update", example = "12345678")
                               @PathVariable @Pattern(regexp=Book.ID_FORMAT_EXPRESSION) String id, @Valid @RequestBody  BookRequest updatedBookRequest){
        if(id == null || id.isEmpty() || libraryService.lookUpBookById(id) == null){
            throw new BookNotFoundException("Book Not Found, Id: " + id);
        }
        return libraryService.updateBookById(id, updatedBookRequest);

//        libraryService.getAllBooks().stream()
//                .filter(book -> book.getId().equalsIgnoreCase(id))
//                .findFirst()
//                .ifPresentOrElse(book -> libraryService.updateBook(libraryService.getAllBooks().indexOf(book), convertToBook(id, updatedBookRequest)),
//                        () -> throw new BookNotFoundException("Book Not Found, Id: " + id));
    }

    @Operation(summary = "Delete a book", description = "Deletes a book from the library")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteBook(@Parameter(description = "ID of the book you want to delete", example = "12345678")
                               @PathVariable @Pattern(regexp=Book.ID_FORMAT_EXPRESSION) String id){
        if(id == null || id.isEmpty() || libraryService.lookUpBookById(id) == null){
            throw new BookNotFoundException("Book Not Found, Id: " + id);
        }
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


}