package com.dtopiast.mercury.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public enum Languaje {
    ENGLISH("en"),
    SPANISH("es"),
    GERMANY("de"),
    FRENCH("fr"),
    ;
    private String name;

    Languaje(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
