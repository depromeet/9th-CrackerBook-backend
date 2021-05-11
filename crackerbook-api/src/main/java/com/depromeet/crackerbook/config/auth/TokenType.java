package com.depromeet.crackerbook.config.auth;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TokenType {

    ACCESS_TOKEN(1000 * 60 * 30) // 30분
    , REFRESH_TOKEN(1000 * 60 * 60 * 24 * 14) // 14일
    ;

    private final long expiration;
}
