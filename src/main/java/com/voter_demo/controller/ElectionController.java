package com.voter_demo.controller;

import com.voter_demo.model.Election;
import com.voter_demo.repository.ElectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/elections")
public class ElectionController {

    private final ElectionRepository electionRepository;

    @Autowired
    public ElectionController(ElectionRepository electionRepository) {
        this.electionRepository = electionRepository;
    }

    @RequestMapping(path = "/summary", method = RequestMethod.GET)
    public ResponseEntity<Map<String, List<Election>>> electionsSummary() {
        List<Election> electionList = electionRepository.findAll();
        return new ResponseEntity<>(Collections.singletonMap("elections", electionList), HttpStatus.OK);
    }
}
