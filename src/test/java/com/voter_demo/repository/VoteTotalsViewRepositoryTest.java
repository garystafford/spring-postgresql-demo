package com.voter_demo.repository;

import com.voter_demo.model.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class VoteTotalsViewRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private VoteTotalsViewRepository voteTotalsViewRepository;

    private Election election;

    private Candidate candidate;

    private void setupData() {
        Election election = new Election(
                new Date(1541480400000L),
                "Test",
                "2018 Test Election",
                4,
                "Test election description"
        );

        entityManager.persist(election);
        entityManager.flush();

        this.election = election;

        Candidate candidate = new Candidate(
                "Test",
                "Candidate",
                "Test Party",
                "Test State",
                "Test candidate's experience"
        );

        entityManager.persist(candidate);
        entityManager.flush();

        this.candidate = candidate;

        ElectionCandidate electionCandidate = new ElectionCandidate(
                election.getId(),
                candidate.getId()
        );

        entityManager.persist(electionCandidate);
        entityManager.flush();

        Vote vote = new Vote(
                electionCandidate.getId()
        );

        entityManager.persist(vote);
        entityManager.flush();

    }

    @Test
    public void findByElectionShouldReturnCorrectVotes() {
        // given
        setupData();

        // when
        List<VoteTotalsView> found = voteTotalsViewRepository.findByElectionContains(this.election.getTitle());

        // then
        assertThat(found.get(0)).isEqualTo(this.election.getTitle());

    }

    @Test
    public void findByCandidateShouldReturnCorrectVotes() {
        // given
        setupData();

        // when
        List<VoteTotalsView> found = voteTotalsViewRepository.findByCandidateContains(
                String.format("%s, %s", this.candidate.getLastName(), this.candidate.getFirstName()));

        // then
        assertThat(found.get(0)).isEqualTo(this.election.getTitle());

    }

}