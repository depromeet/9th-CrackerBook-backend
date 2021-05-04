package com.depromeet.crackerbook.domain.category;

import com.depromeet.crackerbook.domain.BaseEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class StudyCategory extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "study_category_id")
    private Long studyCategoryId;

    private String name;
    private String imageUrl;
}
