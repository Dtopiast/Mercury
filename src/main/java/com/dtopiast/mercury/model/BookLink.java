package com.dtopiast.mercury.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
@Entity
@Table(name = "bookLink")
@JsonIgnoreProperties(ignoreUnknown = true)
public class BookLink {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private MediaTypeFormat format;
    private String link;

    public BookLink(MediaTypeFormat format, String link) {
        this.format = format;
        this.link = link;
    }

    public MediaTypeFormat getFormat() {
        return format;
    }

    public void setFormat(MediaTypeFormat format) {
        this.format = format;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return "Formato: " + format + ", Enlace: " + link;
    }

}
