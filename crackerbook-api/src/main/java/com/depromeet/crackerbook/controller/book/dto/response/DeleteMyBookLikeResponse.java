package com.depromeet.crackerbook.controller.book.dto.response;

import lombok.Getter;

@Getter
public class DeleteMyBookLikeResponse {

    private final Long bookLikeId;

    private DeleteMyBookLikeResponse(Long bookLikeId){
        this.bookLikeId = bookLikeId;
    }

    public static DeleteMyBookLikeResponse of(Long bookLikeId){
        return new DeleteMyBookLikeResponse(bookLikeId);
    }
}
