package com.depromeet.crackerbook.controller.study;

import com.depromeet.crackerbook.controller.SuccessResponse;
import com.depromeet.crackerbook.controller.study.dto.request.CreateStudyRequest;
import com.depromeet.crackerbook.controller.study.dto.request.UpdateStudyRequest;
import com.depromeet.crackerbook.controller.study.dto.response.CreateStudyResponse;
import com.depromeet.crackerbook.controller.study.dto.response.GetStudyResponse;
import com.depromeet.crackerbook.controller.study.dto.response.UpdateStudyResponse;
import com.depromeet.crackerbook.domain.study.Study;
import com.depromeet.crackerbook.service.study.StudyService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/studies")
public class StudyController {

    private final StudyService studyService;

    @Operation(summary = "스터디 조회")
    @GetMapping("/{studyId}")
    public SuccessResponse<GetStudyResponse> getStudy(@PathVariable Long studyId) {
        Study study = studyService.findStudyByStudyId(studyId);

        return new SuccessResponse<>(GetStudyResponse.from(study));
    }

    @Operation(summary = "스터디 등록")
    @PostMapping
    public SuccessResponse<CreateStudyResponse> createStudy(
            @RequestBody CreateStudyRequest dto
    ) {
//        dto.validate();
        // TODO Book ID와 ISBN을 기반으로 데이터를 조회할 수 있어야한다.
        Study study = studyService.createStudy(dto);

        return new SuccessResponse<>(CreateStudyResponse.from(study.getStudyId()));
    }

    @Operation(summary = "스터디 업데이트")
    @PutMapping("/{studyId}")
    public SuccessResponse<UpdateStudyResponse> updateStudy(
            @PathVariable Long studyId
            , @RequestBody UpdateStudyRequest dto
    ) {
        Study study = studyService.updateStudy(studyId, dto);

        return new SuccessResponse<>(UpdateStudyResponse.from(study.getStudyId()));
    }

//    @DeleteMapping("/{studyId}")
//    public String deleteStudy(@PathVariable String studyId) {
//
//    }
//
//
//    @PostMapping("/studies/{studyId}/apply")
//    public String applyStudy(@PathVariable String studyId) {
//
//    }
//
//    @PutMapping("/studies/{studyId}/apply")
//    public String cancelApplyStudy(@PathVariable String studyId) {
//
//    }
}
