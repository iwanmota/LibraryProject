package io.github.iwanmota.library.entities;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    private Book book;

    @BeforeEach
    void setUp() {
        book = new Book("a1b2c3d4", "1984", "George Orwell", "Dystopian novel", "978-1-484-23147-5", 328, 1949);
    }

    @Test
    void testConstructorAndGetters() {
        assertEquals("a1b2c3d4", book.getId());
        assertEquals("1984", book.getTitle());
        assertEquals("George Orwell", book.getAuthor());
        assertEquals("Dystopian novel", book.getDescription());
        assertEquals("978-1-484-23147-5", book.getISBN());
        assertEquals(328, book.getPages());
        assertEquals(1949, book.getYear());
    }

    @Test
    void testSetters() {
        book.setId("2");
        book.setTitle("Animal Farm");
        book.setAuthor("G. Orwell");
        book.setDescription("Political satire");
        book.setISBN("978-1-484-23147-5");
        book.setPages(112);
        book.setYear(1945);

        assertEquals("2", book.getId());
        assertEquals("Animal Farm", book.getTitle());
        assertEquals("G. Orwell", book.getAuthor());
        assertEquals("Political satire", book.getDescription());
        assertEquals("978-1-484-23147-5", book.getISBN());
        assertEquals(112, book.getPages());
        assertEquals(1945, book.getYear());
    }

    @Test
    void testToString() {
        String expected = "Book [title=1984, author=George Orwell, description=Dystopian novel, ISBN=978-1-484-23147-5, pages=328]";
        assertEquals(expected, book.toString());
    }

    @Test
    void testEqualsWithSameObject() {
        assertEquals(book, book);
    }

    @Test
    void testEqualsWithIdenticalBook() {
        Book identicalBook = new Book("a1b2c3d4", "1984", "George Orwell", "Dystopian novel", "978-1-484-23147-5", 328, 1949);
        assertEquals(book, identicalBook);
    }

    @Test
    void testEqualsWithDifferentTitle() {
        Book differentBook = new Book("a1b2c3d4", "Animal Farm", "George Orwell", "Dystopian novel", "978-1-484-23147-5", 328, 1949);
        assertNotEquals(book, differentBook);
    }

    @Test
    void testEqualsWithDifferentAuthor() {
        Book differentBook = new Book("a1b2c3d4", "1984", "Aldous Huxley", "Dystopian novel", "978-1-484-23147-5", 328, 1949);
        assertNotEquals(book, differentBook);
    }

    @Test
    void testEqualsWithNull() {
        assertNotEquals(null, book);
    }

    @Test
    void testEqualsWithDifferentClass() {
        assertNotEquals("Not a book", book);
    }

    @Test
    void testHashCodeConsistency() {
        Book identicalBook = new Book("a1b2c3d4", "1984", "George Orwell", "Dystopian novel", "978-1-484-23147-5", 328, 1949);
        assertEquals(book.hashCode(), identicalBook.hashCode());
    }

    @Test
    void testConstructorWithInvalidISBN() {
        assertThrows(IllegalArgumentException.class, () -> new Book("2", "Test Book", "Test Author", "Test Description", "invalid-isbn", 100, 2023));
    }
}