package com.dtopiast.mercury.controller;

import com.dtopiast.mercury.dto.BookDto;
import com.dtopiast.mercury.service.IBookSearch;
import com.dtopiast.mercury.wrapper.SearchRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;

@RestController("books")
public class BooksController {
    @Autowired
    private IBookSearch search;
    @GetMapping("query")
    public List<BookDto> getBookByQuery(@RequestParam String title,
                                        @RequestParam List<String> authors,
                                        @RequestParam List<String> languages,
                                        @RequestParam int authorBirthday,
                                        @RequestParam int authorDead,
                                        @RequestParam Boolean orderBy,
                                        @RequestParam int quantity) {

        var request = new SearchRequest(title,authors,languages,authorBirthday,authorDead,orderBy,quantity);
        var temp =  search.queryBooks(request);
        return  search.bookModelsToDto(temp);
    }
    @GetMapping("top10")

    public List<BookDto> getTop10Books(){
        var temp =  search.getTop10Books();
        return  search.bookModelsToDto(temp);
    }
    @GetMapping("all")

    public List<BookDto> getAllBooks(){
        var temp = search.getAllBooks();
        return  search.bookModelsToDto(temp);

    }
    @GetMapping("byName/{name}")

    public ResponseEntity<BookDto> getBookByName(@PathVariable String name){
        var temp =  search.getBookByName(name);
        return temp.map(book -> ResponseEntity.status(HttpStatus.ACCEPTED).body(search.bookModelToDto(book))).orElseGet(()
                -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));

    }
    @GetMapping("byQuantity/{quantity}")

    public List<BookDto> getBooks(@PathVariable int quantity){
        var temp =  search.getBooks(quantity);
        return  search.bookModelsToDto(temp);
    }

}
