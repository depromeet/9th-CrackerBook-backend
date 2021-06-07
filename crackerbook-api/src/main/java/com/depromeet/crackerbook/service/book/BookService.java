package com.depromeet.crackerbook.service.book;

import com.depromeet.crackerbook.common.ErrorCode;
import com.depromeet.crackerbook.controller.book.dto.response.kakao.KakaoBookDto;
import com.depromeet.crackerbook.domain.book.Book;
import com.depromeet.crackerbook.domain.book.dto.BookSearchDto;
import com.depromeet.crackerbook.domain.book.repository.BookRepository;
import com.depromeet.crackerbook.exception.NotFoundApiException;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class BookService {

    private final BookRepository bookRepository;

    @Transactional
    public List<BookSearchDto> findOrSaveBooks(List<KakaoBookDto> kakaoResults){
        List<BookSearchDto> bookResults = new ArrayList<>();
        for(KakaoBookDto kakaoBookDto : kakaoResults){
            Book book = kakaoBookDto.toBook();

            BookSearchDto resultBook = bookRepository
                .findBookByIsbn(book.getIsbnLong(), book.getIsbnShort());

            if(resultBook == null){
                resultBook = BookSearchDto.from(saveKakaoSearchBook(book));
            }

            bookResults.add(resultBook);
        }
        return bookResults;
    }

    @Transactional
    public Book saveKakaoSearchBook(Book kakaoSearchBook){
        return bookRepository.save(kakaoSearchBook);
    }

    public Book findBookById(Long bookId){
        return bookRepository.findById(bookId)
            .orElseThrow(() -> new NotFoundApiException(ErrorCode.INVALID_BOOK));
    }
}