package com.dtopiast.mercury.wrapper;

import java.util.List;

public record SearchRequest(String tittle,
                            List<String> authors,
                            List<String> lenguajes,
                            int authorBirthday,
                            int authorDead,
                            Boolean orderBy)
{}
