package pcfdemo.model;

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
@Table(name = "candidates_by_elections")
public class ElectionsCandidatesView implements Serializable {

    @Id
    @Setter(AccessLevel.NONE)
    @JsonIgnore
    private long id;

    @NotNull
    @Setter(AccessLevel.NONE)
    private String election;

    @NotNull
    @Setter(AccessLevel.NONE)
    private String first_name;

    @NotNull
    @Setter(AccessLevel.NONE)
    private String last_name;
}
