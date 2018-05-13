package com.voter_demo.repository;

import com.voter_demo.model.ElectionsCandidatesView;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(path = "election-candidates")
public interface ElectionsCandidatesViewRepository extends CrudRepository<ElectionsCandidatesView, Long> {

    List<ElectionsCandidatesView> findByElection(String election);

}
