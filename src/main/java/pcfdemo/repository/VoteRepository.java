package pcfdemo.repository;

import org.springframework.data.repository.CrudRepository;
import pcfdemo.model.Vote;

import java.util.List;

public interface VoteRepository extends CrudRepository<Vote, Long> {

//    List<Vote> findByElectionCandidate_Id(String Id);
}