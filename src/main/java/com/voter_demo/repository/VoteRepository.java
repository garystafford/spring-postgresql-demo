package com.voter_demo.repository;

import com.voter_demo.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface VoteRepository extends JpaRepository<Vote, Long> {
}