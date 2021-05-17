package com.depromeet.crackerbook.domain.study.repository;

import com.depromeet.crackerbook.domain.study.dto.StudyLikeDto;
import com.querydsl.core.QueryResults;
import org.springframework.data.domain.Pageable;

public interface StudyLikeRepositoryCustom {

    QueryResults<StudyLikeDto> getStudyLikeList(Long userId, Pageable pageable);
}
