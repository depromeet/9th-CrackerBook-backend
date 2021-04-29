package com.depromeet.crackerbook.domain.study;

import com.depromeet.crackerbook.domain.book.Book;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Study {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

//    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    private Book book;

    @Builder
    public Study(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
