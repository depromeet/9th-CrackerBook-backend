package com.depromeet.crackerbook.controller.book.dto.response;

import com.depromeet.crackerbook.domain.book.BookLike;
import lombok.Getter;

@Getter
public class DeleteMyBookLikeResponse {

    private final BookLike bookLike;

    private DeleteMyBookLikeResponse(BookLike bookLike){
        this.bookLike = bookLike;
    }

    public static DeleteMyBookLikeResponse of(BookLike bookLike){
        return new DeleteMyBookLikeResponse(bookLike);
    }
}
