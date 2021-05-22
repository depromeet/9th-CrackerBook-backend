package com.depromeet.crackerbook.domain.book;

import com.depromeet.crackerbook.domain.BaseEntity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Builder
@Entity
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
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


    public static BookBuilder builder(
        String name
        ,String contents
        ,String isbnShort
        ,String isbnLong
        ,String authors
        ,int price
        ,int salePrice
        ,String imageUrlSmall
        ,String imageUrlBig
        ,String publisher
        ,LocalDateTime publishedAt
    ){
        return new BookBuilder()
            .name(name)
            .contents(contents)
            .isbnShort(isbnShort)
            .isbnLong(isbnLong)
            .authors(authors)
            .price(price)
            .salePrice(salePrice)
            .imageUrlSmall(imageUrlSmall)
            .imageUrlBig(imageUrlBig)
            .publisher(publisher)
            .publishedAt(publishedAt);
    }

    public String getImageUrl(){
        if(imageUrlBig == null) return imageUrlSmall;
        return imageUrlBig;
    }
}
