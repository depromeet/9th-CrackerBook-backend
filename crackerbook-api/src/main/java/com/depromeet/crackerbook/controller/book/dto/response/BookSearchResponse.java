package com.depromeet.crackerbook.controller.book.dto.response;

import com.depromeet.crackerbook.controller.book.dto.response.kakao.KakaoBookDto;
import com.depromeet.crackerbook.domain.book.Book;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class BookSearchResponse {

    private final List<Book> bookSearchList;

    public static BookSearchResponse from(List<Book> bookSearchDtoList){
        return new BookSearchResponse(bookSearchDtoList);
    }
}
