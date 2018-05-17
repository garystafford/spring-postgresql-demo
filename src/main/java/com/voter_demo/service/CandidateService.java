package com.voter_demo.service;

import com.voter_demo.model.Candidate;

import java.util.List;

public interface CandidateService {
    void updateCandidate(Long id, Candidate candidate);

    List<Candidate> findAll();

    List<Candidate> findByPoliticalParty(String politicalParty);

    void createCandidate(Candidate candidate);
}
