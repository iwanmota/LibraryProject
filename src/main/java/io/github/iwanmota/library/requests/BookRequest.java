package io.github.iwanmota.library.requests;

public class BookRequest {

    private String title;
    private String author;
    private String description;
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
