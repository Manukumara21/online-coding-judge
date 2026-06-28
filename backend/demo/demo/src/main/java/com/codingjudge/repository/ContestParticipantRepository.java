package com.codingjudge.repository;

import com.codingjudge.entity.ContestParticipant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ContestParticipantRepository
        extends JpaRepository<ContestParticipant, Long> {

    boolean existsByUserIdAndContestId(
            Long userId,
            Long contestId
    );

    List<ContestParticipant> findByContestId(Long contestId);

    List<ContestParticipant> findByUserId(Long userId);

    Optional<ContestParticipant> findByUserIdAndContestId(
            Long userId,
            Long contestId
    );
}