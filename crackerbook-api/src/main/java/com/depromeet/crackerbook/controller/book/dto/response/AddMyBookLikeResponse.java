package com.depromeet.crackerbook.controller.book.dto.response;

import com.depromeet.crackerbook.domain.book.BookLike;
import lombok.Getter;

@Getter
public class AddMyBookLikeResponse {

    private final BookLike bookLike;

    private AddMyBookLikeResponse(BookLike bookLike){
        this.bookLike = bookLike;
    }

    public static AddMyBookLikeResponse of(BookLike bookLike){
        return new AddMyBookLikeResponse(bookLike);
    }
}
