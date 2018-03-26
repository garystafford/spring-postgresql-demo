package pcfdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pcfdemo.model.ElectionsCandidatesView;
import pcfdemo.repository.ElectionsCandidatesViewRepository;

import java.util.List;

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
    public ResponseEntity<List<ElectionsCandidatesView>> candidatesSummary() {
        List<ElectionsCandidatesView> electionsCandidatesViewList =
                (List<ElectionsCandidatesView>) electionsCandidatesViewRepository.findAll();
        return new ResponseEntity<>(electionsCandidatesViewList, HttpStatus.OK);
    }
}
