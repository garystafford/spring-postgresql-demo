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
    public void shouldReturnCandidateWithCorrectLastName() {

        // given
        Election election = setupData();

        // when
        List<Election> found = electionRepository.findByTitle(election.getTitle());

        // then
        assertThat(found.get(0).getTitle()).isEqualTo(election.getTitle());
    }

    private Election setupData() {
        Election election = new Election(
                new Date(1541480400),
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
