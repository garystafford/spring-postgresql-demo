package com.voter_demo.repository;

import com.voter_demo.model.Candidate;
import com.voter_demo.model.Election;
import com.voter_demo.model.ElectionCandidate;
import com.voter_demo.model.Vote;
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
public class VoteRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private VoteRepository voteRepository;

    public VoteRepositoryTest() {
    }

    @Test
    public void shouldReturnVoteWithCorrectId() {

        // given
        Vote vote = setupData();

        // when
        Optional<Vote> found = voteRepository.findById(vote.getId());

        // then
        assertThat(found.get().getId()).isEqualTo(vote.getId());
    }

    @Test
    public void shouldReturnVoteWithCorrectElectionCandidateId() {

        // given
        Vote vote = setupData();

        // when
        Optional<Vote> found = voteRepository.findById(vote.getId());

        // then
        assertThat(found.get().getElectionCandidateId()).isEqualTo(vote.getElectionCandidateId());
    }

    private Vote setupData() {
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

        return vote;
    }

}