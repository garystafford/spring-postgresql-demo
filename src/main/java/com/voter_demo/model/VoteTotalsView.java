package com.voter_demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@Entity
@Table(name = "vote_totals")
@Setter(AccessLevel.NONE)
public class VoteTotalsView implements Serializable {

    @Id
    @JsonIgnore
    private long id;

    @NotNull
    private String election;

    @NotNull
    private String candidate;

    @NotNull
    private Integer votes;
}
