package com.depromeet.crackerbook.domain.book;

import com.depromeet.crackerbook.domain.BaseEntity;
import com.depromeet.crackerbook.domain.study.Study;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
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
    private LocalDateTime published_at;

    @OneToMany(mappedBy = "book")
    private List<Study> studyList;

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
            LocalDateTime published_at
    ) {
        this.name = name;
        this.contents = contents;
        this.imageUrlSmall = imageUrlSmall;
        this.imageUrlBig = imageUrlBig;
        this.authors = authors;
        this.price = price;
        this.salePrice = salePrice;
        this.publisher = publisher;
        this.published_at = published_at;
    }

}
