package io.github.iwanmota.library.services;

import io.github.iwanmota.library.entities.Book;
import io.github.iwanmota.library.exceptions.BookErrorResponse;
import io.github.iwanmota.library.exceptions.BookNotFoundException;
import io.github.iwanmota.library.requests.BookRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.OptionalInt;
import java.util.stream.IntStream;

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

    public List<Book> lookUpBookByTitle(String title){
        return this.books.stream()
                .filter(x -> x.getTitle().equalsIgnoreCase(title))
                .toList();
    }
    public List<Book> lookUpBookByIsbn(String isbn){
        return this.books.stream()
                .filter(x -> x.getISBN().equalsIgnoreCase(isbn))
                .toList();
    }
    public Book lookUpBookById(String id) {
        return this.books.stream()
                .filter(x -> x.getId().equalsIgnoreCase(id))
                .findFirst()
                .orElseThrow(() -> new BookNotFoundException("Book Not Found, Id: " + id));
    }
    public Book updateBookById(String id, BookRequest bookRequest) {
        OptionalInt indexOptional =  IntStream.range(0, this.books.size())
                .filter(i -> this.books.get(i).getId().equalsIgnoreCase(id))
                .findFirst();
        if(indexOptional.isPresent()){
            Book book = new Book(id,
                    bookRequest.getTitle(),
                    bookRequest.getAuthor(),
                    bookRequest.getDescription(),
                    bookRequest.getISBN(),
                    bookRequest.getPages(),
                    bookRequest.getYear());
            this.books.set(indexOptional.getAsInt(), book);
            return book;
        }
        else {
            throw new BookNotFoundException("Book Not Found, Id: " + id);
        }
    }

    public List<Book> getAllBooks(){
        return this.books;
    }

    public String newId() {
        String input = books.size() + System.currentTimeMillis() + 
                       books.stream().mapToInt(Book::hashCode).sum() + "";
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(input.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.substring(0, 8);
        } catch (NoSuchAlgorithmException e) {
            return String.valueOf(input.hashCode()).replace("-", "");
        }
    }

}
