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
    private final long downloads;
    public BookDto(String title,
                   ArrayList<AuthorDto> authors,
                   ArrayList<String> subjects,
                   ArrayList<String> bookshelves,
                   ArrayList<String> languages,
                   ArrayList<String> formats,
                   boolean copyright,
                   long downloads) {
        this.title = title;
        this.authors = authors;
        this.subjects = subjects;
        this.bookshelves = bookshelves;
        this.languages = languages;
        this.formats = formats;
        this.copyright = copyright;
        this.downloads = downloads;
    }
    public BookDto(String title,
                   ArrayList<String> subjects,
                   ArrayList<String> bookshelves,
                   ArrayList<String> languages,
                   ArrayList<String> formats,
                   boolean copyright,
                   long downloads) {
        this.title = title;
        this.subjects = subjects;
        this.bookshelves = bookshelves;
        this.languages = languages;
        this.formats = formats;
        this.copyright = copyright;
        this.downloads = downloads;
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
        return Objects.hash(title, authors, subjects, bookshelves, languages, formats, copyright,downloads);
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
                "copyright=" + copyright + ", "+
                "downloads=" + downloads + ']'  ;
    }

    public long getDownloads() {
        return downloads;
    }
}
