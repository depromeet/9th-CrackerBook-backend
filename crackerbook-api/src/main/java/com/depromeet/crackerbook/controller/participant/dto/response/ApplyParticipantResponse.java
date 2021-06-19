package com.depromeet.crackerbook.controller.participant.dto.response;

import lombok.Getter;

@Getter
public class ApplyParticipantResponse {

    private final Long participantId;

    private ApplyParticipantResponse(Long participantId) {
        this.participantId = participantId;
    }

    public static ApplyParticipantResponse of(Long participantId) {
        return new ApplyParticipantResponse(participantId);
    }
}
