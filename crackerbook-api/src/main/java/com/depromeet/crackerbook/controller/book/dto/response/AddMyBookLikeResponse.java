package com.depromeet.crackerbook.controller.book.dto.response;

import com.depromeet.crackerbook.domain.book.BookLike;
import lombok.Getter;

@Getter
public class AddMyBookLikeResponse {

    private final Long bookLikeId;

    private AddMyBookLikeResponse(Long bookLike){
        this.bookLikeId = bookLike;
    }

    public static AddMyBookLikeResponse of(BookLike bookLike){
        return new AddMyBookLikeResponse(bookLike.getBookLikeId());
    }
}
