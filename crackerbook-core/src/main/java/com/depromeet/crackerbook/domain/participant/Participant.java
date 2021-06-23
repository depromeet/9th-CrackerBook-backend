package com.depromeet.crackerbook.domain.participant;

import com.depromeet.crackerbook.domain.BaseEntity;
import com.depromeet.crackerbook.domain.study.Study;
import com.depromeet.crackerbook.domain.user.User;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;

@Builder
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Participant extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "participant_id")
    private Long participantId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "study_id")
    private Study study;

    public static Participant CreateParticipant(
            User user
            , Study study
    ) {
        return new ParticipantBuilder()
                .user(user)
                .study(study)
                .build()
                ;
    }
}
