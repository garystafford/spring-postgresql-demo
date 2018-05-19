package com.voter_demo.repository;

import com.voter_demo.model.ElectionCandidate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ElectionCandidateRepository extends JpaRepository<ElectionCandidate, Long> {
}
