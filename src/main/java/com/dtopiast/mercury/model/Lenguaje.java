package com.dtopiast.mercury.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public enum Lenguaje {
    ENGLISH("en"),
    SPANISH("es"),
    GERMANY("de"),
    FRENCH("fr"),
    ;
    private String name;

    Lenguaje(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
