package com.voter_demo.repository;

import com.voter_demo.model.Candidate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

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
    public void shouldReturnCandidateWithCorrectLastName() {

        // given
        Candidate candidate = new Candidate(
                "Mary",
                "Jones",
                "Democratic Party",
                "New York",
                "None"
        );

        entityManager.persist(candidate);
        entityManager.flush();

        // when
        List<Candidate> found = candidateRepository.findByLastName(candidate.getLastName());

        // then
        assertThat(found.get(0).getLastName()).isEqualTo(candidate.getLastName());
    }
}
