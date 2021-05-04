package com.depromeet.crackerbook.domain.study;

import com.depromeet.crackerbook.domain.study.repository.StudyRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@DataJpaTest
public class StudyRepositoryTest {

    @Autowired
    private StudyRepository studyRepository;

    @Test
    public void add() {
        //given
//        studyRepository.save(new Study("사소한 일상으로 만드는 콘텐츠", "테스트"));
//
//        //when
//        Study saved = studyRepository.findById(1L).orElse(null);
//
//        //then
//        assertThat(saved.getName(), is("사소한 일상으로 만드는 콘텐츠"));
    }
}
