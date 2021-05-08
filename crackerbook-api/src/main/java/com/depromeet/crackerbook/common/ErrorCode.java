package com.depromeet.crackerbook.common;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

    // OPEN API [00xx]
    REQUIRED_KAKAO_CODE("0001", "kakao code는 null일 수 없습니다."),
    REQUIRED_KAKAO_ACCESS_TOKEN("0002", "kakao access token은 null일 수 없습니다."),
    ;

    private final String code;
    private final String message;
}
