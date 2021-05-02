package com.depromeet.crackerbook.domain.participant;

import com.depromeet.crackerbook.domain.BaseEntity;
import lombok.AccessLevel;
import lombok.Builder;
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
    private Long id;

    private Long participantID;

    private LocalDateTime studyDate;
    private Boolean isAttendance;

    @Builder
    public ParticipantAttendance(Long participantID, LocalDateTime studyDate, Boolean isAttendance) {
        this.participantID = participantID;
        this.studyDate = studyDate;
        this.isAttendance = isAttendance;
    }
}
