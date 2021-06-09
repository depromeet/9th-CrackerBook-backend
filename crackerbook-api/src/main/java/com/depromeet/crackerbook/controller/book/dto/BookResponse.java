package com.depromeet.crackerbook.controller.book.dto;

import com.depromeet.crackerbook.domain.book.Book;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class BookResponse {

    private final Book book;

    public static BookResponse of(Book book){
        return new BookResponse(book);
    }
}
