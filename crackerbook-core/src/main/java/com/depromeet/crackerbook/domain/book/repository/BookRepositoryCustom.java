package com.depromeet.crackerbook.domain.book.repository;

import com.depromeet.crackerbook.domain.book.dto.BookSearchDto;
import com.querydsl.core.QueryResults;

public interface BookRepositoryCustom {
    QueryResults<BookSearchDto> findBookByName(String name);
    BookSearchDto findBookByIsbn(String isbnLong, String isbnShort);
}
