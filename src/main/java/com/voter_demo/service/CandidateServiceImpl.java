package com.voter_demo.service;

import com.voter_demo.model.Candidate;
import com.voter_demo.repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateServiceImpl implements CandidateService {

    private final CandidateRepository candidateRepository;

    @Autowired
    public CandidateServiceImpl(CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }

    @Override
    public List<Candidate> findAll() {
        return candidateRepository.findAll();
    }

//    @Override
//    public Candidate getCandidate(Long id) {
//        return candidateRepository.findById(id).get();
//    }
//
//    @Override
//    public List<Candidate> getCandidates() {
//        return candidateRepository.findAll();
//    }
//
//    @Override
//    public void createCandidate(Candidate candidate) {
//        candidateRepository.save(candidate);
//    }
//
//    @Override
//    public void updateCandidate(Long id, Candidate candidateNew) {
//        Candidate candidateOld = candidateRepository.findById(id).get();
//        candidateOld.setFirstName(candidateNew.getFirstName());
//        candidateOld.setLastName(candidateNew.getLastName());
//        candidateOld.setPoliticalParty(candidateNew.getPoliticalParty());
//        candidateOld.setHomeState(candidateNew.getHomeState());
//        candidateOld.setExperience(candidateNew.getExperience());
//        candidateRepository.save(candidateOld);
//    }
//
//    @Override
//    public void deleteCandidateById(Long id) {
//        candidateRepository.deleteById(id);
//    }
//
//    @Override
//    public void deleteCandidate(Candidate candidate) {
//        candidateRepository.delete(candidate);
//    }

}
