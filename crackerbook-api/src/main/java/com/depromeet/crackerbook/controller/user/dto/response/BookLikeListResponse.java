package com.depromeet.crackerbook.controller.user.dto.response;

import com.depromeet.crackerbook.domain.book.dto.BookLikeDto;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class BookLikeListResponse {

    private final long totalCount;
    private final List<BookLikeDto> bookLikeList;

    public static BookLikeListResponse of(long total, List<BookLikeDto> bookLikeDtoList) {
        return new BookLikeListResponse(total, bookLikeDtoList);
    }
}
