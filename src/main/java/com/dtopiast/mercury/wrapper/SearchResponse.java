package com.dtopiast.mercury.wrapper;
import com.dtopiast.mercury.model.Book;

import java.util.List;

public record SearchResponse(float count,
                             String next,
                             String previous,
                             List<Book> books) {}

