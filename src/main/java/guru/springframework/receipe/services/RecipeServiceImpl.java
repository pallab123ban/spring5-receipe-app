package guru.springframework.receipe.services;

import guru.springframework.receipe.domain.Recipe;
import guru.springframework.receipe.repositories.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * @author PALLAB
 */
@Service
public class RecipeServiceImpl implements RecipeService{

    @Autowired
    RecipeRepository recipeRepository;

    @Override
    public Set<Recipe> getAllRecipe() {

        Set<Recipe> recipeList = new HashSet<>();
        recipeRepository.findAll().iterator().forEachRemaining(recipeList::add);
        return recipeList;
    }
}
