package com.voter_demo.controller;

import com.voter_demo.model.Candidate;
import com.voter_demo.repository.CandidateRepository;
import com.voter_demo.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/candidates")
public class CandidateController {

    private final CandidateService candidateService;

    @Autowired
    public CandidateController(CandidateService candidateService) {
        this.candidateService = candidateService;
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Candidate> getCandidates() {
        return candidateService.findAll();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public void updateCandidate(@PathVariable Long id, @RequestBody Candidate candidate) {
        candidateService.updateCandidate(id, candidate);
    }


    @RequestMapping(path = "/summary", method = RequestMethod.GET)
    public ResponseEntity<Map<String, List<Candidate>>> candidatesSummary() {
        List<Candidate> candidateList = candidateService.findAll();
        return new ResponseEntity<>(Collections.singletonMap("candidates", candidateList), HttpStatus.OK);
    }

    @RequestMapping(path = "/summary/{politicalParty}", method = RequestMethod.GET)
    public ResponseEntity<Map<String, List<Candidate>>> candidatesSummary(@PathVariable String politicalParty) {
        List<Candidate> candidateList = candidateService.findByPoliticalParty(politicalParty);
        return new ResponseEntity<>(Collections.singletonMap("candidates", candidateList), HttpStatus.OK);
    }
}
