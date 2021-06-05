package com.depromeet.crackerbook.service.book;

import com.depromeet.crackerbook.domain.book.dto.BookLikeDto;
import com.depromeet.crackerbook.domain.book.repository.BookLikeRepository;
import com.querydsl.core.QueryResults;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class BookLikeService {

    private final BookLikeRepository bookLikeRepository;

    public QueryResults<BookLikeDto> getBookLikeList(Long userId, Pageable pageable) {
        return bookLikeRepository.getBookLikeList(userId, pageable);
    }
}
