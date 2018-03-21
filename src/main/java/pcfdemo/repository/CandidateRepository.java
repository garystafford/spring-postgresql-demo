package pcfdemo.repository;

import org.springframework.data.repository.CrudRepository;
import pcfdemo.model.Candidate;

import java.util.List;

public interface CandidateRepository extends CrudRepository<Candidate, Long> {

    List<Candidate> findByLastName(String lastName);

    List<Candidate> findByFirstName(String firstName);

    List<Candidate> findByPoliticalParty(String politicalParty);

    List<Candidate> findByHomeState(String homeState);
}
