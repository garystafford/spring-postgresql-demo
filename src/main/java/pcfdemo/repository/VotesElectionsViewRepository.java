package pcfdemo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import pcfdemo.model.VotesElectionsView;

import java.util.List;

@RepositoryRestResource(path = "electionvotes")
public interface VotesElectionsViewRepository extends CrudRepository<VotesElectionsView, Long> {

    List<VotesElectionsView> findByElection(String election);

    List<VotesElectionsView> findByLast_name(String election);

}
