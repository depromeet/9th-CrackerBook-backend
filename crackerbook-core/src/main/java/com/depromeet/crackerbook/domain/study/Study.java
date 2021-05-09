package com.depromeet.crackerbook.domain.study;

import com.depromeet.crackerbook.domain.BaseEntity;
import com.depromeet.crackerbook.domain.book.Book;
import com.depromeet.crackerbook.domain.category.StudyCategory;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Builder
@Entity
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Study extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "study_id")
    private Long studyId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "study_category_id")
    private StudyCategory studyCategory;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    private Book book;

    private String bookName;
    private String studyName;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Enumerated(EnumType.STRING)
    private StudyDifficulty difficulty;

    @Enumerated(EnumType.STRING)
    private StudyPlaceType placeType;

    private String address;
    private Integer capacity;
    private LocalDate studyStartDate;
    private LocalDate studyEndDate;
    private LocalDateTime recruitStartAt;
    private LocalDateTime recruitEndAt;

    // TODO JSON TYPE으로 하기로 했는데
    //  @Column(columnDefinition = "json")
    private String frequency;

    public static Study createStudy(
            String studyName
            , String bookName
            , String description
            , StudyDifficulty difficulty
            , StudyPlaceType placeType
            , int capacity
            , LocalDate studyStartDate
            , LocalDate studyEndDate
            , LocalDateTime recruitStartAt
            , LocalDateTime recruitEndAt
            , String frequency
    ) {
        return new StudyBuilder()
                .studyName(studyName)
                .bookName(bookName)
                .description(description)
                .difficulty(difficulty)
                .placeType(placeType)
                .capacity(capacity)
                .studyStartDate(studyStartDate)
                .studyEndDate(studyEndDate)
                .recruitStartAt(recruitStartAt)
                .recruitEndAt(recruitEndAt)
                .frequency(frequency)
                .build();
    }

    public void updateStudy(
            String studyName
            , String description
            , StudyDifficulty difficulty
            , StudyPlaceType placeType
            , int capacity
            , LocalDate studyStartDate
            , LocalDate studyEndDate
            , LocalDateTime recruitStartAt
            , LocalDateTime recruitEndAt
    ) {
        this.studyName = studyName;
        this.description = description;
        this.difficulty = difficulty;
        this.placeType = placeType;
        this.capacity = capacity;
        this.studyStartDate = studyStartDate;
        this.studyEndDate = studyEndDate;
        this.recruitStartAt = recruitStartAt;
        this.recruitEndAt = recruitEndAt;
    }
}
