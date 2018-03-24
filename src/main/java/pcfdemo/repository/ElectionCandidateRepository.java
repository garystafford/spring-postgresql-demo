package pcfdemo.repository;

import org.springframework.data.repository.CrudRepository;
import pcfdemo.model.ElectionCandidate;

import java.util.List;

public interface ElectionCandidateRepository extends CrudRepository<ElectionCandidate, Long> {

//    List<ElectionCandidate> findByCandidate_id(long candidateId);

//    List<ElectionCandidate> findByElection_id(long ElectionId);
}
