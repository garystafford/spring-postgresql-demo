package com.voter_demo.repository;

import com.voter_demo.model.Election;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;

public interface ElectionRepository extends JpaRepository<Election, Long> {

    List<Election> findByDate(Date date);

    List<Election> findByType(String type);

    List<Election> findByTitle(String title);

    List<Election> findByTerm(Long term);

    List<Election> findByDescriptionContains(String description);

}
