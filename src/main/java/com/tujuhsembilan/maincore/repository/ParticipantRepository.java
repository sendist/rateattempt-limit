package com.tujuhsembilan.maincore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tujuhsembilan.maincore.model.Participant;

public interface ParticipantRepository extends JpaRepository<Participant, Integer> {
}
