package com.depromeet.crackerbook.common;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum SearchType {

    TITLE("title")
    , AUTHOR("person")
    , LATEST("latest")
    ;

    private final String type;
}
