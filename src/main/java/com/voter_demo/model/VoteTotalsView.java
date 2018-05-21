package com.voter_demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "vote_totals")
public class VoteTotalsView implements Serializable {

    @Id
    @JsonIgnore
    private long id;

    private String election;

    private String candidate;

    private Integer votes;
}
