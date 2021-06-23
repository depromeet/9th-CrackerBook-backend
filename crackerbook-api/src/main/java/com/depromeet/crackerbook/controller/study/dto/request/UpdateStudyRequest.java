package com.depromeet.crackerbook.controller.study.dto.request;

import com.depromeet.crackerbook.domain.study.StudyDifficulty;
import com.depromeet.crackerbook.domain.study.StudyPlaceType;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class UpdateStudyRequest {
    private String studyName;
    private String description;
    private StudyDifficulty difficulty;
    private StudyPlaceType placeType;
    private int capacity;
    private LocalDate studyStartDate;
    private LocalDate studyEndDate;
    private LocalDateTime recruitStartAt;
    private LocalDateTime recruitEndAt;
    private String frequency;
}
