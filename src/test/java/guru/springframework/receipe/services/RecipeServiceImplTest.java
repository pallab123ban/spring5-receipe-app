package guru.springframework.receipe.services;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.testng.Assert.assertEquals;

import guru.springframework.receipe.domain.Recipe;
import guru.springframework.receipe.repositories.RecipeRepository;
import java.util.HashSet;
import java.util.Set;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RecipeServiceImplTest {

  @InjectMocks
  private RecipeServiceImpl subject;

  @Mock
  RecipeRepository mockRecipeRepository;

  private Recipe recipe;

  private Set<Recipe> recipeList;

  @BeforeMethod
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);
    recipe = new Recipe();
    recipeList = new HashSet<>();
    recipeList.add(recipe);
    doReturn(recipeList).when(mockRecipeRepository).findAll();
  }

  @Test
  public void testGetAllRecipe() throws Exception {
    assertEquals(subject.getAllRecipe(), recipeList, "Recipe List : ");
    verify(mockRecipeRepository, times(1)).findAll();
  }
}