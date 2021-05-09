package com.depromeet.crackerbook.controller.study.dto.response;

import lombok.Getter;

@Getter
public class UpdateStudyResponse {

    private final Long studyId;

    public UpdateStudyResponse(Long studyId) {
        this.studyId = studyId;
    }

    public static UpdateStudyResponse from(Long studyId) {
        return new UpdateStudyResponse(studyId);
    }
}
