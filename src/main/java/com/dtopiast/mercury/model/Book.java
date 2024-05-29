package com.dtopiast.mercury.model;

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
    private ArrayList < Lenguaje > languages = new ArrayList < Lenguaje > ();
    @Enumerated(EnumType.STRING)
    private ArrayList<MediaTypeFormat> formats  = new ArrayList<MediaTypeFormat>();

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

    public ArrayList<MediaTypeFormat> getFormats() {
        return formats;
    }

    public void setFormats(ArrayList<MediaTypeFormat> formats) {
        this.formats = formats;
    }

    public boolean isCopyright() {
        return copyright;
    }

    public void setCopyright(boolean copyright) {
        this.copyright = copyright;
    }
}