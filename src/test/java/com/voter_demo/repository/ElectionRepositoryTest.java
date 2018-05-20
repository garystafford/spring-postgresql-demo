package com.voter_demo.repository;

import com.voter_demo.model.Election;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ElectionRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ElectionRepository electionRepository;

    public ElectionRepositoryTest() {
    }

    @Test
    public void shouldReturnCandidateWithCorrectId() {

        // given
        Election election = setupData();

        // when
        Optional<Election> found = electionRepository.findById(election.getId());

        // then
        assertThat(found.get().getId()).isEqualTo(election.getId());
    }

    @Test
    public void shouldReturnCandidateWithCorrectDate() {

        // given
        Election election = setupData();

        // when
        List<Election> found = electionRepository.findByDate(election.getDate());

        // then
        assertThat(found.get(0).getDate()).isEqualTo(election.getDate());
    }

    @Test
    public void shouldReturnCandidateWithCorrectType() {

        // given
        Election election = setupData();

        // when
        List<Election> found = electionRepository.findByType(election.getType());

        // then
        assertThat(found.get(0).getType()).isEqualTo(election.getType());
    }

    @Test
    public void shouldReturnCandidateWithCorrectTitle() {

        // given
        Election election = setupData();

        // when
        List<Election> found = electionRepository.findByTitle(election.getTitle());

        // then
        assertThat(found.get(0).getTitle()).isEqualTo(election.getTitle());
    }

    @Test
    public void shouldReturnCandidateWithCorrectTerm() {

        // given
        Election election = setupData();

        // when
        List<Election> found = electionRepository.findByTerm(election.getTerm());

        // then
        assertThat(found.get(0).getTerm()).isEqualTo(election.getTerm());
    }

    @Test
    public void shouldReturnCandidateWithCorrectDescription() {

        // given
        Election election = setupData();

        // when
        List<Election> found = electionRepository.findByDescriptionContains(election.getDescription());

        // then
        assertThat(found.get(0).getDescription()).isEqualTo(election.getDescription());
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

        return election;
    }

}
