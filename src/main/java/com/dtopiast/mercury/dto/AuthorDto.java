package com.dtopiast.mercury.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class AuthorDto {
    private final String Name;
    private final int birthYear;
    private final int deathYear;
    private List<BookDto> books;

    public <bookDto> AuthorDto(String Name,
                               int birthYear,
                               int deathYear,
                               List<BookDto>books) {
        this.Name = Name;
        this.birthYear = birthYear;
        this.deathYear = deathYear;
        this.books = books;
    }
    public <bookDto> AuthorDto(String Name,
                               int birthYear,
                               int deathYear) {
        this.Name = Name;
        this.birthYear = birthYear;
        this.deathYear = deathYear;
    }

    public String Name() {
        return Name;
    }

    public int birthYear() {
        return birthYear;
    }

    public int deathYear() {
        return deathYear;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (AuthorDto) obj;
        return Objects.equals(this.Name, that.Name) &&
                this.birthYear == that.birthYear &&
                this.deathYear == that.deathYear;
    }

    @Override
    public int hashCode() {
        return Objects.hash(Name, birthYear, deathYear);
    }

    @Override
    public String toString() {
        return "AuthorDto[" +
                "Name=" + Name + ", " +
                "birthYear=" + birthYear + ", " +
                "deathYear=" + deathYear + ']';
    }


    public List<BookDto> getBooks() {
        return books;
    }

    public void setBooks(List<BookDto> books) {
        this.books = books;
    }
}
