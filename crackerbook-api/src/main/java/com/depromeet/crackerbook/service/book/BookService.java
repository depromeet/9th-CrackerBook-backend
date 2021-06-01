package com.depromeet.crackerbook.service.book;

import com.depromeet.crackerbook.controller.book.dto.response.kakao.KakaoBookDto;
import com.depromeet.crackerbook.domain.book.Book;
import com.depromeet.crackerbook.domain.book.dto.BookSearchDto;
import com.depromeet.crackerbook.domain.book.repository.BookRepository;
import com.querydsl.core.QueryResults;
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

    public List<BookSearchDto> findOrSaveBooks(List<KakaoBookDto> kakaoResults){
        List<BookSearchDto> bookResults = new ArrayList<>();
        for(KakaoBookDto kakaoBookDto : kakaoResults){
            Book book = kakaoBookDto.toEntity();
            BookSearchDto resultBook = bookRepository
                .findBookByIsbn(book.getIsbnLong(), book.getIsbnShort())
                .orElseGet(() -> BookSearchDto.from(saveKakaoSearchBook(book)));
            bookResults.add(resultBook);
        }
        return bookResults;
    }

    @Transactional
    public Book saveKakaoSearchBook(Book kakaoSearchBook){
        return bookRepository.save(kakaoSearchBook);
    }
}