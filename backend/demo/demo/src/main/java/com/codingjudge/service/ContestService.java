package com.codingjudge.service;

import com.codingjudge.entity.Contest;
import com.codingjudge.repository.ContestRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContestService {

    private final ContestRepository repository;

    public ContestService(ContestRepository repository) {
        this.repository = repository;
    }

    public Contest createContest(Contest contest) {
        return repository.save(contest);
    }

    public List<Contest> getAllContests() {
        return repository.findAll();
    }

    public Contest getContestById(Long id) {
        return repository.findById(id).orElse(null);
    }
    public Contest updateContest(Long id, Contest updatedContest) {

    Contest contest = repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Contest not found"));

    contest.setTitle(updatedContest.getTitle());
    contest.setDescription(updatedContest.getDescription());
    contest.setStartTime(updatedContest.getStartTime());
    contest.setEndTime(updatedContest.getEndTime());

    return repository.save(contest);
}

public void deleteContest(Long id) {
    repository.deleteById(id);
}
}
