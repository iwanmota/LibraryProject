package io.github.iwanmota.library.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    private Book book;

    @BeforeEach
    void setUp() {
        book = new Book("1984", "George Orwell", "Dystopian novel", 123456789, 328, 1949);
    }

    @Test
    void testConstructorAndGetters() {
        assertEquals("1984", book.getTitle());
        assertEquals("George Orwell", book.getAuthor());
        assertEquals("Dystopian novel", book.getDescription());
        assertEquals(123456789, book.getISBN());
        assertEquals(328, book.getPages());
        assertEquals(1949, book.getYear());
    }

    @Test
    void testSetters() {
        book.setTitle("Animal Farm");
        book.setAuthor("G. Orwell");
        book.setDescription("Political satire");
        book.setISBN(987654321);
        book.setPages(112);
        book.setYear(1945);

        assertEquals("Animal Farm", book.getTitle());
        assertEquals("G. Orwell", book.getAuthor());
        assertEquals("Political satire", book.getDescription());
        assertEquals(987654321, book.getISBN());
        assertEquals(112, book.getPages());
        assertEquals(1945, book.getYear());
    }

    @Test
    void testToString() {
        String expected = "Book [title=1984, author=George Orwell, description=Dystopian novel, ISBN=123456789, pages=328]";
        assertEquals(expected, book.toString());
    }

    @Test
    void testEqualsWithSameObject() {
        assertTrue(book.equals(book));
    }

    @Test
    void testEqualsWithIdenticalBook() {
        Book identicalBook = new Book("1984", "George Orwell", "Dystopian novel", 123456789, 328, 1949);
        assertTrue(book.equals(identicalBook));
    }

    @Test
    void testEqualsWithDifferentTitle() {
        Book differentBook = new Book("Animal Farm", "George Orwell", "Dystopian novel", 123456789, 328, 1949);
        assertFalse(book.equals(differentBook));
    }

    @Test
    void testEqualsWithDifferentAuthor() {
        Book differentBook = new Book("1984", "Aldous Huxley", "Dystopian novel", 123456789, 328, 1949);
        assertFalse(book.equals(differentBook));
    }

    @Test
    void testEqualsWithNull() {
        assertFalse(book.equals(null));
    }

    @Test
    void testEqualsWithDifferentClass() {
        assertFalse(book.equals("Not a book"));
    }
}