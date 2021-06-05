package com.depromeet.crackerbook.domain.book.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BookLikeDto {

    private Long bookId;
    private String name;
    private String imageUrl;
    private String authors;

    @QueryProjection
    public BookLikeDto(
            Long bookId
            , String name
            , String imageUrl
            , String authors
    ) {
        this.bookId = bookId;
        this.name = name;
        this.imageUrl = imageUrl;
        this.authors = authors;
    }
}
