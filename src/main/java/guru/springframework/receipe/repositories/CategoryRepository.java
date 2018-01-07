package guru.springframework.receipe.repositories;

import guru.springframework.receipe.domain.Category;
import org.springframework.data.repository.CrudRepository;

/**
 * This is the category repository interface
 * @author PALLAB
 */
public interface CategoryRepository extends CrudRepository<Category, Long> {
}
