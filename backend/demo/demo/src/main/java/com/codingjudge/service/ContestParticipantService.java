package com.codingjudge.service;

import com.codingjudge.entity.ContestParticipant;
import com.codingjudge.repository.ContestParticipantRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContestParticipantService {

    private final ContestParticipantRepository repository;

    public ContestParticipantService(ContestParticipantRepository repository) {
        this.repository = repository;
    }

    public ContestParticipant joinContest(ContestParticipant participant) {

        if (repository.existsByUserIdAndContestId(
                participant.getUserId(),
                participant.getContestId())) {

            throw new RuntimeException("You have already joined this contest.");
        }

        return repository.save(participant);
    }

    public List<ContestParticipant> getContestParticipants(Long contestId) {
        return repository.findByContestId(contestId);
    }

    public List<ContestParticipant> getUserContests(Long userId) {
        return repository.findByUserId(userId);
    }
}