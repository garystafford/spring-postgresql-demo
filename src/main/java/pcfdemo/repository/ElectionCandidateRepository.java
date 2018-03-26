package pcfdemo.repository;

import org.springframework.data.repository.CrudRepository;
import pcfdemo.model.ElectionCandidate;

public interface ElectionCandidateRepository extends CrudRepository<ElectionCandidate, Long> {
}
