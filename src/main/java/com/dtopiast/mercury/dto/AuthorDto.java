package com.dtopiast.mercury.dto;

import java.util.ArrayList;

public record AuthorDto(String Name,
                        ArrayList<BookDto> bookDto) {

}
