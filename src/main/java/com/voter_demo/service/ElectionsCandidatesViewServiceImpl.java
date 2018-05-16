package com.voter_demo.service;

import com.voter_demo.model.ElectionsCandidatesView;
import com.voter_demo.repository.ElectionsCandidatesViewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ElectionsCandidatesViewServiceImpl implements ElectionsCandidatesViewService {

    private final ElectionsCandidatesViewRepository electionsCandidatesViewRepository;

    @Autowired
    public ElectionsCandidatesViewServiceImpl(ElectionsCandidatesViewRepository electionsCandidatesViewRepository) {
        this.electionsCandidatesViewRepository = electionsCandidatesViewRepository;
    }

    @Override
    public Iterable<ElectionsCandidatesView> findAll() {
        return electionsCandidatesViewRepository.findAll();
    }

    @Override
    public List<ElectionsCandidatesView> findByElection(String election) {
        return electionsCandidatesViewRepository.findByElection(election);
    }

}
