package io.github.iwanmota.library.model;

public class Book {

    private String title;
    private String author;
    private String description;
    private int ISBN;
    private int pages;
    private int year;
    
    public Book(String title, String author, String description, int ISBN, int pages, int year) {
        this.title = title;
        this.author = author;
        this.description = description;
        this.ISBN = ISBN;
        this.pages = pages;
        this.year = year;
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
    public int getISBN(){
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
    public void setISBN(int ISBN){
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
            this.ISBN == otherBook.ISBN &&
            this.pages == otherBook.pages &&
            this.year == otherBook.year
        ;
        
    }


}
