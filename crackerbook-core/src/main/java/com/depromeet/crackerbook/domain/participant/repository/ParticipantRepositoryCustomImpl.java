package com.depromeet.crackerbook.domain.participant.repository;

import com.depromeet.crackerbook.domain.participant.QParticipant;
import com.depromeet.crackerbook.domain.participant.dto.ParticipantDto;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;

import static com.depromeet.crackerbook.domain.participant.QParticipant.participant;


public class ParticipantRepositoryCustomImpl implements ParticipantRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    public ParticipantRepositoryCustomImpl(JPAQueryFactory queryFactory) {
        this.queryFactory = queryFactory;
    }

    @Override
    public ParticipantDto getStudyParticipantByUserId(Long userId, Long studyId) {
        return queryFactory
                .select(new QParticipantDto(
                        participant.participantId,
                        userId,
                        studyId
                ))
                .from(participant)
                .where(userIdEq(userId), studyIdEq(studyId))
                .fetchOne();
    }

    private BooleanExpression userIdEq(Long userId) {
        return participant.user.userId.eq(userId);
    }

    private BooleanExpression studyIdEq(Long studyId) {
        return participant.study.studyId.eq(studyId);
    }

}
