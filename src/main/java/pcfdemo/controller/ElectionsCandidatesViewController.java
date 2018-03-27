package pcfdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pcfdemo.model.ElectionsCandidatesView;
import pcfdemo.repository.ElectionsCandidatesViewRepository;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/election-candidates")
public class ElectionsCandidatesViewController {

    @Autowired
    private ElectionsCandidatesViewRepository electionsCandidatesViewRepository;

    @Autowired
    public ElectionsCandidatesViewController(ElectionsCandidatesViewRepository electionsCandidatesViewRepository) {
        this.electionsCandidatesViewRepository = electionsCandidatesViewRepository;
    }

    @RequestMapping(path = "/summary", method = RequestMethod.GET)
    public ResponseEntity<Map<String, List<ElectionsCandidatesView>>> electionCandidateSummary() {
        List<ElectionsCandidatesView> electionsCandidatesViewList =
                (List<ElectionsCandidatesView>) electionsCandidatesViewRepository.findAll();
        return new ResponseEntity<>(Collections.singletonMap("electionCandidates", electionsCandidatesViewList), HttpStatus.OK);
    }

    @RequestMapping(path = "/summary/{election}", method = RequestMethod.GET)
    public ResponseEntity<Map<String, List<ElectionsCandidatesView>>> electionCandidateSummaryByElection(@PathVariable("election") String election) {
        List<ElectionsCandidatesView> electionsCandidatesViewList =
                electionsCandidatesViewRepository.findByElection(election);
        return new ResponseEntity<>(Collections.singletonMap("electionCandidates", electionsCandidatesViewList), HttpStatus.OK);
    }
}
