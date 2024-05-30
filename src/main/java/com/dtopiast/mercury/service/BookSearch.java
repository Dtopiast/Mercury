package com.dtopiast.mercury.service;

import com.dtopiast.mercury.dto.AuthorDto;
import com.dtopiast.mercury.dto.BookDto;
import com.dtopiast.mercury.model.Author;
import com.dtopiast.mercury.model.Languaje;
import com.dtopiast.mercury.wrapper.SearchRequest;
import com.dtopiast.mercury.wrapper.SearchResponse;
import com.dtopiast.mercury.model.Book;
import com.dtopiast.mercury.repository.BookRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.net.URI;
import java.net.http.*;
import java.util.ArrayList;
import java.util.*;
import java.util.stream.Collectors;

public class BookSearch implements IBookSearch{
    private final ResourceBundle bundle  = ResourceBundle.getBundle("application");
    private final String apiUrl = bundle.getString("url.api.url");
    private final ObjectMapper objectMapper;

    public BookSearch(){
        objectMapper = new ObjectMapper();
    }
    @Autowired
    private BookRepository repository;

    @Override
    public List<Book> getAllBooks() {
        return repository.findAll();
    }

    @Override
    public List<Book> getBooks(long quantity) {
        return repository.findAll().subList(0,(int)quantity);
    }

    @Override
    public List<Book> queryBooks(SearchRequest dto) {
        List<Book> result;
        try {
             result = sendToApi(dto).books();
        } catch (JsonProcessingException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    @Override
    public List<Book> getTop10Books() {
        return repository.getTop10Books();
    }

    @Override
    public Optional<Book> getBookByNameOrAuthor(String bookName) {
        return repository.getBookByName(bookName);
    }

    @Override
    public List<BookDto> bookModelsToDto(List<Book> books) {
        List<BookDto> booksDto = new ArrayList<>();
        for (Book book : books) booksDto.add(bookModelToDto(book));
        return booksDto;
    }

    @Override
    public BookDto bookModelToDto(Book book) {
        ArrayList<AuthorDto> authorDto = new ArrayList<>();
        for (Author author : book.getAuthors()) {
            authorDto.add(new AuthorDto(author.getName(), author.getBirthYear(), author.getDeathYear()));
        }
        return new BookDto(
                book.getTitle(),
                authorDto,
                book.getSubjects(),
                book.getBookshelves(),
                book.getLanguages().stream().map(Enum::name).collect(Collectors.toCollection(ArrayList::new)),
                new ArrayList<>(book.getFormats().values()),
                book.isCopyright(),
                book.getDonwloads()
        );
    }

    @Override
    public long Count() {
        return repository.count();
    }

    @Override
    public List<Book> getBooksByLanguage(List<Languaje> languages, int maxResults) {
        List<Book> result = new ArrayList<>();
        int count = 0;
        for (Book book : repository.findAll()) {
            for (Languaje language : languages) {
                if (book.getLanguages().contains(language)) {
                    result.add(book);
                    count++;
                    if (count >= maxResults) {
                        return result;
                    }
                    break;
                }
            }
        }


        return result;
}

    private SearchResponse sendToApi(SearchRequest data) throws JsonProcessingException, InterruptedException {
        StringBuilder sb = new StringBuilder();
        sb.append(apiUrl).append("books?");

        appendQueryParams(sb,"search",data.authors());
        appendQueryParams(sb,"languages",data.lenguajes());
        appendQueryParam(sb, "search", data.tittle());
        appendQueryParam(sb, "author_year_start ", data.authorBirthday());
        appendQueryParam(sb, "author_year_end", data.authorDead());

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(sb.toString()))
                .build();
        HttpResponse<String> response;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String json = response.body();
        SearchResponse result = objectMapper.readValue(json, SearchResponse.class);

        if (result != null && !result.books().isEmpty() && data.orderBy()) {
            result.books().sort(Comparator.comparing(Book::getTitle));
            repository.saveAll(result.books());
        }

        return result;
    }

    private void appendQueryParam(StringBuilder sb, String paramName, Object paramValue) {
        if (paramValue != null) {
            sb.append(paramName).append("=").append(paramValue).append("&");
        }
    }
    private  void appendQueryParams(StringBuilder sb, String paramName, List<?> paramValues){
        if (paramValues != null && !paramValues.isEmpty()) {
            sb.append(paramName).append("=");
            for (Object value : paramValues) {
                sb.append(value).append(",");
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.append("&");
        }
    }

}
