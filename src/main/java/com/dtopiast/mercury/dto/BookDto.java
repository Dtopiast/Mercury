package com.dtopiast.mercury.dto;
import java.util.ArrayList;
import java.util.Objects;

public final class BookDto {
    private final String title;
    private ArrayList<AuthorDto> authors;
    private final ArrayList<String> subjects;
    private final ArrayList<String> bookshelves;
    private final ArrayList<String> languages;
    private final ArrayList<String> formats;
    private final boolean copyright;

    public BookDto(String title,
                   ArrayList<AuthorDto> authors,
                   ArrayList<String> subjects,
                   ArrayList<String> bookshelves,
                   ArrayList<String> languages,
                   ArrayList<String> formats,
                   boolean copyright) {
        this.title = title;
        this.authors = authors;
        this.subjects = subjects;
        this.bookshelves = bookshelves;
        this.languages = languages;
        this.formats = formats;
        this.copyright = copyright;
    }
    public BookDto(String title,
                   ArrayList<String> subjects,
                   ArrayList<String> bookshelves,
                   ArrayList<String> languages,
                   ArrayList<String> formats,
                   boolean copyright) {
        this.title = title;
        this.subjects = subjects;
        this.bookshelves = bookshelves;
        this.languages = languages;
        this.formats = formats;
        this.copyright = copyright;
    }

    public String title() {
        return title;
    }

    public ArrayList<AuthorDto> authors() {
        return authors;
    }

    public ArrayList<String> subjects() {
        return subjects;
    }

    public ArrayList<String> bookshelves() {
        return bookshelves;
    }

    public ArrayList<String> languages() {
        return languages;
    }

    public ArrayList<String> formats() {
        return formats;
    }

    public boolean copyright() {
        return copyright;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (BookDto) obj;
        return Objects.equals(this.title, that.title) &&
                Objects.equals(this.authors, that.authors) &&
                Objects.equals(this.subjects, that.subjects) &&
                Objects.equals(this.bookshelves, that.bookshelves) &&
                Objects.equals(this.languages, that.languages) &&
                Objects.equals(this.formats, that.formats) &&
                this.copyright == that.copyright;
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, authors, subjects, bookshelves, languages, formats, copyright);
    }

    @Override
    public String toString() {
        return "BookDto[" +
                "title=" + title + ", " +
                "authors=" + authors + ", " +
                "subjects=" + subjects + ", " +
                "bookshelves=" + bookshelves + ", " +
                "languages=" + languages + ", " +
                "formats=" + formats + ", " +
                "copyright=" + copyright + ']';
    }
}
