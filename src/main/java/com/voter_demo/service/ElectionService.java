package com.voter_demo.service;

import com.voter_demo.model.Election;

import java.util.List;

public interface ElectionService {

    List<Election> findAll();
}
