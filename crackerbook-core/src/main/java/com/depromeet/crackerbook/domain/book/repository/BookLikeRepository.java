package com.depromeet.crackerbook.domain.book.repository;

import com.depromeet.crackerbook.domain.book.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookLikeRepository extends JpaRepository<Book, Long>, BookLikeRepositoryCustom {
}
