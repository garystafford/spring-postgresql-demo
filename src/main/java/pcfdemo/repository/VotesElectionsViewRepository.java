package pcfdemo.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import pcfdemo.model.VotesElectionsView;

import java.util.List;

@RepositoryRestResource(path = "election-votes")
public interface VotesElectionsViewRepository extends PagingAndSortingRepository<VotesElectionsView, Long> {

    List<VotesElectionsView> findByElection(String election);
}
