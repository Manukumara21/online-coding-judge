package com.codingjudge.controller;

import com.codingjudge.entity.Submission;
import com.codingjudge.service.SubmissionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/submissions")
public class SubmissionController {

    private final SubmissionService service;

    public SubmissionController(SubmissionService service) {
        this.service = service;
    }

    @PostMapping
    public Submission submitCode(@RequestBody Submission submission) {
        return service.submitCode(submission);
    }

    @GetMapping("/{id}")
    public Submission getSubmissionById(@PathVariable Long id) {
        return service.getSubmissionById(id);
    }

    @GetMapping("/user/{userId}")
    public List<Submission> getUserSubmissions(
            @PathVariable Long userId) {

        return service.getUserSubmissions(userId);
    }
}