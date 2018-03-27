package pcfdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pcfdemo.model.Candidate;
import pcfdemo.repository.CandidateRepository;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/candidates")
public class CandidateController {

    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    public CandidateController(CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }

    @RequestMapping(path = "/summary", method = RequestMethod.GET)
    public ResponseEntity<Map<String, List<Candidate>>> candidatesSummary() {
        List<Candidate> candidateList = (List<Candidate>) candidateRepository.findAll();
        return new ResponseEntity<>(Collections.singletonMap("candidates", candidateList), HttpStatus.OK);
    }

    @RequestMapping(path = "/summary/{politicalParty}", method = RequestMethod.GET)
    public ResponseEntity<Map<String, List<Candidate>>> candidatesSummary(@PathVariable String politicalParty) {
        List<Candidate> candidateList = candidateRepository.findByPoliticalParty(politicalParty);
        return new ResponseEntity<>(Collections.singletonMap("candidates", candidateList), HttpStatus.OK);
    }
}
