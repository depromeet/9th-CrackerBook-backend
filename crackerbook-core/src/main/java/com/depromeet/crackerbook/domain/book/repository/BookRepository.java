package com.depromeet.crackerbook.domain.book.repository;

import com.depromeet.crackerbook.domain.book.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findBooksByName(String name);
    List<Book> findBooksByAuthors(String authors);
}
