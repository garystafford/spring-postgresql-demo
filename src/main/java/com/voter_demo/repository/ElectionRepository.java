package com.voter_demo.repository;

import com.voter_demo.model.Election;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ElectionRepository extends JpaRepository<Election, Long> {

    List<Election> findByTitle(String title);

    List<Election> findByDate(String date);

    List<Election> findByDescriptionContains(String description);

}
