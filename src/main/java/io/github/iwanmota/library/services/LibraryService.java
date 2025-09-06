package io.github.iwanmota.library.services;

import io.github.iwanmota.library.entities.Book;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class LibraryService {
    private final List<Book> books;

    public LibraryService(){
        this.books = new ArrayList<>();
    }
    public void addBook(Book book){
        if(!this.books.contains(book)) {
            this.books.add(book);
        }
    }

    public void updateBook(int index, Book book){
        this.books.set(index, book);
    }

    public void deleteBook(int index){
        this.books.remove(index);

    }

    public Book lookUpBookByTitle(String title){
        return this.books.stream()
                .filter(x -> x.getTitle().equalsIgnoreCase(title))
                .findFirst()
                .orElse(null);
    }
    public Book lookUpBookByIsbn(String isbn){
        return this.books.stream()
                .filter(x -> x.getTitle().equalsIgnoreCase(isbn))
                .findFirst()
                .orElse(null);
    }
    public List<Book> getAllBooks(){
        return this.books;
    }

}
