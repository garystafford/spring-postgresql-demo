package com.voter_demo.repository;

import com.voter_demo.model.Candidate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CandidateRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CandidateRepository candidateRepository;

    public CandidateRepositoryTest() {
    }

    @Test
    public void shouldReturnCandidateWithCorrectId() {

        // given
        Candidate candidate = setupData();

        // when
        Optional<Candidate> found = candidateRepository.findById(candidate.getId());

        // then
        assertThat(found.get().getId()).isEqualTo(candidate.getId());
    }

    @Test
    public void shouldReturnCandidateWithCorrectFirstName() {

        // given
        Candidate candidate = setupData();

        // when
        List<Candidate> found = candidateRepository.findByFirstName(candidate.getFirstName());

        // then
        assertThat(found.get(0).getFirstName()).isEqualTo(candidate.getFirstName());
    }

    @Test
    public void shouldReturnCandidateWithCorrectLastName() {

        // given
        Candidate candidate = setupData();

        // when
        List<Candidate> found = candidateRepository.findByLastName(candidate.getLastName());

        // then
        assertThat(found.get(0).getLastName()).isEqualTo(candidate.getLastName());
    }

    @Test
    public void shouldReturnCandidateWithCorrectHomeState() {

        // given
        Candidate candidate = setupData();

        // when
        List<Candidate> found = candidateRepository.findByHomeState(candidate.getHomeState());

        // then
        assertThat(found.get(0).getHomeState()).isEqualTo(candidate.getHomeState());
    }

    @Test
    public void shouldReturnCandidateWithCorrectPoliticalParty() {

        // given
        Candidate candidate = setupData();

        // when
        List<Candidate> found = candidateRepository.findByPoliticalParty(candidate.getPoliticalParty());

        // then
        assertThat(found.get(0).getPoliticalParty()).isEqualTo(candidate.getPoliticalParty());
    }

    @Test
    public void shouldReturnCandidateWithCorrectDescription() {

        // given
        Candidate candidate = setupData();

        // when
        List<Candidate> found = candidateRepository.findByExperienceContains(candidate.getExperience());

        // then
        assertThat(found.get(0).getExperience()).isEqualTo(candidate.getExperience());
    }

    private Candidate setupData() {
        Candidate candidate = new Candidate(
                "Test",
                "Candidate",
                "Test Party",
                "Test State",
                "Test candidate's experience"
        );

        entityManager.persist(candidate);
        entityManager.flush();

        return candidate;
    }
}
