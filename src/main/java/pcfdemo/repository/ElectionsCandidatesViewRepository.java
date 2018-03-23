package pcfdemo.repository;

import org.springframework.data.repository.CrudRepository;
import pcfdemo.model.ElectionsCandidatesView;

import java.util.List;

public interface ElectionsCandidatesViewRepository extends CrudRepository<ElectionsCandidatesView, Long> {

    List<ElectionsCandidatesView> findByElection(String election);

}
