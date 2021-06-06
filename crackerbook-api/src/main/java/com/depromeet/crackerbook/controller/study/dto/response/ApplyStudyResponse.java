package com.depromeet.crackerbook.controller.study.dto.response;

import lombok.Getter;

@Getter
public class ApplyStudyResponse {

    private final Long participantId;

    private ApplyStudyResponse(Long participantId) {
        this.participantId = participantId;
    }

    public static ApplyStudyResponse of(Long participantId) {
        return new ApplyStudyResponse(participantId);
    }
}
