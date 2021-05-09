package com.depromeet.crackerbook.controller.study.dto.request;

import com.depromeet.crackerbook.domain.study.StudyDifficulty;
import com.depromeet.crackerbook.domain.study.StudyPlaceType;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
public class CreateStudyRequest {
    private int bookId;
    private String bookName;
    private String isbn;
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
