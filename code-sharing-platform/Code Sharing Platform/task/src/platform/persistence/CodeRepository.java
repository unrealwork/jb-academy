package platform.persistence;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CodeRepository extends CrudRepository<Code, Long> {
    List<Code> findByOrderByTsDesc(Pageable limit);
}
