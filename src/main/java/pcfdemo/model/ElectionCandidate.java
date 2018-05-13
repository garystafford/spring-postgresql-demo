package pcfdemo.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@Entity
public class ElectionCandidate implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Column(name = "election_id")
    private long electionId;

    @NotNull
    @Column(name = "candidate_id")
    private long candidateId;
}
