package guru.springframework.receipe.repositories;

import guru.springframework.receipe.domain.UnitOfMeasure;
import org.springframework.data.repository.CrudRepository;

/**
 * This is the unit of measure repository interface
 * @author PALLAB
 */
public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long> {
}
