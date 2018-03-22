package pcfdemo.model;
        import javax.persistence.Entity;
        import javax.persistence.Id;
        import javax.validation.constraints.NotNull;

@Entity
public class CandidateElectionView {

    private long id;

    private String first_name;

    private String last_name;

    private String election;
}
