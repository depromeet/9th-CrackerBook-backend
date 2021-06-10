package com.depromeet.crackerbook.service.book;

import com.depromeet.crackerbook.common.ErrorCode;
import com.depromeet.crackerbook.domain.book.Book;
import com.depromeet.crackerbook.domain.book.BookLike;
import com.depromeet.crackerbook.domain.book.dto.BookLikeDto;
import com.depromeet.crackerbook.domain.book.repository.BookLikeRepository;
import com.depromeet.crackerbook.domain.book.repository.BookRepository;
import com.depromeet.crackerbook.domain.user.User;
import com.depromeet.crackerbook.domain.user.repository.UserRepository;
import com.depromeet.crackerbook.exception.NotFoundApiException;
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
    private final BookRepository bookRepository;
    private final UserRepository userRepository;

    public QueryResults<BookLikeDto> getBookLikeList(Long userId, Pageable pageable) {
        return bookLikeRepository.getBookLikeList(userId, pageable);
    }

    @Transactional
    public BookLike addMyBookLike(Long userId, Long bookId){
        User user = userRepository.findById(userId)
            .orElseThrow(() -> new NotFoundApiException(ErrorCode.INVALID_USER));

        Book book = bookRepository.findById(bookId)
            .orElseThrow(() -> new NotFoundApiException(ErrorCode.INVALID_BOOK));

        BookLike bookLike = BookLike.builder(user, book);

        return bookLikeRepository.save(bookLike);
    }

    @Transactional
    public BookLike deleteMyBookLike(Long userId, Long bookId){
        BookLike bookLike = bookLikeRepository.getMyBookLike(userId, bookId);

        if(bookLike == null){
            throw new NotFoundApiException(ErrorCode.INVALID_BOOK_LIKE);
        }

        bookLikeRepository.deleteById(bookLike.getBookLikeId());

        return bookLike;
    }
}
