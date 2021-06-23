package com.depromeet.crackerbook.domain.participant.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ParticipantDto {

    private Long participantId;
    private Long userId;
    private Long studyId;

    @QueryProjection
    public ParticipantDto(
            Long participantId
            , Long userId
            , Long studyId
    ) {
        this.participantId = participantId;
        this.userId = userId;
        this.studyId = studyId;
    }
}
