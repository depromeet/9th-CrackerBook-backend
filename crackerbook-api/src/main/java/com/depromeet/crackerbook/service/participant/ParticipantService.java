package com.depromeet.crackerbook.service.participant;

import com.depromeet.crackerbook.domain.participant.dto.ParticipantDto;
import com.depromeet.crackerbook.domain.study.Study;
import com.depromeet.crackerbook.domain.user.User;
import com.depromeet.crackerbook.domain.participant.Participant;
import com.depromeet.crackerbook.domain.participant.repository.ParticipantRepository;
import com.depromeet.crackerbook.service.study.StudyService;
import com.depromeet.crackerbook.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ParticipantService {

    private Participant participant;
    private ParticipantRepository participantRepository;
    private StudyService studyService;
    private UserService userService;

    public Participant applyParticipant(Long studyId, Long userId) {
        Study study = studyService.findStudyByStudyId(studyId);
        User user = userService.findUserById(userId);

        Participant participant = Participant.CreateParticipant(
                user,
                study
        );

        participantRepository.save(participant);
        return participant;
    }

    public Long cancelParticipant(Long userId, Long studyId) {
        ParticipantDto participant = participantRepository.getStudyParticipantByUserId(userId, studyId);
        Long participantId = participant.getParticipantId();

        participantRepository.deleteById(participantId);
        return participantId;
    }
}
