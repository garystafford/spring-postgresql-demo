package com.voter_demo.service;

import com.voter_demo.model.Candidate;
import com.voter_demo.model.dto.CandidateDTO;
import com.voter_demo.repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CandidateServiceImpl implements CandidateService {

    private final CandidateRepository candidateRepository;

    @Autowired
    public CandidateServiceImpl(CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }

    @Override
    public void createCandidate(Candidate candidate) {
        candidateRepository.save(candidate);
    }

    @Override
    public void updateCandidate(Long id, Candidate candidateNew) {
        Candidate candidateOld = candidateRepository.findById(id).get();
        candidateOld.setFirstName(candidateNew.getFirstName());
        candidateOld.setLastName(candidateNew.getLastName());
        candidateOld.setPoliticalParty(candidateNew.getPoliticalParty());
        candidateOld.setHomeState(candidateNew.getHomeState());
        candidateOld.setExperience(candidateNew.getExperience());
        candidateRepository.save(candidateOld);
    }

    @Override
    public List<Candidate> findAll() {
        return candidateRepository.findAll();
    }

    @Override
    public List<Candidate> findByPoliticalParty (String politicalParty) {
        return candidateRepository.findByPoliticalParty(politicalParty);
    }
}
