package com.depromeet.crackerbook.controller.user.dto.response;

import com.depromeet.crackerbook.domain.study.dto.StudyLikeDto;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class StudyLikeListResponse {

    private final long totalCount;
    private final List<StudyLikeDto> studyLikeList;

    public static StudyLikeListResponse of(long total, List<StudyLikeDto> studyLikeDtoList) {
        return new StudyLikeListResponse(total, studyLikeDtoList);
    }
}
