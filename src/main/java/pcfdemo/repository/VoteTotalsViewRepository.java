package pcfdemo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import pcfdemo.model.VoteTotalsView;

import java.util.List;

@RepositoryRestResource(path = "votetotals")
public interface VoteTotalsViewRepository extends CrudRepository<VoteTotalsView, Long> {

    List<VoteTotalsView> findByElection(String election);
}
