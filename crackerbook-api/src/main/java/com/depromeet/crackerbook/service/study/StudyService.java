package com.depromeet.crackerbook.service.study;

import com.depromeet.crackerbook.common.ErrorCode;
import com.depromeet.crackerbook.controller.study.dto.request.CreateStudyRequest;
import com.depromeet.crackerbook.controller.study.dto.request.UpdateStudyRequest;
import com.depromeet.crackerbook.domain.study.Study;
import com.depromeet.crackerbook.domain.study.repository.StudyRepository;
import com.depromeet.crackerbook.exception.NotFoundApiException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudyService {

    private final StudyRepository studyRepository;

    public Study findStudyByStudyId(Long studyId) {
        return studyRepository.findById(studyId)
                .orElseThrow(() -> new NotFoundApiException(ErrorCode.INVALID_STUDY));
    }

    public Study createStudy(CreateStudyRequest createStudyRequest) {
        Study study = Study.createStudy(
                createStudyRequest.getStudyName(),
                createStudyRequest.getBookName(),
                createStudyRequest.getDescription(),
                createStudyRequest.getDifficulty(),
                createStudyRequest.getPlaceType(),
                createStudyRequest.getCapacity(),
                createStudyRequest.getStudyStartDate(),
                createStudyRequest.getStudyEndDate(),
                createStudyRequest.getRecruitStartAt(),
                createStudyRequest.getRecruitEndAt(),
                createStudyRequest.getFrequency()
        );

        studyRepository.save(study);
        return study;
    }

    public Study updateStudy(Long studyId, UpdateStudyRequest updateStudyRequest) {
        Study study = findStudyByStudyId(studyId);

        study.updateStudy(
                updateStudyRequest.getStudyName()
                , updateStudyRequest.getDescription()
                , updateStudyRequest.getDifficulty()
                , updateStudyRequest.getPlaceType()
                , updateStudyRequest.getCapacity()
                , updateStudyRequest.getStudyStartDate()
                , updateStudyRequest.getStudyEndDate()
                , updateStudyRequest.getRecruitStartAt()
                , updateStudyRequest.getRecruitEndAt()
        );

        return study;
    }
}
