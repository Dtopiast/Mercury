package com.dtopiast.mercury.dto;
import java.util.ArrayList;
public record BookDto(String title,
                      ArrayList<AuthorDto> authors,
                      ArrayList<String> translators,
                      ArrayList<String> subjects,
                      ArrayList<String> bookshelves,
                      ArrayList<String> languages,
                      ArrayList<String> formats,
                      boolean copyright) {}
