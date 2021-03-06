package com.depromeet.crackerbook.common;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

    // OPEN API [00xx]
    REQUIRED_KAKAO_CODE("0001", "kakao code는 null일 수 없습니다."),
    REQUIRED_KAKAO_ACCESS_TOKEN("0002", "kakao access token은 null일 수 없습니다."),

    // USER [01xx]
    INVALID_USER("0101", "유효하지 않은 사용자입니다."),

    // STUDY [02xx]
    INVALID_STUDY("0201", "유효하지 않은 스터디 입니다."),

    // BOOK[03xx]
    INVALID_BOOK_NAME_KEYWORD("0301", "유효하지 않은 책 이름 입니다."),
    INVALID_BOOK_AUTHOR_KEYWORD("0302", "유효하지 않은 작가 이름 입니다."),
    INVALID_BOOK("0303", "등록되지 않은 책 입니다."),
    INVALID_BOOK_LIKE("0304", "등록되지 않은 관심 책입니다."),

    // COMMON [99xx]
    INVALID_INPUT_VALUE("9901", "유효하지 않은 값입니다."),
    INVALID_TYPE_VALUE("9902", "유효하지 않은 타입입니다."),
    METHOD_NOT_ALLOWED("9903", "지원하지 않는 메서드입니다."),
    UNEXPECTED_ERROR("9999", "알 수 없는 에러입니다.")
    ;

    private final String code;
    private final String message;
}
