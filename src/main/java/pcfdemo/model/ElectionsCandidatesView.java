package pcfdemo.model;
        import org.hibernate.annotations.NamedQuery;

        import javax.persistence.Entity;
        import javax.persistence.Id;
        import javax.persistence.Table;
        import java.io.Serializable;

@Entity
@Table(name="candidates_by_election")
public class ElectionsCandidatesView implements Serializable {

    @Id
    private long id;

    private String first_name;

    private String last_name;

    private String election;
}
