package com.launchcode.myLibrary.models;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Book {
    @Size(min=2, max=100)
    @NotNull
    private String titlebook;

    @Size(min=3, max=75)
    @NotNull
    private String author;

    @Size(min=3, max=20)
    @NotNull
    private String genre;

    @Size(min=3,max=10)
    @NotNull
    private String read1;

    @Max(5)
    @NotNull
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
