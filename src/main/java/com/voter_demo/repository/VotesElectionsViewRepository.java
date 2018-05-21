package com.voter_demo.repository;

import com.voter_demo.model.VotesElectionsView;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(path = "election-votes")
public interface VotesElectionsViewRepository extends PagingAndSortingRepository<VotesElectionsView, Long> {

    List<VotesElectionsView> findByFirstName(String firstName);

    List<VotesElectionsView> findByLastName(String lastName);

    List<VotesElectionsView> findByElectionContains(String election);
}
