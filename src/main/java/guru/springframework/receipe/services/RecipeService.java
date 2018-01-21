package guru.springframework.receipe.services;

import guru.springframework.receipe.domain.Recipe;
import java.util.Optional;
import java.util.Set;

/**
 * @author PALLAB
 */
public interface RecipeService {

  Set<Recipe> getAllRecipe();

  Recipe getRecipeById(Long l);
}
