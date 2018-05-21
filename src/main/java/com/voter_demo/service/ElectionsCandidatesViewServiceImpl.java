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
    public List<ElectionsCandidatesView> findByFirstName(String firstName) {
        return electionsCandidatesViewRepository.findByFirstName(firstName);
    }

    @Override
    public List<ElectionsCandidatesView> findByLastName(String lastName) {
        return electionsCandidatesViewRepository.findByLastName(lastName);
    }

    @Override
    public List<ElectionsCandidatesView> findByElection(String election) {
        return electionsCandidatesViewRepository.findByElectionContains(election);
    }

}
