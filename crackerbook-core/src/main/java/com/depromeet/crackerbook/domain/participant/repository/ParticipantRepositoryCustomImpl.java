package com.depromeet.crackerbook.domain.participant.repository;

import com.depromeet.crackerbook.domain.participant.dto.ParticipantDto;
import com.depromeet.crackerbook.domain.participant.dto.QParticipantDto;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;

import javax.persistence.EntityManager;

import static com.depromeet.crackerbook.domain.participant.QParticipant.participant;

public class ParticipantRepositoryCustomImpl implements ParticipantRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    public ParticipantRepositoryCustomImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public ParticipantDto getStudyParticipantByUserId(Long userId, Long studyId) {
        return queryFactory
                .select(new QParticipantDto(
                        participant.participantId,
                        participant.study.studyId,
                        participant.user.userId
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
