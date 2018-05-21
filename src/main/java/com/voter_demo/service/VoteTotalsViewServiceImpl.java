package com.voter_demo.service;

import com.voter_demo.model.VoteTotalsView;
import com.voter_demo.repository.VoteTotalsViewRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoteTotalsViewServiceImpl implements VoteTotalsViewService {

    private final VoteTotalsViewRepository voteTotalsViewRepository;

    public VoteTotalsViewServiceImpl(VoteTotalsViewRepository voteTotalsViewRepository) {
        this.voteTotalsViewRepository = voteTotalsViewRepository;
    }

    @Override
    public Iterable<VoteTotalsView> findAll() {
        return voteTotalsViewRepository.findAll();
    }

    @Override
    public List<VoteTotalsView> findByElection(String election) {
        return voteTotalsViewRepository.findByElectionContains(election);
    }

    @Override
    public List<VoteTotalsView> findByCandidate(String candidate) {
        return voteTotalsViewRepository.findByCandidateContains(candidate);
    }

}
