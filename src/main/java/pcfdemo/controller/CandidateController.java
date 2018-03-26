package pcfdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pcfdemo.model.Candidate;
import pcfdemo.repository.CandidateRepository;

import java.util.List;

@RestController
public class CandidateController {

    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    public CandidateController(CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }

    @RequestMapping("/")
    public String index() {
        return "Greetings from the CandidateController!";
    }

    @RequestMapping("/candidateSummary")
    public ResponseEntity<List<Candidate>> candidatesSummary() {
        List<Candidate> candidateList = (List<Candidate>) candidateRepository.findAll();
        return new ResponseEntity<>(candidateList, HttpStatus.OK);
    }


}
