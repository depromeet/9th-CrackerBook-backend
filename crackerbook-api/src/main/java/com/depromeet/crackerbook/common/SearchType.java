package com.depromeet.crackerbook.common;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum SearchType {

    TITLE("title")
    , AUTHOR("person")
    ;

    private final String type;
}
