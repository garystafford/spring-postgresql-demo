package com.voter_demo.repository;

import com.voter_demo.model.*;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@Ignore
public class VoteTotalsViewRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private VoteTotalsViewRepository voteTotalsViewRepository;

    @Test
    public void findByElectionShouldReturnCorrectVotes() {
        // given
        Election election = setupData();

        // when
        List<VoteTotalsView> found = voteTotalsViewRepository.findByElectionContains(election.getTitle());

        // then
        assertThat(found.get(0)).isEqualTo(election.getTitle());

    }

    private Election setupData() {
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

        Vote vote = new Vote(
                electionCandidate.getId()
        );

        entityManager.persist(vote);
        entityManager.flush();

        return election;
    }
}