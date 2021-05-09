package com.depromeet.crackerbook.controller.study.dto;

import com.depromeet.crackerbook.domain.study.StudyDifficulty;
import com.depromeet.crackerbook.domain.study.StudyPlaceType;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class StudyDto {
    private final Long bookId;
    private final String bookName;
    private final Long studyId;
    private final String studyName;
    private final String description;
    private final String address;
    private final StudyDifficulty difficulty;
    private final StudyPlaceType studyPlaceType;
    private final int capacity;
    private final LocalDate studyStartDate;
    private final LocalDate studyEndDate;
    private final LocalDateTime recruitStartAt;
    private final LocalDateTime recruitEndAt;
    private final String frequency;
}
