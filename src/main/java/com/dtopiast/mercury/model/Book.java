package com.dtopiast.mercury.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.ArrayList;

@Entity
@Table(name = "book")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @ManyToMany(mappedBy = "authors")
    private ArrayList<Author> authors = new ArrayList <Author> ();
    private  ArrayList < String > subjects = new ArrayList < String > ();
    private ArrayList <String > bookshelves = new ArrayList < String > ();
    @Enumerated(EnumType.STRING)
    @JsonAlias("languages")
    private ArrayList < Lenguaje > languages = new ArrayList < Lenguaje > ();
    @JsonAlias("formats")
    private ArrayList<BookLink> bookLinks  = new ArrayList<BookLink>();

    private boolean copyright;


    public float getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(ArrayList<Author> authors) {
        this.authors = authors;
    }
    public ArrayList<String> getSubjects() {
        return subjects;
    }

    public void setSubjects(ArrayList<String> subjects) {
        this.subjects = subjects;
    }

    public ArrayList<String> getBookshelves() {
        return bookshelves;
    }

    public void setBookshelves(ArrayList<String> bookshelves) {
        this.bookshelves = bookshelves;
    }

    public ArrayList<Lenguaje> getLanguages() {
        return languages;
    }

    public void setLanguages(ArrayList<Lenguaje> languages) {
        this.languages = languages;
    }
    public boolean isCopyright() {
        return copyright;
    }

    public void setCopyright(boolean copyright) {
        this.copyright = copyright;
    }

    public ArrayList<BookLink> getBookLinks() {
        return bookLinks;
    }

    public void setBookLinks(ArrayList<BookLink> bookLinks) {
        this.bookLinks = bookLinks;
    }
}