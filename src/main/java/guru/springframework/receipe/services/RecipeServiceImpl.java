package guru.springframework.receipe.services;

import guru.springframework.receipe.domain.Recipe;
import guru.springframework.receipe.repositories.RecipeRepository;
import java.util.HashSet;
import java.util.Set;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author PALLAB
 */
@Service
@Slf4j
public class RecipeServiceImpl implements RecipeService {

  @Autowired
  RecipeRepository recipeRepository;

  @Override
  public Set<Recipe> getAllRecipe() {
    log.debug("I'm in the service class");
    Set<Recipe> recipeList = new HashSet<>();
    recipeRepository.findAll().iterator().forEachRemaining(recipeList::add);
    return recipeList;
  }
}
