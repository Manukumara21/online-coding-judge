package com.codingjudge.controller;

import com.codingjudge.entity.ContestParticipant;
import com.codingjudge.service.ContestParticipantService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contest-participants")
public class ContestParticipantController {

    private final ContestParticipantService service;

    public ContestParticipantController(
            ContestParticipantService service) {
        this.service = service;
    }

    @PostMapping
    public ContestParticipant joinContest(
            @RequestBody ContestParticipant participant) {

        return service.joinContest(participant);
    }

    @GetMapping("/contest/{contestId}")
    public List<ContestParticipant> getContestParticipants(
            @PathVariable Long contestId) {

        return service.getContestParticipants(contestId);
    }

    @GetMapping("/user/{userId}")
    public List<ContestParticipant> getUserContests(
            @PathVariable Long userId) {

        return service.getUserContests(userId);
    }
}