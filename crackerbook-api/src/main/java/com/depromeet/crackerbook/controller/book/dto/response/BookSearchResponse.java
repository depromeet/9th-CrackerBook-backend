package com.depromeet.crackerbook.controller.book.dto.response;

import com.depromeet.crackerbook.controller.book.dto.BookSearchDto;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class BookSearchResponse {

    // TODO : totalCount 추가?

    private List<BookSearchDto> bookSearchList;

    public static BookSearchResponse from(List<BookSearchDto> bookSearchList){
        return new BookSearchResponse(bookSearchList);
    }
}
