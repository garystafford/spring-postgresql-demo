package com.voter_demo.repository;

import com.voter_demo.model.Candidate;
import com.voter_demo.model.Election;
import com.voter_demo.model.ElectionCandidate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ElectionCandidateRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ElectionCandidateRepository electionCandidateRepository;

    public ElectionCandidateRepositoryTest() {
    }

    @Test
    public void shouldReturnElectionCandidateWithCorrectId() {

        // given
        ElectionCandidate electionCandidate = setupData();

        // when
        Optional<ElectionCandidate> found = electionCandidateRepository.findById(electionCandidate.getId());

        // then
        assertThat(found.get().getId()).isEqualTo(electionCandidate.getId());
    }

    @Test
    public void shouldReturnElectionCandidateWithCorrectElectionId() {

        // given
        ElectionCandidate electionCandidate = setupData();

        // when
        Optional<ElectionCandidate> found = electionCandidateRepository.findById(electionCandidate.getId());

        // then
        assertThat(found.get().getElectionId()).isEqualTo(electionCandidate.getElectionId());
    }

    @Test
    public void shouldReturnElectionCandidateWithCorrectCandidateId() {

        // given
        ElectionCandidate electionCandidate = setupData();

        // when
        Optional<ElectionCandidate> found = electionCandidateRepository.findById(electionCandidate.getId());

        // then
        assertThat(found.get().getCandidateId()).isEqualTo(electionCandidate.getCandidateId());
    }

    private ElectionCandidate setupData() {
        Election election = new Election(
                new Date(1541480400000L),
                "Test",
                "2018 Test Election",
                4,
                "Test election description"
        );

        entityManager.persist(election);
        entityManager.flush();

        Candidate candidate = new Candidate(
                "Test",
                "Candidate",
                "Test Party",
                "Test State",
                "Test candidate's experience"
        );

        entityManager.persist(candidate);
        entityManager.flush();

        ElectionCandidate electionCandidate = new ElectionCandidate(
                election.getId(),
                candidate.getId()
        );

        entityManager.persist(electionCandidate);
        entityManager.flush();

        return electionCandidate;
    }

}
