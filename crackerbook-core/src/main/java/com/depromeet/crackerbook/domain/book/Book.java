package com.depromeet.crackerbook.domain.book;

import com.depromeet.crackerbook.domain.BaseEntity;
import com.depromeet.crackerbook.domain.study.Study;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Book extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Long id;

    private String name;
    private String contents;
    private String imageUrlSmall;
    private String imageUrlBig;
    private String authors;
    private Integer price;
    private Integer salePrice;
    private String publisher;
    private LocalDateTime publishedAt;

    @OneToMany(mappedBy = "book")
    @JoinColumn(name = "study_id")
    private List<Study> studyList = new ArrayList<>();

    @OneToMany(mappedBy = "book")
    @JoinColumn(name = "book_like_id")
    private List<BookLike> bookLikeList = new ArrayList<>();

    @Builder
    public Book(
            String name,
            String contents,
            String imageUrlSmall,
            String imageUrlBig,
            String authors,
            Integer price,
            Integer salePrice,
            String publisher,
            LocalDateTime publishedAt
    ) {
        this.name = name;
        this.contents = contents;
        this.imageUrlSmall = imageUrlSmall;
        this.imageUrlBig = imageUrlBig;
        this.authors = authors;
        this.price = price;
        this.salePrice = salePrice;
        this.publisher = publisher;
        this.publishedAt = publishedAt;
    }

}
