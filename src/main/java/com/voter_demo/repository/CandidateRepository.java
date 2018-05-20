package com.voter_demo.repository;

import com.voter_demo.model.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CandidateRepository extends JpaRepository<Candidate, Long> {

    List<Candidate> findByLastName(String lastName);

    List<Candidate> findByFirstName(String firstName);

    List<Candidate> findByPoliticalParty(String politicalParty);

    List<Candidate> findByHomeState(String homeState);

    List<Candidate> findByExperienceContains(String experience);

}
