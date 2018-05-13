package com.voter_demo.repository;

import com.voter_demo.model.Vote;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface VoteRepository extends PagingAndSortingRepository<Vote, Long> {
}