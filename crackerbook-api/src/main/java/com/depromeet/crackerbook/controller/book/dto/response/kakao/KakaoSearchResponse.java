package com.depromeet.crackerbook.controller.book.dto.response.kakao;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
public class KakaoSearchResponse<T> {
    private List<T> documents;
    private KakaoSearchMeta meta;

    @Getter
    static class KakaoSearchMeta {
        private int totalCount;
        private int pageableCount;
        private boolean isEnd;
    }
}
