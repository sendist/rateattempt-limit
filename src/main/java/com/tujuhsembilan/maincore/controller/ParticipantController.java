package com.tujuhsembilan.maincore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tujuhsembilan.maincore.controller.dto.ParticipantDTO;
import com.tujuhsembilan.maincore.model.Participant;
import com.tujuhsembilan.maincore.repository.ParticipantRepository;

import io.github.bucket4j.Bucket;
import io.github.bucket4j.ConsumptionProbe;

// Case Study:
// 1. Tambahkan repo, dan buat setiap query sudah menggunakan prepare statement & parameterized
// 2. Tambahkan Encryption password
// 3. Tambahakan rate limit hit api tsb
// 4. Sesuaikan Data type id
@RestController
@RequestMapping("/participant")
public class ParticipantController {
    private final ParticipantRepository participantRepository;
    private final PasswordEncoder passwordEncoder;
    private final Bucket bucket;

    @Autowired
    public ParticipantController(ParticipantRepository participantRepository, PasswordEncoder passwordEncoder, Bucket bucket) {
        this.participantRepository = participantRepository;
        this.passwordEncoder = passwordEncoder;
        this.bucket = bucket;
    }

    @PostMapping
    public ResponseEntity<Object> addCompany(@RequestBody ParticipantDTO dto) {
        ConsumptionProbe probe = bucket.tryConsumeAndReturnRemaining(1);
        if (probe.isConsumed()) {
            Participant participant = new Participant();
            participant.setParticipantName(dto.getParticipantName());
            String encryptedPassword = passwordEncoder.encode(dto.getPassword());   
            participant.setPassword(encryptedPassword);

            participantRepository.save(participant);

            return ResponseEntity.ok(participant);
        } else {
            return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS).build();
        }
    }
}
