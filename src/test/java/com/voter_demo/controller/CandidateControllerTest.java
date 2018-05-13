package com.voter_demo.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import com.voter_demo.model.Candidate;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class git CandidateControllerTest {

    @Autowired
    private CandidateController candidateController;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void candidatesSummary() {

        ResponseEntity<Map<String, List<Candidate>>> candidates = candidateController.candidatesSummary();

        assertThat(candidates.getStatusCode().value() == 200).isTrue();
    }
}
