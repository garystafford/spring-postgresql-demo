package pcfdemo.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class ElectionCandidate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "election_id")
    private Election election;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;
}
