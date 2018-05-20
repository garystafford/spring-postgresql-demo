package com.voter_demo.repository;

import com.voter_demo.model.VotesElectionsView;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "election-votes")
public interface VotesElectionsViewRepository extends PagingAndSortingRepository<VotesElectionsView, Long> {
}
