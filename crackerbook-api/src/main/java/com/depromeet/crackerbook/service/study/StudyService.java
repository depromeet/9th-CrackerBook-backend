package com.depromeet.crackerbook.service.study;

import com.depromeet.crackerbook.domain.study.repository.StudyRepository;
import org.springframework.stereotype.Service;

@Service
public class StudyService {

    private StudyRepository studyRepository;

    public StudyService(StudyRepository studyRepository){
        this.studyRepository = studyRepository;
    }
}
