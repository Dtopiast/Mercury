package com.dtopiast.mercury.service;

import com.dtopiast.mercury.dto.BookDto;
import com.dtopiast.mercury.wrapper.SearchRequest;
import com.dtopiast.mercury.model.Book;

import java.util.List;
import java.util.Optional;

public interface IBookSearch {
    List<Book> getAllBooks();
    List<Book> getBooks(int quantity);
    List<Book> queryBooks(SearchRequest dto);
    List<Book> getTop10Books();
    Optional<Book> getBookByName(String bookName);
    List<BookDto> bookModelsToDto(List<Book> books);
    BookDto bookModelToDto(Book book);
    long Count();

}
