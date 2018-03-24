package pcfdemo.repository;

import org.springframework.data.repository.CrudRepository;
import pcfdemo.model.Vote;

public interface VoteRepository extends CrudRepository<Vote, Long> {

//    List<Vote> findByElection_candidate_id(long electionCandidateId);
}