package com.codingjudge.service;

import com.codingjudge.entity.Problem;
import com.codingjudge.repository.ProblemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProblemService {

    private final ProblemRepository repository;

    public ProblemService(ProblemRepository repository) {
        this.repository = repository;
    }

    public Problem createProblem(Problem problem) {
        return repository.save(problem);
    }

    public List<Problem> getAllProblems() {
        return repository.findAll();
    }

    public Problem getProblemById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Problem updateProblem(Long id, Problem updatedProblem) {

    Problem problem = repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Problem not found"));

    problem.setTitle(updatedProblem.getTitle());
    problem.setDescription(updatedProblem.getDescription());
    problem.setDifficulty(updatedProblem.getDifficulty());
    problem.setSampleInput(updatedProblem.getSampleInput());
    problem.setSampleOutput(updatedProblem.getSampleOutput());
    problem.setConstraints(updatedProblem.getConstraints());

    return repository.save(problem);
    }

    public void deleteProblem(Long id) {
        repository.deleteById(id);
    }

    
}