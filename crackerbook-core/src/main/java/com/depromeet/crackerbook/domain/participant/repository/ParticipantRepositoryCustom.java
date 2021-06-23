package com.depromeet.crackerbook.domain.participant.repository;

import com.depromeet.crackerbook.domain.participant.dto.ParticipantDto;
import com.querydsl.core.Tuple;

import java.util.List;

public interface ParticipantRepositoryCustom {
    ParticipantDto getStudyParticipantByUserId(Long userId, Long studyId);
}
