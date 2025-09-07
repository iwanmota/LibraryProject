package io.github.iwanmota.library.requests;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

//@Validated
public class BookRequest {

    public static final String ISBN_FORMAT_EXPRESSION = "^(?:ISBN(?:-1[03])?:? )?(?=[0-9X]{10}$|(?=(?:[0-9]+[- ]){3})[- 0-9X]{13}$|97[89][0-9]{10}$|(?=(?:[0-9]+[- ]){4})[- 0-9]{17}$)(?:97[89][- ]?)?[0-9]{1,5}[- ]?[0-9]+[- ]?[0-9]+[- ]?[0-9X]$";
//    public static final String ID_FORMAT_EXPRESSION = "^[0-9A-Fa-f]{8}$";

    @Size(min=5, max=100, message="Title must be between 5 and 100 characters")
    private String title;

    @Size(min=5, max=100, message="Author must be between 5 and 100 characters")
    private String author;

    @Size(min=5, max=150, message="Description must be between 5 and 150 characters")
    private String description;

    @Pattern(regexp = ISBN_FORMAT_EXPRESSION, message="ISBN must follow the ISBN convention")
    private String ISBN;
    private int pages;
    private int year;

    public BookRequest(String title, String author, String description, String ISBN, int pages, int year) {
        this.title = title;
        this.author = author;
        this.description = description;
        this.ISBN = ISBN;
        this.pages = pages;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
