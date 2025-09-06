package io.github.iwanmota.library.entities;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    private Book book;

    @BeforeEach
    void setUp() {
        book = new Book("1", "1984", "George Orwell", "Dystopian novel", "978-0134685991", 328, 1949);
    }

    @Test
    void testConstructorAndGetters() {
        assertEquals("1", book.getId());
        assertEquals("1984", book.getTitle());
        assertEquals("George Orwell", book.getAuthor());
        assertEquals("Dystopian novel", book.getDescription());
        assertEquals("978-0134685991", book.getISBN());
        assertEquals(328, book.getPages());
        assertEquals(1949, book.getYear());
    }

    @Test
    void testSetters() {
        book.setId("2");
        book.setTitle("Animal Farm");
        book.setAuthor("G. Orwell");
        book.setDescription("Political satire");
        book.setISBN("978-0134685992");
        book.setPages(112);
        book.setYear(1945);

        assertEquals("2", book.getId());
        assertEquals("Animal Farm", book.getTitle());
        assertEquals("G. Orwell", book.getAuthor());
        assertEquals("Political satire", book.getDescription());
        assertEquals("978-0134685992", book.getISBN());
        assertEquals(112, book.getPages());
        assertEquals(1945, book.getYear());
    }

    @Test
    void testToString() {
        String expected = "Book [title=1984, author=George Orwell, description=Dystopian novel, ISBN=978-0134685991, pages=328]";
        assertEquals(expected, book.toString());
    }

    @Test
    void testEqualsWithSameObject() {
        assertEquals(book, book);
    }

    @Test
    void testEqualsWithIdenticalBook() {
        Book identicalBook = new Book("1", "1984", "George Orwell", "Dystopian novel", "978-0134685991", 328, 1949);
        assertEquals(book, identicalBook);
    }

    @Test
    void testEqualsWithDifferentTitle() {
        Book differentBook = new Book("1", "Animal Farm", "George Orwell", "Dystopian novel", "978-0134685991", 328, 1949);
        assertNotEquals(book, differentBook);
    }

    @Test
    void testEqualsWithDifferentAuthor() {
        Book differentBook = new Book("1", "1984", "Aldous Huxley", "Dystopian novel", "978-0134685991", 328, 1949);
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
        Book identicalBook = new Book("1", "1984", "George Orwell", "Dystopian novel", "978-0134685991", 328, 1949);
        assertEquals(book.hashCode(), identicalBook.hashCode());
    }
}