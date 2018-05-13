package com.voter_demo.repository;

import com.voter_demo.model.Candidate;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CandidateRepository extends CrudRepository<Candidate, Long> {

    List<Candidate> findByLastName(String lastName);

    List<Candidate> findByFirstName(String firstName);

    List<Candidate> findByPoliticalParty(String politicalParty);

    List<Candidate> findByHomeState(String homeState);
}
