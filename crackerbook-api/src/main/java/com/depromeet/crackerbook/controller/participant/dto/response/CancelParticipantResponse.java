package com.depromeet.crackerbook.controller.participant.dto.response;

import lombok.Getter;

@Getter
public class CancelParticipantResponse {

    private final Long participantId;

    private CancelParticipantResponse(Long participantId) {
        this.participantId = participantId;
    }

    public static CancelParticipantResponse of(Long participantId) {
        return new CancelParticipantResponse(participantId);
    }
}
