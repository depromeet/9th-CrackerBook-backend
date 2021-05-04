package com.depromeet.crackerbook.domain.participant;

import com.depromeet.crackerbook.domain.BaseEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ParticipantAttendance extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "participant_attendance_id")
    private Long participantAttendanceId;

    @ManyToOne
    @JoinColumn(name = "participant_id")
    private Participant participant;

    private LocalDateTime studyDate;
    private Boolean isAttendance;
}
