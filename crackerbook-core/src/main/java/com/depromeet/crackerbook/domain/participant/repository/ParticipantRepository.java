package com.depromeet.crackerbook.domain.participant.repository;

import com.depromeet.crackerbook.domain.participant.Participant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipantRepository extends JpaRepository<Participant, Long>, ParticipantRepositoryCustom {
}
