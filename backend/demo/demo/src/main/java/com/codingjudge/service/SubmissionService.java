package com.codingjudge.service;

import com.codingjudge.entity.Submission;
import com.codingjudge.repository.SubmissionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubmissionService {

    private final SubmissionRepository repository;

    public SubmissionService(SubmissionRepository repository) {
        this.repository = repository;
    }

    public Submission submitCode(Submission submission) {

    if (submission.getSourceCode().contains("class Solution")) {
        submission.setStatus("ACCEPTED");
    } else {
        submission.setStatus("WRONG_ANSWER");
    }

    return repository.save(submission);
    }

    public Submission getSubmissionById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<Submission> getUserSubmissions(Long userId) {
        return repository.findByUserId(userId);
    }

    public List<Submission> getProblemSubmissions(Long problemId) {
        return repository.findByProblemId(problemId);
    }
}