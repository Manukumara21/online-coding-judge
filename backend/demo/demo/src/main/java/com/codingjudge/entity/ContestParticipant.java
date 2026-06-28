package com.codingjudge.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "contest_participants")
public class ContestParticipant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    private Long contestId;

    private Long joinedAt;

    @PrePersist
    protected void onJoin() {
        joinedAt = System.currentTimeMillis();
    }

    public ContestParticipant() {
    }

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getContestId() {
        return contestId;
    }

    public void setContestId(Long contestId) {
        this.contestId = contestId;
    }

    public Long getJoinedAt() {
        return joinedAt;
    }
}