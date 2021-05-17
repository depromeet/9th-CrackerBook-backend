package com.depromeet.crackerbook.domain.book;

import com.depromeet.crackerbook.domain.BaseEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Book extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Long bookId;

    private String isbnShort;
    private String isbnLong;
    private String name;
    private String contents;
    private String imageUrlSmall;
    private String imageUrlBig;
    private String authors;
    private Integer price;
    private Integer salePrice;
    private String publisher;
    private LocalDateTime publishedAt;

    @Builder
    public Book(
            String name,
            String contents,
            String isbnShort,
            String isbnLong,
            String authors,
            int price,
            int salePrice,
            String imageUrlSmall,
            String imageUrlBig, ///602/x9788965402602.jpg
            String publisher,
            LocalDateTime publishedAt
            ){
        this.name = name;
        this.contents = contents;
        this.isbnShort = isbnShort;
        this.isbnLong = isbnLong;
        this.authors = authors;
        this.price = price;
        this.salePrice = salePrice;
        this.imageUrlSmall = imageUrlSmall;
        this.imageUrlBig = imageUrlBig;
        this.publisher = publisher;
        this.publishedAt = publishedAt;

    }
}
