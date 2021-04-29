package com.depromeet.crackerbook.domain.book;

import com.depromeet.crackerbook.domain.study.Study;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class Book {

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

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @OneToOne(mappedBy = "book", fetch = FetchType.LAZY)
    private Study study;
}
