package com.depromeet.crackerbook.controller.book.dto.response;

import com.depromeet.crackerbook.domain.book.dto.BookSearchDto;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class BookSearchResponse {

    private final List<BookSearchDto> bookSearchList;

    public static BookSearchResponse of(List<BookSearchDto> bookSearchDtoList){
        return new BookSearchResponse(bookSearchDtoList);
    }
}
