package com.depromeet.crackerbook.controller.study.dto.response;

import com.depromeet.crackerbook.controller.study.dto.StudyDto;
import com.depromeet.crackerbook.domain.study.Study;
import lombok.Getter;

@Getter
public class GetStudyResponse {

    private final StudyDto studyDto;

    private GetStudyResponse(Study study) {
        this.studyDto = new StudyDto(
                study.getBook().getBookId()
                , study.getBook().getName()
                , study.getStudyId()
                , study.getStudyName()
                , study.getDescription()
                , study.getAddress()
                , study.getDifficulty()
                , study.getPlaceType()
                , study.getCapacity()
                , study.getStudyStartDate()
                , study.getStudyEndDate()
                , study.getRecruitStartAt()
                , study.getRecruitEndAt()
                , study.getFrequency()
        );
    }

    public static GetStudyResponse from(Study study) {
        return new GetStudyResponse(study);
    }
}
