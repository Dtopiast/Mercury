package com.dtopiast.mercury.repository;

import com.dtopiast.mercury.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

}
