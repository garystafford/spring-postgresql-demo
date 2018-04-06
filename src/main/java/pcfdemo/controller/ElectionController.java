package pcfdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pcfdemo.model.Election;
import pcfdemo.repository.ElectionRepository;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/elections")
public class ElectionController {

    private class ElectionSummary implements Serializable {
        @NotNull
        private java.sql.Date date;

        @NotNull
        private String type;

        @NotNull
        private String title;

        @NotNull
        private long term;

        private String description;
    }

    @Autowired
    private ElectionRepository electionRepository;

    @Autowired
    public ElectionController(ElectionRepository electionRepository) {
        this.electionRepository = electionRepository;
    }

    @RequestMapping(path = "/summary", method = RequestMethod.GET)
    public ResponseEntity<Map<String, List<Election>>> electionsSummary() {
        List<Election> electionList = (List<Election>) electionRepository.findAll();
        return new ResponseEntity<>(Collections.singletonMap("elections", electionList), HttpStatus.OK);
    }
}
