package com.depromeet.crackerbook.service.participant;

import com.depromeet.crackerbook.exception.NotFoundApiException;
import com.depromeet.crackerbook.common.ErrorCode;
import com.depromeet.crackerbook.domain.study.Study;
import com.depromeet.crackerbook.domain.study.repository.StudyRepository;
import com.depromeet.crackerbook.domain.user.User;
import com.depromeet.crackerbook.domain.user.repository.UserRepository;
import com.depromeet.crackerbook.domain.participant.Participant;
import com.depromeet.crackerbook.domain.participant.repository.ParticipantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ParticipantService {

    private Participant participant;
    private ParticipantRepository participantRepository;
    private UserRepository userRepository;
    private StudyRepository studyRepository;

    public Participant applyParticipant(Long studyId, Long userId) {
        Study study = studyRepository.findById(studyId)
                .orElseThrow(() -> new NotFoundApiException(ErrorCode.INVALID_STUDY));

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundApiException(ErrorCode.INVALID_USER));

        Participant participant = Participant.CreateParticipant(
                study.getStudyId(),
                user.getUserId()
        );

        participantRepository.save(participant);
        return participant;
    }
}
