package io.github.iwanmota.library.service;

import io.github.iwanmota.library.model.Book;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class LibraryService {
    private List<Book> books = new ArrayList<>();

    public LibraryService(){
        this.books = new ArrayList<>();
    }
    public void addBook(Book book){
        if(!this.books.contains(book)) {
            this.books.add(book);
        }
    }

    public List<Book> lookUpBookByTitle(String title){
        return this.books.stream()
                .filter(x -> x.getTitle().equals(title))
                .toList();
    }
    public List<Book> getAllBooks(){
        return new ArrayList<>(this.books);
    }

}
