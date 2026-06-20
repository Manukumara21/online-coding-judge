
package com.codingjudge.controller;

import com.codingjudge.entity.Problem;
import com.codingjudge.service.ProblemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/problems")
public class ProblemController {

    private final ProblemService service;

    public ProblemController(ProblemService service) {
        this.service = service;
    }

    @PostMapping
    public Problem createProblem(@RequestBody Problem problem) {
        return service.createProblem(problem);
    }

    @GetMapping
    public List<Problem> getAllProblems() {
        return service.getAllProblems();
    }

    @GetMapping("/{id}")
    public Problem getProblemById(@PathVariable Long id) {
        return service.getProblemById(id);
    }

    @PutMapping("/{id}")
    public Problem updateProblem(
        @PathVariable Long id,
        @RequestBody Problem problem) {

        return service.updateProblem(id, problem);
    }

    @DeleteMapping("/{id}")
    public String deleteProblem(@PathVariable Long id) {

        service.deleteProblem(id);

        return "Problem deleted successfully";
    }
}