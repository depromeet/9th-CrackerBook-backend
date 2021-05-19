package com.depromeet.crackerbook.domain.study.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class StudyLikeDto {

    private Long studyId;
    private String studyName;
    private String bookImageUrl;
    private String catagoryName;
    private Integer capacity;
    private LocalDate studyStartDate;
    private LocalDate studyEndDate;
    private Long likeCount;
    private Long participantCount;

    @QueryProjection
    public StudyLikeDto(
            Long studyId
            , String studyName
            , String bookImageUrl
            , String catagoryName
            , Integer capacity
            , LocalDate studyStartDate
            , LocalDate studyEndDate
            , Long likeCount
            , Long participantCount
    ) {
        this.studyId = studyId;
        this.studyName = studyName;
        this.bookImageUrl = bookImageUrl;
        this.catagoryName = catagoryName;
        this.capacity = capacity;
        this.studyStartDate = studyStartDate;
        this.studyEndDate = studyEndDate;
        this.likeCount = likeCount;
        this.participantCount = participantCount;
    }
}
