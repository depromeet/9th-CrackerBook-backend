package com.depromeet.crackerbook.controller;

import lombok.Getter;

@Getter
public class SuccessResponse<T> extends BaseResponse {

    private final T data;

    public SuccessResponse(T data) {
        super("0000", "성공");
        this.data = data;
    }
}
