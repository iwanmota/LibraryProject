package io.github.iwanmota.library.services;

import io.github.iwanmota.library.entities.Book;
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
        book1 = new Book("a1b2c3d4", "Java Programming", "John Doe", "Learn Java", "978-0-321-56384-2", 500, 2020);
        book2 = new Book("ff8844e2", "Spring Boot", "Jane Smith", "Spring Boot Guide", "978-1-484-23147-5", 400, 2021);
        book3 = new Book("12345678", "Java Programming", "Bob Johnson", "Another Java Book", "0-13-149505-0", 300, 2019);
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
    void testLookUpBookByIsbn() {
        libraryService.addBook(book1);
        libraryService.addBook(book2);
        
        List<Book> books = libraryService.lookUpBookByIsbn("978-0-321-56384-2");
        assertEquals(1, books.size());
        assertTrue(books.contains(book1));
    }

    @Test
    void testLookUpBookById() {
        libraryService.addBook(book1);
        
        Book foundBook = libraryService.lookUpBookById(book1.getId());
        assertEquals(book1, foundBook);
    }

    @Test
    void testUpdateBook() {
        libraryService.addBook(book1);
        Book updatedBook = new Book("dcba9876", "Updated Title", "Updated Author", "Updated Description", "978-0-596-52068-7", 600, 2023);

        libraryService.updateBook(0, updatedBook);
        
        List<Book> books = libraryService.getAllBooks();
        assertEquals(updatedBook, books.getFirst());
    }

    @Test
    void testDeleteBook() {
        libraryService.addBook(book1);
        libraryService.addBook(book2);
        
        libraryService.deleteBook(0);
        
        List<Book> books = libraryService.getAllBooks();
        assertEquals(1, books.size());
        assertFalse(books.contains(book1));
        assertTrue(books.contains(book2));
    }

    @Test
    void testGetAllBooksEmpty() {
        List<Book> books = libraryService.getAllBooks();
        assertNotNull(books);
        assertTrue(books.isEmpty());
    }


}