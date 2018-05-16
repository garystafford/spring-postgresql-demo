package com.voter_demo.service;

import com.voter_demo.model.ElectionsCandidatesView;

import java.util.List;

public interface ElectionsCandidatesViewService {
    Iterable<ElectionsCandidatesView> findAll();

    List<ElectionsCandidatesView> findByElection(String election);
}
