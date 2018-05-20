package com.voter_demo.controller;

import com.voter_demo.model.Candidate;
import com.voter_demo.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping(path = "/summary", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Map<String, List<Candidate>>> candidateSummary() {
        List<Candidate> candidateList = candidateService.findAll();
        return new ResponseEntity<>(Collections.singletonMap("candidates", candidateList), HttpStatus.OK);
    }

//    @RequestMapping(method = RequestMethod.GET)
//    @ResponseBody
//    public ResponseEntity<Map<String, List<Candidate>>> getCandidates() {
//
//        List<Candidate> candidateList = candidateService.getCandidates();
//        return new ResponseEntity<>(Collections.singletonMap("candidates", candidateList), HttpStatus.OK);
//    }
//
//    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
//    @ResponseBody
//    public ResponseEntity<Candidate> getCandidate(@PathVariable Long id) {
//        Candidate candidate = candidateService.getCandidate(id);
//        return new ResponseEntity(candidate, HttpStatus.OK);
//    }
//
//    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
//    @ResponseBody
//    public void updateCandidate(@PathVariable Long id, @RequestBody Candidate candidate) {
//        candidateService.updateCandidate(id, candidate);
//    }

}
