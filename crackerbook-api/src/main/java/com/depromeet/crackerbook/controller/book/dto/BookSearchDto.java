package com.depromeet.crackerbook.controller.book.dto;

import com.depromeet.crackerbook.domain.book.Book;
import com.querydsl.core.annotations.QueryProjection;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class BookSearchDto {
    private String name;
    private String imageUrl;
    private String publisher;
    private String authors;
    private LocalDateTime publishedAt;

    @QueryProjection
    public BookSearchDto(
            String name,
            String imageUrl,
            String publisher,
            String authors,
            LocalDateTime publishedAt
    ){
        this.name = name;
        this.imageUrl = imageUrl;
        this.publisher = publisher;
        this.authors = authors;
        this.publishedAt = publishedAt;
    }
}
