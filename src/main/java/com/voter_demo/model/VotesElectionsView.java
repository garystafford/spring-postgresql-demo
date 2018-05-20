package com.voter_demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "votes_by_elections")
public class VotesElectionsView implements Serializable {

    @Id
    @JsonIgnore
    private long id;

    private String election;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;
}
