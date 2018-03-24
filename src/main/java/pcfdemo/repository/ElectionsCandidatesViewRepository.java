package pcfdemo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import pcfdemo.model.ElectionsCandidatesView;

import java.util.List;

@RepositoryRestResource(path = "election-candidates")
public interface ElectionsCandidatesViewRepository extends CrudRepository<ElectionsCandidatesView, Long> {

    List<ElectionsCandidatesView> findByElection(String election);

}
