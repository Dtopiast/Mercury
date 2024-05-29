package com.dtopiast.mercury.wrapper;

import java.util.List;

public record SearchRequest(String name,
                            List<String> author,
                            String lenguaje,
                            int authorBirthday,
                            int authorDead,
                            Boolean orderBy)
{}
