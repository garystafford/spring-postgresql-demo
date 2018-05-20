package com.voter_demo.repository;

import com.voter_demo.model.VoteTotalsView;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(path = "vote-totals")
public interface VoteTotalsViewRepository extends CrudRepository<VoteTotalsView, Long> {

    List<VoteTotalsView> findByElectionContains(String election);

    List<VoteTotalsView> findByCandidateContains(String election);

}
