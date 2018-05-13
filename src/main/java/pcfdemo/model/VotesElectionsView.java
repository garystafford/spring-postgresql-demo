package pcfdemo.model;

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
@Table(name = "votes_by_elections")
public class VotesElectionsView implements Serializable {

    @Id
    @Setter(AccessLevel.NONE)
    @JsonIgnore
    private long id;

    @NotNull
    @Setter(AccessLevel.NONE)
    private String election;

    @NotNull
    @Setter(AccessLevel.NONE)
    @Column(name = "first_name")
    private String firstName;

    @NotNull
    @Setter(AccessLevel.NONE)
    @Column(name = "last_name")
    private String lastName;
}
