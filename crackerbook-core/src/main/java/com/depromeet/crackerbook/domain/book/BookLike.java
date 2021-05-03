package com.depromeet.crackerbook.domain.book;

import com.depromeet.crackerbook.domain.BaseEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BookLike extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_like_id")
    private Long id;

    private Long userId;
    private Long bookId;

    @Builder
    public BookLike(Long userId, Long bookId) {
        this.userId = userId;
        this.bookId = bookId;
    }
}
