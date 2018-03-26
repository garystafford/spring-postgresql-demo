package pcfdemo.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import pcfdemo.model.Vote;

public interface VoteRepository extends PagingAndSortingRepository<Vote, Long> {
}