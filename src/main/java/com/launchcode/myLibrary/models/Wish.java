package com.launchcode.myLibrary.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Wish {
    @Id
    @GeneratedValue
    private int id;

    @Size(min=2, max=100)
    @NotNull
    private String titlebook;

    @Size(min=3, max=75)
    @NotNull
    private String author;

    @Size(min=3, max=20)
    @NotNull
    private String genre;

    public Wish() {

    }

    public Wish(String titlebook, String author, String genre) {
        this.titlebook = titlebook;
        this.author = author;
        this.genre = genre;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}

