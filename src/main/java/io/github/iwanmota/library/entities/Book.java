package io.github.iwanmota.library.entities;


import java.util.Objects;

public class Book {

//    public static final String ISBN_FORMAT_EXPRESSION = "^(?:ISBN(?:-1[03])?:? )?(?=[0-9X]{10}$|(?=(?:[0-9]+[- ]){3})[- 0-9X]{13}$|97[89][0-9]{10}$|(?=(?:[0-9]+[- ]){4})[- 0-9]{17}$)(?:97[89][- ]?)?[0-9]{1,5}[- ]?[0-9]+[- ]?[0-9]+[- ]?[0-9X]$";
    public static final String ID_FORMAT_EXPRESSION = "^[0-9A-Fa-f]{8}$";


    //@Pattern(regexp = ID_FORMAT_EXPRESSION, message = "Must be an 8-digit hexadecimal value")
    private String id;

    private String title;
    private String author;
    private String description;

//    @Pattern(regexp=ISBN_FORMAT_EXPRESSION, message="Invalid ISBN format")
    private String ISBN;
    private int pages;
    private int year;

    public Book(String id, String title, String author, String description, String ISBN, int pages, int year) {
//        if (!ISBN.matches(ISBN_FORMAT_EXPRESSION)) {
//            throw new IllegalArgumentException("Invalid ISBN format: " + ISBN);
//        }
//        if (!id.matches(ID_FORMAT_EXPRESSION)) {
//            throw new IllegalArgumentException("Invalid ID format: " + id);
//        }
        this.id = id;
        this.title = title;
        this.author = author;
        this.description = description;
        this.ISBN = ISBN;
        this.pages = pages;
        this.year = year;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }    
    public String getAuthor(){
        return this.author;
    }
    public String getDescription(){
        return this.description;
    }    
    public String getISBN(){
        return this.ISBN;
    }
    public int getPages(){
        return this.pages;
    }
    public int getYear(){
        return this.year;
    }
    
    public void setTitle(String title){
        this.title = title;
    }
    public void setAuthor(String author){
        this.author = author;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public void setISBN(String ISBN){
        this.ISBN = ISBN;
    }
    public void setPages(int pages){
        this.pages = pages;
    }
    public void setYear(int year){
        this.year = year;
    }

    @Override
    public String toString(){
        return "Book [title=" + title + ", author=" + author + ", description=" + description + ", ISBN=" + ISBN + ", pages=" + pages + "]";
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj) return true;
        if(obj == null || this.getClass() != obj.getClass()) return false;

        Book otherBook = (Book) obj;
        return
            this.author.equals(otherBook.author) &&
            this.title.equals(otherBook.title) &&
            this.description.equals(otherBook.description) &&
            this.ISBN.equals(otherBook.ISBN) &&
            this.pages == otherBook.pages &&
            this.year == otherBook.year
        ;
    }

    @Override
    public int hashCode(){
        return Objects.hash(author, title, description, ISBN, pages, year);
    }


}
