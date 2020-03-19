package com.launchcode.myLibrary.models;

public class Book {
    private String titlebook;
    private String author;
    private String genre;
    private String read1;
    private String rating;

    public Book(String titlebook, String author, String genre, String read1, String rating) {
        this.titlebook = titlebook;
        this.author = author;
        this.genre = genre;
        this.read1 = read1;
        this.rating = rating;
    }

    public String getTitlebook() {
        return titlebook;
    }

    public void setTitlebook(String titlebook) {
        this.titlebook = titlebook;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getRead1() {
        return read1;
    }

    public void setRead1(String read1) {
        this.read1 = read1;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
