package com.depromeet.crackerbook.service.book;

import com.depromeet.crackerbook.domain.book.Book;
import com.depromeet.crackerbook.domain.book.dto.BookSearchDto;
import com.depromeet.crackerbook.domain.book.repository.BookRepository;
import com.querydsl.core.QueryResults;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BookService {

    private final BookRepository bookRepository;

    @Transactional(readOnly = true)
    public QueryResults<BookSearchDto> findBookByName(String name){
        return bookRepository.findBookByName(name);
    }

    public void saveKakaoSearchBook(List<Book> kakaoSearchBooks){
        bookRepository.saveAll(kakaoSearchBooks);
    }
}