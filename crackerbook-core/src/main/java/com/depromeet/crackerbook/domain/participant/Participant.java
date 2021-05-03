package com.depromeet.crackerbook.domain.participant;

import com.depromeet.crackerbook.domain.BaseEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Participant extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "participant_id")
    private Long id;

    private Long userId;
    private Long studyId;

    @Builder
    public Participant(Long userId, Long studyId) {
        this.userId = userId;
        this.studyId = studyId;
    }

    @OneToMany
    @JoinColumn(name = "participant_attendance_id")
    private List<ParticipantAttendance> participantAttendanceList = new ArrayList<>();
}
