package com.depromeet.crackerbook.domain.book.dto;

import com.depromeet.crackerbook.domain.book.Book;
import com.querydsl.core.annotations.QueryProjection;
import lombok.AccessLevel;
import lombok.Getter;

import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class BookSearchDto {
    private Long id;
    private String name;
    private String imageUrl;
    private String publisher;
    private String authors;
    private String isbnLong;
    private String isbnShort;
    private LocalDateTime publishedAt;

    @QueryProjection
    public BookSearchDto(
        Long id,
        String name,
        String imageUrl,
        String publisher,
        String authors,
        String isbnLong,
        String isbnShort,
        LocalDateTime publishedAt
    ){
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
        this.publisher = publisher;
        this.authors = authors;
        this.isbnLong = isbnLong;
        this.isbnShort = isbnShort;
        this.publishedAt = publishedAt;
    }

    public static BookSearchDto from(Book book){
        return new BookSearchDto(
            book.getBookId(),
            book.getName(),
            book.getImageUrl(),
            book.getPublisher(),
            book.getAuthors(),
            book.getIsbnLong(),
            book.getIsbnShort(),
            book.getPublishedAt()
        );
    }
}
