package com.depromeet.crackerbook.domain.study.repository;

import com.depromeet.crackerbook.domain.study.Study;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudyLikeRepository extends JpaRepository<Study, Long>, StudyLikeRepositoryCustom {
}
