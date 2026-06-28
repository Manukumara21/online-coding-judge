package com.codingjudge.controller;

import com.codingjudge.entity.Contest;
import com.codingjudge.service.ContestService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contests")
public class ContestController {

    private final ContestService service;

    public ContestController(ContestService service) {
        this.service = service;
    }

    @PostMapping
    public Contest createContest(@RequestBody Contest contest) {
        return service.createContest(contest);
    }

    @GetMapping
    public List<Contest> getAllContests() {
        return service.getAllContests();
    }

    @GetMapping("/{id}")
    public Contest getContestById(@PathVariable Long id) {
        return service.getContestById(id);
    }

    @PutMapping("/{id}")
public Contest updateContest(
        @PathVariable Long id,
        @RequestBody Contest contest) {

    return service.updateContest(id, contest);
}

@DeleteMapping("/{id}")
public String deleteContest(@PathVariable Long id) {

    service.deleteContest(id);

    return "Contest deleted successfully";
}


}