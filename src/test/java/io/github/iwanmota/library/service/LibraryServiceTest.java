package io.github.iwanmota.library.service;

import io.github.iwanmota.library.model.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LibraryServiceTest {

    private LibraryService libraryService;
    private Book book1;
    private Book book2;
    private Book book3;

    @BeforeEach
    void setUp() {
        libraryService = new LibraryService();
        book1 = new Book("Java Programming", "John Doe", "Learn Java", "978-0134685991", 500, 2020);
        book2 = new Book("Spring Boot", "Jane Smith", "Spring Boot Guide", "978-1617294945", 400, 2021);
        book3 = new Book("Java Programming", "Bob Johnson", "Another Java Book", "978-0321356680", 300, 2019);
    }

    @Test
    void testConstructor() {
        LibraryService service = new LibraryService();
        assertNotNull(service);
        assertTrue(service.getAllBooks().isEmpty());
    }

    @Test
    void testAddBook() {
        libraryService.addBook(book1);
        
        List<Book> books = libraryService.getAllBooks();
        assertEquals(1, books.size());
        assertTrue(books.contains(book1));
    }

    @Test
    void testAddMultipleBooks() {
        libraryService.addBook(book1);
        libraryService.addBook(book2);
        
        List<Book> books = libraryService.getAllBooks();
        assertEquals(2, books.size());
        assertTrue(books.contains(book1));
        assertTrue(books.contains(book2));
    }

    @Test
    void testAddDuplicateBook() {
        libraryService.addBook(book1);
        libraryService.addBook(book1);
        
        List<Book> books = libraryService.getAllBooks();
        assertEquals(1, books.size());
    }

    @Test
    void testLookUpBookByTitle() {
        libraryService.addBook(book1);
        libraryService.addBook(book2);
        libraryService.addBook(book3);
        
        List<Book> javaBooks = libraryService.lookUpBookByTitle("Java Programming");
        assertEquals(2, javaBooks.size());
        assertTrue(javaBooks.contains(book1));
        assertTrue(javaBooks.contains(book3));
    }

    @Test
    void testLookUpBookByTitleNotFound() {
        libraryService.addBook(book1);
        
        List<Book> books = libraryService.lookUpBookByTitle("Nonexistent Book");
        assertTrue(books.isEmpty());
    }

    @Test
    void testLookUpBookByTitleEmptyLibrary() {
        List<Book> books = libraryService.lookUpBookByTitle("Any Title");
        assertTrue(books.isEmpty());
    }

    @Test
    void testGetAllBooksEmpty() {
        List<Book> books = libraryService.getAllBooks();
        assertNotNull(books);
        assertTrue(books.isEmpty());
    }

    @Test
    void testGetAllBooksReturnsDefensiveCopy() {
        libraryService.addBook(book1);
        
        List<Book> books = libraryService.getAllBooks();
        books.clear();
        
        List<Book> booksAfterClear = libraryService.getAllBooks();
        assertEquals(1, booksAfterClear.size());
        assertTrue(booksAfterClear.contains(book1));
    }
}