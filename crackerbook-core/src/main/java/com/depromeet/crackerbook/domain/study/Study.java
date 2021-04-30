package com.depromeet.crackerbook.domain.study;

import com.depromeet.crackerbook.domain.book.Book;
import com.depromeet.crackerbook.domain.study.StudyReview;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Study {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "study_id")
    private Long id;

    @Column
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

//    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    private Book book;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "study_review_id")
    private List<StudyReview> studyReviewList = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "study_notice_id")
    private List<StudyNotice> studyNoticeList = new ArrayList<>();

    @Builder
    public Study(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
