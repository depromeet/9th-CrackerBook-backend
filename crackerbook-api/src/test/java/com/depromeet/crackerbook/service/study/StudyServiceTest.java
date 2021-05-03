package com.depromeet.crackerbook.service.study;

import com.depromeet.crackerbook.domain.study.Study;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@SpringBootTest()
public class StudyServiceTest {

    @Autowired
    private StudyService studyService;

    @Test
    public void save() {
        //given
//        Study study = new Study("사소한 일상으로 만드는 콘텐츠", "테스트");

        //when
//        Long id = studyService.createStudy(study);
//
//        //then
//        assertThat(id, is(1L));
    }
}
