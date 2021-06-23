package com.depromeet.crackerbook.controller.study;

import com.depromeet.crackerbook.controller.SuccessResponse;
import com.depromeet.crackerbook.controller.participant.dto.response.ApplyParticipantResponse;
import com.depromeet.crackerbook.controller.participant.dto.response.CancelParticipantResponse;
import com.depromeet.crackerbook.controller.study.dto.request.CreateStudyRequest;
import com.depromeet.crackerbook.controller.study.dto.request.UpdateStudyRequest;
import com.depromeet.crackerbook.controller.study.dto.response.CreateStudyResponse;
import com.depromeet.crackerbook.controller.study.dto.response.GetStudyResponse;
import com.depromeet.crackerbook.controller.study.dto.response.UpdateStudyResponse;
import com.depromeet.crackerbook.domain.participant.Participant;
import com.depromeet.crackerbook.domain.study.Study;
import com.depromeet.crackerbook.service.participant.ParticipantService;
import com.depromeet.crackerbook.service.study.StudyService;
import com.depromeet.crackerbook.util.RequestUtil;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/studies")
public class StudyController {

    private final StudyService studyService;
    private final ParticipantService participantService;

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

    @PostMapping("/studies/{studyId}/apply")
    public SuccessResponse<ApplyParticipantResponse> applyStudy(
            HttpServletRequest request
            , @PathVariable Long studyId
    ) {
        Long userId = RequestUtil.getUserId(request);

        Participant participant = participantService.applyParticipant(studyId, userId);

        return new SuccessResponse<>(ApplyParticipantResponse.of(participant.getParticipantId()));
    }

    @DeleteMapping("/studies/{studyId}/apply")
    public SuccessResponse<CancelParticipantResponse> cancelApplyStudy(
            HttpServletRequest request
            , @PathVariable Long studyId
    ) {
        Long userId = RequestUtil.getUserId(request);
        Long participantId = participantService.cancelParticipant(userId, studyId);

        return new SuccessResponse<>(CancelParticipantResponse.of(participantId));
    }
}
