package com.voter_demo.controller;

import com.voter_demo.model.VoteTotalsView;
import com.voter_demo.repository.VoteTotalsViewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/vote-totals")
public class VoteTotalsViewController {

    private final VoteTotalsViewRepository voteTotalsViewRepository;

    @Autowired
    public VoteTotalsViewController(VoteTotalsViewRepository voteTotalsViewRepository) {
        this.voteTotalsViewRepository = voteTotalsViewRepository;
    }

    @RequestMapping(path = "/summary", method = RequestMethod.GET)
    public ResponseEntity<Map<String, List<VoteTotalsView>>> voteTotalsSummary() {
        List<VoteTotalsView> electionsCandidatesViewList =
                (List<VoteTotalsView>) voteTotalsViewRepository.findAll();
        return new ResponseEntity<>(Collections.singletonMap("voteTotals", electionsCandidatesViewList), HttpStatus.OK);
    }

    @RequestMapping(path = "/summary/{election}", method = RequestMethod.GET)
    public ResponseEntity<Map<String, List<VoteTotalsView>>> voteTotalsSummaryByElection(@PathVariable("election") String election) {
        List<VoteTotalsView> electionsCandidatesViewList =
                voteTotalsViewRepository.findByElection(election);
        return new ResponseEntity<>(Collections.singletonMap("voteTotals", electionsCandidatesViewList), HttpStatus.OK);
    }
}
