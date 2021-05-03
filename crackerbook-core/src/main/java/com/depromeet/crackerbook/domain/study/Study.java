package com.depromeet.crackerbook.domain.study;

import com.depromeet.crackerbook.domain.BaseEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Study extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "study_id")
    private Long id;

    private Long categoryId;
    private Long bookId;
    private String bookName;
    private String studyName;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Enumerated(EnumType.STRING)
    private StudyDifficulty status;

    @Enumerated(EnumType.STRING)
    private StudyPlaceType placeType;
    private String address;
    private Integer capacity;

    private LocalDateTime studyStartDate;
    private LocalDateTime studyEndDate;
    private LocalDateTime recruitStartDate;
    private LocalDateTime recruitEndDate;

// 이것을 어떻게 처리할까요..? convert Class를 만드는것 같더라구요..
//    @Column(columnDefinition = "json")
//    private String frequency;

    @Builder
    public Study(
            Long categoryId,
            Long bookId,
            String bookName,
            String studyName,
            String description,
            StudyDifficulty status,
            StudyPlaceType placeType,
            String address,
            Integer capacity,
            LocalDateTime studyStartDate,
            LocalDateTime studyEndDate,
            LocalDateTime recruitStartDate,
            LocalDateTime recruitEndDate
    ) {
        this.categoryId = categoryId;
        this.bookId = bookId;
        this.bookName = bookName;
        this.studyName = studyName;
        this.description = description;
        this.status = status;
        this.placeType = placeType;
        this.address = address;
        this.capacity = capacity;
        this.studyStartDate = studyStartDate;
        this.studyEndDate = studyEndDate;
        this.recruitStartDate = recruitStartDate;
        this.recruitEndDate = recruitEndDate;
    }

    @OneToMany(mappedBy = "study", fetch = FetchType.LAZY)
    @JoinColumn(name = "study_review_id")
    private List<StudyReview> studyReviewList = new ArrayList<>();

    @OneToMany(mappedBy = "study", fetch = FetchType.LAZY)
    @JoinColumn(name = "study_notice_id")
    private List<StudyNotice> studyNoticeList = new ArrayList<>();
}

