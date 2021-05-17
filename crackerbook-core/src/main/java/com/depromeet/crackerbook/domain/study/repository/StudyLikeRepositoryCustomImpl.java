package com.depromeet.crackerbook.domain.study.repository;

import com.depromeet.crackerbook.domain.study.dto.QStudyLikeDto;
import com.depromeet.crackerbook.domain.study.dto.StudyLikeDto;
import com.querydsl.core.QueryResults;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.JPQLQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;

import static com.depromeet.crackerbook.domain.book.QBook.book;
import static com.depromeet.crackerbook.domain.participant.QParticipant.participant;
import static com.depromeet.crackerbook.domain.study.QStudy.study;
import static com.depromeet.crackerbook.domain.study.QStudyLike.studyLike;


public class StudyLikeRepositoryCustomImpl implements StudyLikeRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    public StudyLikeRepositoryCustomImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public QueryResults<StudyLikeDto> getStudyLikeList(Long userId, Pageable pageable) {
        return queryFactory
                .select(new QStudyLikeDto(
                        study.studyId
                        , study.studyName
                        , book.imageUrlBig
                        , study.studyCategory.name
                        , study.capacity
                        , study.studyStartDate
                        , study.studyEndDate
                        , getLikeCount()
                        , getParticipantCount()
                ))
                .from(studyLike)
                .innerJoin(studyLike.study, study)
                .innerJoin(studyLike.study.book, book)
                .where(userIdEq(userId))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .orderBy(study.studyId.desc())
                .fetchResults();
    }

    private JPQLQuery<Long> getLikeCount() {
        return JPAExpressions
                .select(studyLike.studyLikeId.count())
                .from(studyLike)
                .where(studyLike.study.studyId.eq(study.studyId));
    }

    private JPQLQuery<Long> getParticipantCount() {
        return JPAExpressions
                .select(participant.participantId.count())
                .from(participant)
                .where(participant.study.studyId.eq(study.studyId));
    }

    private BooleanExpression userIdEq(Long userId) {
        return studyLike.user.userId.eq(userId);
    }
}
