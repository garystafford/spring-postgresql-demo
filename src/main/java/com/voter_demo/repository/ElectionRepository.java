package com.voter_demo.repository;

import com.voter_demo.model.Election;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ElectionRepository extends CrudRepository<Election, Long> {

    List<Election> findByTitle(String title);

    List<Election> findByDate(String date);

    List<Election> findByDescriptionContains(String description);

}
