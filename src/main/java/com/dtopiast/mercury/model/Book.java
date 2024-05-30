package com.dtopiast.mercury.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
    private ArrayList <Languaje> languages = new ArrayList <Languaje> ();
    @JsonAlias("formats")
    private Map<String, String> formats = new HashMap<String, String>();
    private boolean copyright;

    @JsonAlias("download_count")
    private long donwloads;
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

    public ArrayList<Languaje> getLanguages() {
        return languages;
    }

    public void setLanguages(ArrayList<Languaje> languages) {
        this.languages = languages;
    }
    public boolean isCopyright() {
        return copyright;
    }

    public void setCopyright(boolean copyright) {
        this.copyright = copyright;
    }

    public Map<String, String> getFormats() {
        return formats;
    }

    public void setFormats(Map<String, String> formats) {
        this.formats = formats;
    }

    public long getDonwloads() {
        return donwloads;
    }

    public void setDonwloads(long donwloads) {
        this.donwloads = donwloads;
    }
}