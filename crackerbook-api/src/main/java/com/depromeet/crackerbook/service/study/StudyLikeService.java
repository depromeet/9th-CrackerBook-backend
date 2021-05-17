package com.depromeet.crackerbook.service.study;

import com.depromeet.crackerbook.domain.study.dto.StudyLikeDto;
import com.depromeet.crackerbook.domain.study.repository.StudyLikeRepository;
import com.querydsl.core.QueryResults;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class StudyLikeService {

    private final StudyLikeRepository studyLikeRepository;

    public QueryResults<StudyLikeDto> getStudyLikeList(Long userId, Pageable pageable) {
        return studyLikeRepository.getStudyLikeList(userId, pageable);
    }
}
