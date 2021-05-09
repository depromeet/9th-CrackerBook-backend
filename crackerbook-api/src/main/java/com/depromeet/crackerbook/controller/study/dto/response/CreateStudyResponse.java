package com.depromeet.crackerbook.controller.study.dto.response;

import lombok.Getter;

@Getter
public class CreateStudyResponse {

    private final Long studyId;

    private CreateStudyResponse(Long studyId) {
        this.studyId = studyId;
    }

    public static CreateStudyResponse from(Long studyId) {
        return new CreateStudyResponse(studyId);
    }
}
