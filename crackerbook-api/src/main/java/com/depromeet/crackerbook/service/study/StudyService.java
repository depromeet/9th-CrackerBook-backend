package com.depromeet.crackerbook.service.study;

import com.depromeet.crackerbook.domain.study.Study;
import com.depromeet.crackerbook.domain.study.StudyRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class StudyService {

    private StudyRepository studyRepository;

    public StudyService(StudyRepository studyRepository){
        this.studyRepository = studyRepository;
    }

    @Transactional
    public Long createStudy(Study study){
        return studyRepository.save(study).getId();
    }
}