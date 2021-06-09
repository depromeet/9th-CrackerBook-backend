package com.depromeet.crackerbook.domain.book;

import com.depromeet.crackerbook.domain.BaseEntity;
import com.depromeet.crackerbook.domain.user.User;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@Entity
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BookLike extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_like_id")
    private Long bookLikeId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    public static BookLike builder(User user, Book book){
        return new BookLikeBuilder()
            .user(user)
            .book(book)
            .build();
    }
}
