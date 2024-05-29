package com.dtopiast.mercury.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public enum MediaTypeFormat {
    Html("text/html"),
    EPUB("application/epub+zip"),
    XMOOBI("application/x-mobipocket-ebook"),
    JPEG("image/jpeg"),
    OCTECTSTREAM("application/octet-stream"),
    PLAIN("text/plain"),
    RDFXML("application/rdf+xml");

    private String name;

    MediaTypeFormat(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
