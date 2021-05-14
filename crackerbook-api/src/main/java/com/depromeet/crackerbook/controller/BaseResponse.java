package com.depromeet.crackerbook.controller;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
public abstract class BaseResponse {

    private final Meta meta;

    protected BaseResponse(String code, String message) {
        this.meta = new Meta(code, message);
    }

    @Getter
    @RequiredArgsConstructor(access = AccessLevel.PRIVATE)
    private static class Meta {

        private final String code;
        private final String message;
    }
}
