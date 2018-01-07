package guru.springframework.receipe.repositories;

import guru.springframework.receipe.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

/**
 * Interface for recipe repository
 * @author PALLAB
 */
public interface RecipeRepository extends CrudRepository<Recipe, Long>{
}
