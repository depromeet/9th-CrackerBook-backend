package com.depromeet.crackerbook.domain.study;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Study {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    public Study(String name, String description) {
        this.name = name;
        this.description = description;
    }
}