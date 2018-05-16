package com.voter_demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@Entity
@Table(name = "candidates_by_elections")
@Setter(AccessLevel.NONE)
public class ElectionsCandidatesView implements Serializable {

    @Id
    @JsonIgnore
    private long id;

    @NotNull
    private String election;

    @NotNull
    @Column(name = "first_name")
    private String firstName;

    @NotNull
    @Column(name = "last_name")
    private String lastName;
}
