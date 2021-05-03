package com.depromeet.crackerbook.domain.study;

import com.depromeet.crackerbook.domain.BaseEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class StudyNotice extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "study_notice_id")
    private Long id;

    private Long studyId;
    private Long userId;

    @Column(columnDefinition = "TEXT")
    private String contents;

    @Builder
    public StudyNotice(Long studyId, Long userId, String contents) {
        this.studyId = studyId;
        this.userId = userId;
        this.contents = contents;
    }
}
