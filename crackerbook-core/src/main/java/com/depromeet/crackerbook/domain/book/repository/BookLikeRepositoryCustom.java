package com.depromeet.crackerbook.domain.book.repository;

import com.depromeet.crackerbook.domain.book.BookLike;
import com.depromeet.crackerbook.domain.book.dto.BookLikeDto;
import com.querydsl.core.QueryResults;
import org.springframework.data.domain.Pageable;

public interface BookLikeRepositoryCustom {
    QueryResults<BookLikeDto> getBookLikeList(Long userId, Pageable pageable);
    Long getBookLikeId(Long userId, Long bookId);

}
