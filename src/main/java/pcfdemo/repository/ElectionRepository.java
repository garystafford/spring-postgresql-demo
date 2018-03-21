package pcfdemo.repository;

import org.springframework.data.repository.CrudRepository;
import pcfdemo.model.Election;
import java.util.List;

public interface ElectionRepository extends CrudRepository<Election, Long> {

    List<Election> findByTitle(String title);

    List<Election> findByDate(String date);

    List<Election> findByDescriptionContains(String description);

}
