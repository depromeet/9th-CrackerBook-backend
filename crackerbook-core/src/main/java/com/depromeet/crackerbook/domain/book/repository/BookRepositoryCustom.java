package com.depromeet.crackerbook.domain.book.repository;

import com.depromeet.crackerbook.domain.book.dto.BookSearchDto;
import com.querydsl.core.QueryResults;
import java.util.Optional;

public interface BookRepositoryCustom {
    QueryResults<BookSearchDto> findBookByName(String name);
    Optional<BookSearchDto> findBookByIsbn(String isbnLong, String isbnShort);
}
