package com.dtopiast.mercury.repository;

import com.dtopiast.mercury.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {
    @Query("SELECT b FROM Book b WHERE b.name = :bookName")
    Optional<Book> getBookByName(String bookName);
    @Query("SELECT b FROM Book b ORDER BY b.id DESC")
    List<Book> getTop10Books();
}
