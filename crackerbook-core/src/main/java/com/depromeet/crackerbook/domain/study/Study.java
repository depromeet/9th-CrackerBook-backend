package com.depromeet.crackerbook.domain.study;

import com.depromeet.crackerbook.domain.BaseEntity;
import com.depromeet.crackerbook.domain.book.Book;
import com.depromeet.crackerbook.domain.category.StudyCategory;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
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

// 이것을 어떻게 처리할까요..? convert Class를 만드는것 같더라구요..
//    @Column(columnDefinition = "json")
//    private String frequency;
}
