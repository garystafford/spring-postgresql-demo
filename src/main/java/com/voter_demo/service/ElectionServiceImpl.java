package com.voter_demo.service;

import com.voter_demo.model.Election;
import com.voter_demo.repository.ElectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ElectionServiceImpl implements ElectionService {

    private final ElectionRepository electionRepository;

    @Autowired
    public ElectionServiceImpl(ElectionRepository electionRepository) {
        this.electionRepository = electionRepository;
    }

    @Override
    public List<Election> findAll() {
        return electionRepository.findAll();
    }

}
