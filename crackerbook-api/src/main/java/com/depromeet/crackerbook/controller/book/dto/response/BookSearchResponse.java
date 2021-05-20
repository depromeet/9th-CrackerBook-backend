package com.depromeet.crackerbook.controller.book.dto.response;

import com.depromeet.crackerbook.controller.book.dto.response.kakao.KakaoBookDto;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class BookSearchResponse {

    private final List<KakaoBookDto> bookSearchList;

    public static BookSearchResponse from(List<KakaoBookDto> bookSearchDtoList){
        return new BookSearchResponse(bookSearchDtoList);
    }
}
