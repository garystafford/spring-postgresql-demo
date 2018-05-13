package com.voter_demo.repository;

import com.voter_demo.model.ElectionCandidate;
import org.springframework.data.repository.CrudRepository;

public interface ElectionCandidateRepository extends CrudRepository<ElectionCandidate, Long> {
}
